package com.example.demolivescore;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demolivescore.dto.ResultDto;
import com.example.demolivescore.model.Data;
import com.example.demolivescore.model.Team;
import com.example.demolivescore.service.CountryAPI;
import com.example.demolivescore.service.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentStanding#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentStanding extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentStanding() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentStanding.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentStanding newInstance(String param1, String param2) {
        FragmentStanding fragment = new FragmentStanding();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
        Call<ResultDto> call = countryAPI.getListLeagueStanding();
        call.enqueue(new Callback<ResultDto>() {
            @Override
            public void onResponse(Call<ResultDto> call, Response<ResultDto> response) {
                Log.d("Federation", response.code() + "");

                ResultDto rsDto = response.body();
                Data data = rsDto.getData();
                for (Team team : data.getTable()) {
                    teams.add(team);
                }

                adapterStanding = new RecyclerAdapterStanding(teams);
                adapterStanding.context = getActivity().getApplicationContext();
                recyclerView.setAdapter(adapterStanding);


            }

            @Override
            public void onFailure(Call<ResultDto> call, Throwable t) {
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