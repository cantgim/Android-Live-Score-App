package com.example.demolivescore.fragments.fixtures;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.demolivescore.R;
import com.example.demolivescore.adapter.FixturesAdapter;
import com.example.demolivescore.adapter.RecyclerAdapterStanding;
import com.example.demolivescore.dto.FixturesDto;
import com.example.demolivescore.model.Fixture;
import com.example.demolivescore.model.FixtureData;
import com.example.demolivescore.service.FixtureAPI;
import com.example.demolivescore.service.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FixturesFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Fixture> matchList;
    private FixturesAdapter mFixturesAdapter;

    public FixturesFragment() {
        // Required empty public constructor
    }

    public static FixturesFragment newInstance(String param1, String param2) {
        FixturesFragment fragment = new FixturesFragment();
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
        View view = inflater.inflate(R.layout.fragment_list_match, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.list_match_recycler);
        matchList = new ArrayList<>();
        //mFixturesAdapter = new FixturesAdapter(matchList, getActivity());

        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
       // recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
       // mFixturesAdapter.context = getActivity().getApplicationContext();
        //recyclerView.setAdapter(mFixturesAdapter);
        //recyclerView.setNestedScrollingEnabled(false);
        FixtureAPI fixtureAPI = RetrofitClient.getClient().create(FixtureAPI.class);
        Call<FixturesDto> call = fixtureAPI.getFixturesByCompetition("2");
        // fetchFixtureItems();
        call.enqueue(new Callback<FixturesDto>(){

            @Override
            public void onResponse(Call<FixturesDto> call, Response<FixturesDto> response) {
                if (response == null) {
                    Toast.makeText(getActivity(), "Không thể tải lịch giải đấu", Toast.LENGTH_LONG).show();
                    return;
                }

                FixturesDto fixturesDto = response.body();
                FixtureData fixtureData = fixturesDto.getData();
                matchList.addAll(fixtureData.getFixtures());

                mFixturesAdapter = new FixturesAdapter(matchList);
                mFixturesAdapter.context = getActivity().getApplicationContext();
                recyclerView.setAdapter(mFixturesAdapter);

                // refreshing recycler view
                // mFixturesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<FixturesDto> call, Throwable t) {
                call.cancel();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void fetchFixtureItems(){
        FixtureAPI fixtureAPI = RetrofitClient.getClient().create(FixtureAPI.class);
        Call<FixturesDto> call = fixtureAPI.getFixturesByCompetition("2");
        call.enqueue(new Callback<FixturesDto>(){

            @Override
            public void onResponse(Call<FixturesDto> call, Response<FixturesDto> response) {
                if (response == null) {
                    Toast.makeText(getActivity(), "Không thể tải lịch giải đấu", Toast.LENGTH_LONG).show();
                    return;
                }

                FixturesDto fixturesDto = response.body();
                FixtureData fixtureData = fixturesDto.getData();
                matchList.addAll(fixtureData.getFixtures());

                // refreshing recycler view
                // mFixturesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<FixturesDto> call, Throwable t) {
                call.cancel();
            }
        });
    }

}