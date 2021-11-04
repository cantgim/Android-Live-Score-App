package com.example.demolivescore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.demolivescore.dto.LiveScoreDto;
import com.example.demolivescore.dto.ResultDto;
import com.example.demolivescore.model.Country;
import com.example.demolivescore.model.Data;
import com.example.demolivescore.model.Federation;
import com.example.demolivescore.model.LiveScoreData;
import com.example.demolivescore.model.Match;
import com.example.demolivescore.service.CountryAPI;
import com.example.demolivescore.service.LiveScoreAPI;
import com.example.demolivescore.service.PastMatchesAPI;
import com.example.demolivescore.service.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    CountryAPI countryAPI;
    LiveScoreAPI liveScoreAPI;
    PastMatchesAPI pastMatchesAPI;
    RecyclerView recyclerView;
    LiveScoreAdapter liveScoreAdapter;
    ArrayList<Match> matches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //responseText = (TextView) findViewById(R.id.responseText);
        //countryAPI = RetrofitClient.getClient().create(CountryAPI.class);
        liveScoreAPI = RetrofitClient.getClient().create(LiveScoreAPI.class);
        pastMatchesAPI = RetrofitClient.getClient().create(PastMatchesAPI.class);
        recyclerView = findViewById(R.id.liveScoreView);
        matches = new ArrayList<>();

        /**
         * GET list of countries
         */
//        Call<ResultDto> call = countryAPI.getListOfCountries();
//        call.enqueue(new Callback<ResultDto>() {
//            @Override
//            public void onResponse(Call<ResultDto> call, Response<ResultDto> response) {
//                Log.d("Federation", response.code() + "");
//                String displayResponse = "";
//
//                ResultDto rsDto = response.body();
//                Data data = rsDto.getData();
//                for (Country item : data.getCountry()) {
//                    displayResponse += item.getId() + " " + item.getName() + "\n";
//                }
//                responseText.setText(displayResponse);
//            }
//
//            @Override
//            public void onFailure(Call<ResultDto> call, Throwable t) {
//                call.cancel();
//            }
//        });
        liveScoreAdapter = new LiveScoreAdapter();

        Call<LiveScoreDto> call = liveScoreAPI.getLiveScore();
        call.enqueue(new Callback<LiveScoreDto>() {
            @Override
            public void onResponse(Call<LiveScoreDto> call, Response<LiveScoreDto> response) {
                LiveScoreDto lsDto = response.body();
                LiveScoreData data = lsDto.getData();

                for(Match match : data.getMatch()){
                    matches.add(match);

                }
//                responseText.setText(displayResponse);
                //matches = (ArrayList<Match>) data.getMatch();
                liveScoreAdapter.setMatches(matches);
                liveScoreAdapter.setMContext(getApplicationContext());
                recyclerView.setAdapter(liveScoreAdapter);
            }

            @Override
            public void onFailure(Call<LiveScoreDto> call, Throwable t) {
                call.cancel();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
 }