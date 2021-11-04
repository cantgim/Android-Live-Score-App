package com.example.demolivescore.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.demolivescore.R;
import com.example.demolivescore.databinding.FragmentDetailMatchBinding;
import com.example.demolivescore.model.MatchDetailData;

import lombok.Data;

/**
 * A placeholder fragment containing a simple view.
 */

public class PlaceholderFragment extends Fragment {
    public static int[] resourceIds = {R.layout.fragment_statistic, R.layout.fragment_detail_match};

    private static final String ARG_SECTION_NUMBER = "section_number";

    //private FragmentDetailMatchBinding binding;

    private String homeName;
    private String awayName;
    private String score;
    private MatchDetailData data;

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public MatchDetailData getData() {
        return data;
    }

    public void setData(MatchDetailData data) {
        this.data = data;
    }

    public static PlaceholderFragment newInstance(int index, String homeName,String awayName, String score, MatchDetailData data) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        fragment.setHomeName(homeName);
        fragment.setAwayName(awayName);
        fragment.setScore(score);
        fragment.setData(data);
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);

        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        //binding = FragmentDetailMatchBinding.inflate(inflater, container, false);
        int index = getArguments().getInt(ARG_SECTION_NUMBER);
        View rootView = inflater.inflate(resourceIds[index], container, false);

        TextView txtScore = rootView.findViewById(R.id.txtScore);
        txtScore.setText(score);

        //set home stat
        TextView txtHome = rootView.findViewById(R.id.txtHome);
        txtHome.setText(homeName);
        TextView txtHomeOnTarget = rootView.findViewById(R.id.txtHomeOnTarget);
        TextView txtAway = rootView.findViewById(R.id.txtAway);
        txtAway.setText(awayName);

        if(data != null){
            TextView txtAwayOnTarget = rootView.findViewById(R.id.txtAwayOnTarget);
            txtAwayOnTarget.setText(getAwayData(data.getShotsOnTarget()));
            TextView txtAwayOffTarget = rootView.findViewById(R.id.txtAwayOffTarget);
            txtAwayOffTarget.setText(getAwayData(data.getShotsOffTarget()));
            TextView txtAwayPossession = rootView.findViewById(R.id.txtAwayPossession);
            txtAwayPossession.setText(getAwayData(data.getPossesion()));
            TextView txtAwayOffside = rootView.findViewById(R.id.txtAwayOffside);
            txtAwayOffside.setText(getAwayData(data.getOffsides()));
            TextView txtAwayConner = rootView.findViewById(R.id.txtAwayConner);
            txtAwayConner.setText(getAwayData(data.getCorners()));
            TextView txtAwayYellowCard = rootView.findViewById(R.id.txtAwayYellowCard);
            txtAwayYellowCard.setText(getAwayData(data.getYellowCards()));
            TextView txtAwayRedCard = rootView.findViewById(R.id.txtAwayRedCard);
            txtAwayRedCard.setText(getAwayData(data.getRedCards()));

            txtHomeOnTarget.setText(getHomeData(data.getShotsOnTarget()));
            TextView txtHomeOffTarget = rootView.findViewById(R.id.txtHomeOfftarget);
            txtHomeOffTarget.setText(getHomeData(data.getShotsOffTarget()));
            TextView txtHomePossession = rootView.findViewById(R.id.txtHomePossession);
            txtHomePossession.setText(getHomeData(data.getPossesion()));
            TextView txtHomeOffside = rootView.findViewById(R.id.txtHomeOffsides);
            txtHomeOffside.setText(getHomeData(data.getOffsides()));
            TextView txtHomeConner = rootView.findViewById(R.id.txtHomeConner);
            txtHomeConner.setText(getHomeData(data.getCorners()));
            TextView txtHomeYellowCard = rootView.findViewById(R.id.txtHomeYellowCard);
            txtHomeYellowCard.setText(getHomeData(data.getYellowCards()));
            TextView txtHomeRedCard = rootView.findViewById(R.id.txtHomeRedCard);
            txtHomeRedCard.setText(getHomeData(data.getRedCards()));
       }

//        pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
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