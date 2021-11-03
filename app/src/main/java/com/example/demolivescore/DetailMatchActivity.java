package com.example.demolivescore;

import android.os.Bundle;

import com.example.demolivescore.dto.MatchDetailDto;
import com.example.demolivescore.model.MatchDetailData;
import com.example.demolivescore.service.MatchAPI;
import com.example.demolivescore.service.RetrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demolivescore.ui.main.SectionsPagerAdapter;
import com.example.demolivescore.databinding.ActivityDetailMatchBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMatchActivity extends AppCompatActivity {

    private ActivityDetailMatchBinding binding;
    private String[] tabs = {"Statistic", "Ranking"};
    private TabLayout tabLayout;

    MatchAPI matchAPI;
    private MatchDetailData data;
    public static int[] resourceIds = {R.layout.fragment_statistic, R.layout.fragment_detail_match};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailMatchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        Bundle extras = getIntent().getExtras();
        String matchId = extras.getString("match_id");

        String score = extras.getString("score");
        String home_name = extras.getString("home_name");
        String away_name = extras.getString("away_name");

        matchAPI = RetrofitClient.getClient().create(MatchAPI.class);
        Call<MatchDetailDto> call = matchAPI.getMatchStatistic(matchId);
        call.enqueue(new Callback<MatchDetailDto>() {
            @Override
            public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {
                MatchDetailDto matchDetailDto = response.body();
                data = matchDetailDto.getData();
            }

            @Override
            public void onFailure(Call<MatchDetailDto> call, Throwable t) {
                call.cancel();
            }
        });

        TextView txtScore = this.findViewById(R.id.txtScore);
        txtScore.setText(score);
        TextView txtHome = this.findViewById(R.id.txtHome);
        txtHome.setText(home_name);
        ImageView imgHome = this.findViewById(R.id.imgHome);

        TextView txtHomeOnTarget = this.findViewById(R.id.txtHomeOnTarget);
        txtHomeOnTarget.setText(getHomeData(data.getShotsOnTarget()));
        TextView txtHomeOffTarget = this.findViewById(R.id.txtHomeOfftarget);
        txtHomeOffTarget.setText(getHomeData(data.getShotsOffTarget()));
        TextView txtHomePossession = this.findViewById(R.id.txtHomePossession);
        txtHomePossession.setText(getHomeData(data.getPossesion()));
        TextView txtHomeOffside = this.findViewById(R.id.txtHomeOffsides);
        txtHomeOffside.setText(getHomeData(data.getOffsides()));
        TextView txtHomeYellowCard = this.findViewById(R.id.txtHomeYellowCard);
        txtHomeYellowCard.setText(getHomeData(data.getYellowCards()));
        TextView txtHomeRedCard = this.findViewById(R.id.txtHomeRedCard);
        txtHomeRedCard.setText(getHomeData(data.getRedCards()));
        TextView txtHomeConner = this.findViewById(R.id.txtHomeConner);
        txtHomeConner.setText(getHomeData(data.getCorners()));

        TextView txtAway = this.findViewById(R.id.txtAway);
        txtAway.setText(away_name);
        ImageView imgAway = this.findViewById(R.id.imgAway);
        TextView txtAwayOnTarget = this.findViewById(R.id.txtAwayOnTarget);
        txtAwayOnTarget.setText(getAwayData(data.getShotsOnTarget()));
        TextView txtAwayOffTarget = this.findViewById(R.id.txtAwayOffTarget);
        txtAwayOffTarget.setText(getAwayData(data.getShotsOffTarget()));
        TextView txtAwayPossession = this.findViewById(R.id.txtAwayPossession);
        txtAwayPossession.setText(getAwayData(data.getPossesion()));
        TextView txtAwayOffside = this.findViewById(R.id.txtAwayOffside);
        txtAwayOffside.setText(getAwayData(data.getOffsides()));
        TextView txtAwayYellowCard = this.findViewById(R.id.txtAwayYellowCard);
        txtAwayYellowCard.setText(getAwayData(data.getYellowCards()));
        TextView txtAwayRedCard = this.findViewById(R.id.txtAwayRedCard);
        txtAwayRedCard.setText(getAwayData(data.getYellowCards()));
        TextView txtAwayConner = this.findViewById(R.id.txtAwayConner);
        txtAwayConner.setText(getAwayData(data.getCorners()));

    }
    public String getHomeData(String raw_data){
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