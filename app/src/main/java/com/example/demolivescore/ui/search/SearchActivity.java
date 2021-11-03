package com.example.demolivescore.ui.search;

import android.os.Bundle;

import com.example.demolivescore.adapter.SearchAdapter;
import com.example.demolivescore.dto.CountryDto;
import com.example.demolivescore.model.Country;
import com.example.demolivescore.model.CountryData;
import com.example.demolivescore.service.CountryAPI;
import com.example.demolivescore.service.RetrofitClient;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demolivescore.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    CountryAPI countryAPI;
    EditText editText;
    List<Country> countries = new ArrayList<>();
    SearchAdapter mSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        countryAPI = RetrofitClient.getClient().create(CountryAPI.class);

        RecyclerView recyclerView = findViewById(R.id.search_recycler_view);

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
        Call<CountryDto> call = countryAPI.getListOfCountries();
        call.enqueue(new Callback<CountryDto>() {
            @Override
            public void onResponse(Call<CountryDto> call, Response<CountryDto> response) {
                CountryDto rsDto = response.body();
                CountryData countryData = rsDto.getData();
                for (Country country : countryData.getCountry()) {
                    if(country.getName().equals("England") || country.getName().equals("Italy") || country.getName().equals("Spain")
                            || country.getName().equals("Germany") || country.getName().equals("France")){
                        countries.add(country);
                    }
                }
                mSearchAdapter = new SearchAdapter(countries);
                mSearchAdapter.context = getApplicationContext();
                recyclerView.setAdapter(mSearchAdapter);

                // mSearchAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CountryDto> call, Throwable t) {
                call.cancel();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void filter(String text) {
        ArrayList<Country> filteredList = new ArrayList<>();

        for (Country item: countries) {
            if(item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        mSearchAdapter.filterList(filteredList);
    }
}