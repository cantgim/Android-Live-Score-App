package com.example.demolivescore.ui.detail;

import android.os.Bundle;

import com.example.demolivescore.R;
import com.example.demolivescore.fragments.main.SectionsPagerAdapter;
import com.example.demolivescore.model.MatchDetailData;
import com.example.demolivescore.service.MatchAPI;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.example.demolivescore.databinding.ActivityDetailMatchBinding;

public class DetailMatchActivity extends AppCompatActivity {

    private ActivityDetailMatchBinding binding;
    private TabLayout tabLayout;

    MatchAPI matchAPI;
    private MatchDetailData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailMatchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Bundle extras = getIntent().getExtras();
        Integer matchId = extras.getInt("match_id");

        String score = extras.getString("score");
        String home_name = extras.getString("home_name");
        String away_name = extras.getString("away_name");



        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        sectionsPagerAdapter.setMatch_id(matchId);
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