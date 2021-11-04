package com.example.demolivescore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demolivescore.dto.MatchDetailDto;
import com.example.demolivescore.model.Match;
import com.example.demolivescore.model.MatchDetailData;
import com.example.demolivescore.service.MatchAPI;
import com.example.demolivescore.service.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatisticFragment extends Fragment {

    MatchAPI matchAPI;
    private MatchDetailData data;

    private static final String MATCH_ID = "match_id";
    private static final String HOME = "home_name";
    private static final String AWAY = "away_name";
    private static final String SCORE = "score";

    // TODO: Rename and change types of parameters
    private Integer matchId;
    private String homeName;
    private String awayName;
    private String score;

    public StatisticFragment() {
        // Required empty public constructor
    }

    public static StatisticFragment newInstance(Integer matchId, String homeName, String awayName, String score ) {
        StatisticFragment fragment = new StatisticFragment();
        Bundle args = new Bundle();
        args.putInt(MATCH_ID, matchId);
        args.putString(HOME, homeName);
        args.putString(AWAY, awayName);
        args.putString(SCORE, score);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            matchId = getArguments().getInt(MATCH_ID);
            homeName = getArguments().getString(HOME);
            awayName = getArguments().getString(AWAY);
            score = getArguments().getString(SCORE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_statistic, container, false);
        matchAPI = RetrofitClient.getClient().create(MatchAPI.class);
        Call<MatchDetailDto> call = matchAPI.getMatchStatistic(matchId);
        call.enqueue(new Callback<MatchDetailDto>() {
            @Override
            public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {
                MatchDetailDto matchDetailDto = response.body();
                try{
                    data = matchDetailDto.getData();
                }catch (NullPointerException exception){
                    data = new MatchDetailData();
                    data.setShotsOnTarget("");
                    data.setShotsOffTarget("");
                    data.setCorners("");
                    data.setOffsides("");
                    data.setRedCards("");
                    data.setYellowCards("");
                    data.setPossesion("");
                }
            }

            @Override
            public void onFailure(Call<MatchDetailDto> call, Throwable t) {
                call.cancel();
            }
        });

        TextView txtScore = view.findViewById(R.id.txtScore);
        txtScore.setText(score);

        //set home stat
        TextView txtHome = view.findViewById(R.id.txtHome);
        txtHome.setText(homeName);
        TextView txtHomeOnTarget = view.findViewById(R.id.txtHomeOnTarget);
        TextView txtAway = view.findViewById(R.id.txtAway);
        txtAway.setText(awayName);

        if(data != null){
            TextView txtAwayOnTarget = view.findViewById(R.id.txtAwayOnTarget);
            txtAwayOnTarget.setText(getAwayData(data.getShotsOnTarget()));
            TextView txtAwayOffTarget = view.findViewById(R.id.txtAwayOffTarget);
            txtAwayOffTarget.setText(getAwayData(data.getShotsOffTarget()));
            TextView txtAwayPossession = view.findViewById(R.id.txtAwayPossession);
            txtAwayPossession.setText(getAwayData(data.getPossesion()));
            TextView txtAwayOffside = view.findViewById(R.id.txtAwayOffside);
            txtAwayOffside.setText(getAwayData(data.getOffsides()));
            TextView txtAwayConner = view.findViewById(R.id.txtAwayConner);
            txtAwayConner.setText(getAwayData(data.getCorners()));
            TextView txtAwayYellowCard = view.findViewById(R.id.txtAwayYellowCard);
            txtAwayYellowCard.setText(getAwayData(data.getYellowCards()));
            TextView txtAwayRedCard = view.findViewById(R.id.txtAwayRedCard);
            txtAwayRedCard.setText(getAwayData(data.getRedCards()));

            txtHomeOnTarget.setText(getHomeData(data.getShotsOnTarget()));
            TextView txtHomeOffTarget = view.findViewById(R.id.txtHomeOfftarget);
            txtHomeOffTarget.setText(getHomeData(data.getShotsOffTarget()));
            TextView txtHomePossession = view.findViewById(R.id.txtHomePossession);
            txtHomePossession.setText(getHomeData(data.getPossesion()));
            TextView txtHomeOffside = view.findViewById(R.id.txtHomeOffsides);
            txtHomeOffside.setText(getHomeData(data.getOffsides()));
            TextView txtHomeConner = view.findViewById(R.id.txtHomeConner);
            txtHomeConner.setText(getHomeData(data.getCorners()));
            TextView txtHomeYellowCard = view.findViewById(R.id.txtHomeYellowCard);
            txtHomeYellowCard.setText(getHomeData(data.getYellowCards()));
            TextView txtHomeRedCard = view.findViewById(R.id.txtHomeRedCard);
            txtHomeRedCard.setText(getHomeData(data.getRedCards()));
        }

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

    }

    private String getHomeData(String raw_data){
        if(raw_data.isEmpty()|| raw_data==null){
            return "";
        }
        return raw_data.substring(0,raw_data.indexOf(":")).trim();
    }

    private String getAwayData(String raw_data){
        if(raw_data.isEmpty()|| raw_data==null){
            return "";
        }
        return raw_data.substring(raw_data.indexOf(":")+1).trim();
    }
}