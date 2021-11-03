package com.example.demolivescore.fragments.standing;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        countryAPI = RetrofitClient.getClient().create(CountryAPI.class);
        recyclerView = view.findViewById(R.id.recyclerViewStanding);
        Call<TeamDto> call = countryAPI.getListLeagueStanding();
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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }
}