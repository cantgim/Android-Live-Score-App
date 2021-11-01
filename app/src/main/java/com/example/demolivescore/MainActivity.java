package com.example.demolivescore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demolivescore.dto.ResultDto;
import com.example.demolivescore.model.Country;
import com.example.demolivescore.model.Data;
import com.example.demolivescore.service.CountryAPI;
import com.example.demolivescore.service.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    CountryAPI countryAPI;
    EditText editText;
    ArrayList<Country> countries = new ArrayList<>();
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countryAPI = RetrofitClient.getClient().create(CountryAPI.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerView2);

        editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

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
                for (Country country : data.getCountry()) {
                    if(country.getName().equals("England") || country.getName().equals("Italy") || country.getName().equals("Spain")
                            || country.getName().equals("Germany") || country.getName().equals("France")){
                        countries.add(country);
                    }
                }
                adapter = new RecyclerAdapter(countries);
                adapter.context = getApplicationContext();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResultDto> call, Throwable t) {
                call.cancel();
            }
        });

        //chon dang hien thi
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void filter(String text) {
        ArrayList<Country> filteredList = new ArrayList<>();

        for (Country item: countries) {
            if(item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
}