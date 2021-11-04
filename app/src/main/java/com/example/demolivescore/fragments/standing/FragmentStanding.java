package com.example.demolivescore.fragments.standing;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demolivescore.R;
import com.example.demolivescore.adapter.RecyclerAdapterStanding;
import com.example.demolivescore.dto.TeamDto;
import com.example.demolivescore.model.Team;
import com.example.demolivescore.model.TeamData;
import com.example.demolivescore.service.CountryAPI;
import com.example.demolivescore.service.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentStanding extends Fragment {

    public FragmentStanding() {
        // Required empty public constructor
    }

    public static FragmentStanding newInstance(String param1, String param2) {
        FragmentStanding fragment = new FragmentStanding();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standing, container, false);
    }

    RecyclerView recyclerView;
    CountryAPI countryAPI;
    RecyclerAdapterStanding adapterStanding;
    ArrayList<Team> teams = new ArrayList<>();
    Spinner spinner;
    String league[] = {"Premier League","Laliga","Bundesliga","Series A","League 1"};
    Call<TeamDto> call;

    public void getTeam(Call<TeamDto> call, View view){
        call.enqueue(new Callback<TeamDto>() {
            @Override
            public void onResponse(Call<TeamDto> call, Response<TeamDto> response) {
                TeamDto rsDto = response.body();
                TeamData data = rsDto.getData();
                for (Team team : data.getTable()) {
                    teams.add(team);
                }

                adapterStanding = new RecyclerAdapterStanding(teams);
                adapterStanding.context = getActivity().getApplicationContext();
                recyclerView.setAdapter(adapterStanding);


            }

            @Override
            public void onFailure(Call<TeamDto> call, Throwable t) {
                call.cancel();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        countryAPI = RetrofitClient.getClient().create(CountryAPI.class);
        recyclerView = view.findViewById(R.id.recyclerViewStanding);


        spinner = view.findViewById(R.id.spinnerSearchLeague);
        ArrayAdapter<String> adapter = new ArrayAdapter(view.getContext(),
                android.R.layout.simple_spinner_item, league);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter = adapterView.getAdapter();
                String league = (String) adapter.getItem(i);
                teams.removeAll(teams);
                if(league.equals("Premier League")){
                    call = countryAPI.getListLeagueStanding();
                    getTeam(call, view);
                }
                if(league.equals("Laliga")){
                    call = countryAPI.getListLeagueStandingLaliga();
                    getTeam(call, view);
                }

                if(league.equals("Bundesliga")){
                    call = countryAPI.getListLeagueStandingGermany();
                    getTeam(call, view);
                }

                if(league.equals("Series A")){
                    call = countryAPI.getListLeagueStandingItalia();
                    getTeam(call, view);
                }

                if(league.equals("League 1")){
                    call = countryAPI.getListLeagueStandingFrance();
                    getTeam(call, view);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }
}