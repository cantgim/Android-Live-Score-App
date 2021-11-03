package com.example.demolivescore.ui.detail;

import android.os.Bundle;

import com.example.demolivescore.R;
import com.example.demolivescore.dto.MatchDetailDto;
import com.example.demolivescore.model.MatchDetailData;
import com.example.demolivescore.service.MatchAPI;
import com.example.demolivescore.service.RetrofitClient;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.demolivescore.fragments.main.SectionsPagerAdapter;
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