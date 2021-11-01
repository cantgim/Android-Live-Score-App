package com.example.demolivescore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.demolivescore.dto.ResultDto;
import com.example.demolivescore.model.Data;
import com.example.demolivescore.model.Team;
import com.example.demolivescore.service.CountryAPI;
import com.example.demolivescore.service.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    CountryAPI countryAPI;
    RecyclerAdapterStanding adapterStanding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        responseText = (TextView) findViewById(R.id.responseText);
        countryAPI = RetrofitClient.getClient().create(CountryAPI.class);

        ArrayList<Team> teams = new ArrayList<>();
        RecyclerView view = findViewById(R.id.recyclerViewStanding);
        /**
         * GET list of countries
         */
        Call<ResultDto> call = countryAPI.getListLeagueStanding();
        call.enqueue(new Callback<ResultDto>() {
            @Override
            public void onResponse(Call<ResultDto> call, Response<ResultDto> response) {
                Log.d("Federation", response.code() + "");
                String displayResponse = "";

                ResultDto rsDto = response.body();
                Data data = rsDto.getData();
                for (Team team : data.getTable()) {
                      teams.add(team);
//                      displayResponse += team.getName() + team.getRank() +
//                                        team.getMatches() + team.getPoints();
                }
//                responseText.setText(displayResponse);
                adapterStanding = new RecyclerAdapterStanding(teams);
                adapterStanding.context = getApplicationContext();
                view.setAdapter(adapterStanding);


            }

            @Override
            public void onFailure(Call<ResultDto> call, Throwable t) {
                call.cancel();
            }
        });

        view.setLayoutManager(new LinearLayoutManager(this));

    }
 }