package com.example.demolivescore.ui.fixtures;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.demolivescore.R;
import com.example.demolivescore.adapter.FixturesAdapter;
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

public class FixturesActivity extends AppCompatActivity {

     RecyclerView recyclerView;
     List<Fixture> matchList = new ArrayList<>();
     FixturesAdapter mFixturesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Fixtures");
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        FixtureAPI fixtureAPI = RetrofitClient.getClient().create(FixtureAPI.class);
        recyclerView = findViewById(R.id.list_match_recycler);
        Integer competitionId = getIntent().getIntExtra("competition_id", -1);
        Call<FixturesDto> call = fixtureAPI.getFixturesByCompetition(competitionId);
        call.enqueue(new Callback<FixturesDto>(){

            @Override
            public void onResponse(Call<FixturesDto> call, Response<FixturesDto> response) {
                FixturesDto fixturesDto = response.body();
                FixtureData fixtureData = fixturesDto.getData();
                matchList.addAll(fixtureData.getFixtures());

                mFixturesAdapter = new FixturesAdapter(matchList);
                mFixturesAdapter.context = getApplicationContext();
                recyclerView.setAdapter(mFixturesAdapter);

                // refreshing recycler view
                // mFixturesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<FixturesDto> call, Throwable t) {
                call.cancel();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}