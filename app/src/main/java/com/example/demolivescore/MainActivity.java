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
    RecyclerView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        responseText = (TextView) findViewById(R.id.responseText);
        countryAPI = RetrofitClient.getClient().create(CountryAPI.class);

        ArrayList<Team> teams = new ArrayList<>();
        view = findViewById(R.id.recyclerViewStanding);
        /**
         * GET list of countries
         */
//        Call<ResultDto> call = countryAPI.getListLeagueStanding();
//        call.enqueue(new Callback<ResultDto>() {
//            @Override
//            public void onResponse(Call<ResultDto> call, Response<ResultDto> response) {
//                Log.d("Federation", response.code() + "");
//
//                ResultDto rsDto = response.body();
//                Data data = rsDto.getData();
//                for (Team team : data.getTable()) {
//                      teams.add(team);
//                }
//
//                adapterStanding = new RecyclerAdapterStanding(teams);
//                adapterStanding.context = getApplicationContext();
//                view.setAdapter(adapterStanding);
//                view.setLayoutManager(new LinearLayoutManager());
//
//            }
//
//            @Override
//            public void onFailure(Call<ResultDto> call, Throwable t) {
//                call.cancel();
//            }
//        });



    }

}