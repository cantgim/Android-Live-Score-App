package com.example.demolivescore;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.demolivescore.ui.favorites.FavoritesFragment;
import com.example.demolivescore.ui.news.NewsFragment;
import com.example.demolivescore.ui.scores.ScoresFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolBar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_bottom);
        navigation.setOnItemSelectedListener(mOnItemSelectedListener);

        //toolBar.setTitle("Scores");
        loadFragment(new ScoresFragment());
        // countryAPI = RetrofitClient.getClient().create(CountryAPI.class);

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
    }

    private NavigationBarView.OnItemSelectedListener mOnItemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_scores:
                    //toolBar.setTitle("Scores");
                    fragment = new ScoresFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_favorites:
                    fragment = new FavoritesFragment();
                    loadFragment(fragment);
                    //toolBar.setTitle("Favorites");
                    return true;
                case R.id.navigation_news:
                    //toolBar.setTitle("News");
                    fragment = new NewsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_refresh:
                    //toolBar.setTitle("Refresh");
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
 }