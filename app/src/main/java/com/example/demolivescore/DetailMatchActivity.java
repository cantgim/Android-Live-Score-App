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
    //private String[] tabs = {"Statistic", "Ranking"};
    private TabLayout tabLayout;

    MatchAPI matchAPI;
    private MatchDetailData data;
    public static int[] resourceIds = {R.layout.fragment_statistic, R.layout.fragment_detail_match};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailMatchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Bundle extras = getIntent().getExtras();
        String matchId = extras.getString("match_id");

        String score = extras.getString("score");
        String home_name = extras.getString("home_name");
        String away_name = extras.getString("away_name");
        boolean getAble = true;

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

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        sectionsPagerAdapter.setData(data);
        sectionsPagerAdapter.setHomeName(home_name);
        sectionsPagerAdapter.setAwayName(away_name);
        sectionsPagerAdapter.setScore(score);

        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }
}