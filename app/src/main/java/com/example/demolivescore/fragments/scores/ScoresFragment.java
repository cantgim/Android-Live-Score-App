package com.example.demolivescore.fragments.scores;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.demolivescore.R;
import com.example.demolivescore.adapter.LiveScoreAdapter;
import com.example.demolivescore.adapter.RecyclerAdapterStanding;
import com.example.demolivescore.dto.LiveScoreDto;
import com.example.demolivescore.dto.TeamDto;
import com.example.demolivescore.model.LiveScoreData;
import com.example.demolivescore.model.Match;
import com.example.demolivescore.model.Team;
import com.example.demolivescore.model.TeamData;
import com.example.demolivescore.service.CountryAPI;
import com.example.demolivescore.service.LiveScoreAPI;
import com.example.demolivescore.service.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoresFragment extends Fragment {

    public ScoresFragment() {
        // Required empty public constructor
    }

    public static ScoresFragment newInstance(String param1, String param2) {
        ScoresFragment fragment = new ScoresFragment();
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
        return inflater.inflate(R.layout.activity_livescore, container, false);
    }

    LiveScoreAPI liveScoreAPI;
    RecyclerView recyclerView;
    LiveScoreAdapter liveScoreAdapter;
    ArrayList<Match> matches;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        liveScoreAPI = RetrofitClient.getClient().create(LiveScoreAPI.class);
        recyclerView = view.findViewById(R.id.liveScoreView);
        liveScoreAdapter = new LiveScoreAdapter();

        Call<LiveScoreDto> call = liveScoreAPI.getLiveScore();
        matches = new ArrayList<>();
        call.enqueue(new Callback<LiveScoreDto>() {
            @Override
            public void onResponse(Call<LiveScoreDto> call, Response<LiveScoreDto> response) {
                LiveScoreDto lsDto = response.body();
                LiveScoreData data = lsDto.getData();
                for(Match match : data.getMatch()){
                    matches.add(match);
                }

                liveScoreAdapter.setMatches(matches);
                liveScoreAdapter.setMContext(getActivity().getApplicationContext());
                recyclerView.setAdapter(liveScoreAdapter);
            }

            @Override
            public void onFailure(Call<LiveScoreDto> call, Throwable t) {
                call.cancel();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }
}