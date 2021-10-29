package com.example.demolivescore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.demolivescore.dto.ResultDto;
import com.example.demolivescore.model.Country;
import com.example.demolivescore.model.Data;
import com.example.demolivescore.model.Federation;
import com.example.demolivescore.service.CountryAPI;
import com.example.demolivescore.service.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    CountryAPI countryAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.responseText);
        countryAPI = RetrofitClient.getClient().create(CountryAPI.class);

        /**
         * GET list of countries
         */
        Call<ResultDto> call = countryAPI.getListOfCountries();
        call.enqueue(new Callback<ResultDto>() {
            @Override
            public void onResponse(Call<ResultDto> call, Response<ResultDto> response) {
                Log.d("Federation", response.code() + "");
                String displayResponse = "";

                ResultDto rsDto = response.body();
                Data data = rsDto.getData();
                for (Country item : data.getCountry()) {
                    displayResponse += item.getId() + " " + item.getName() + "\n";
                }
                responseText.setText(displayResponse);
            }

            @Override
            public void onFailure(Call<ResultDto> call, Throwable t) {
                call.cancel();
            }
        });
    }
 }