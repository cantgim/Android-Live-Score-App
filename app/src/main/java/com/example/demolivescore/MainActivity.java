package com.example.demolivescore;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.demolivescore.fragments.favorites.FavoritesFragment;
import com.example.demolivescore.fragments.fixtures.FixturesFragment;
import com.example.demolivescore.fragments.news.NewsFragment;
import com.example.demolivescore.fragments.scores.ScoresFragment;
//import com.example.demolivescore.fragments.search.SearchFragment;
import com.example.demolivescore.fragments.standing.FragmentStanding;
import com.example.demolivescore.ui.detail.DetailMatchActivity;
import com.example.demolivescore.ui.search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.pnikosis.materialishprogress.ProgressWheel;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnSearch;
    private FrameLayout progressOverlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressOverlay = findViewById(R.id.progress_overlay);
        progressOverlay.setVisibility(View.VISIBLE);
        //toolBar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_bottom);
        navigation.setOnItemSelectedListener(mOnItemSelectedListener);

        btnSearch = findViewById(R.id.search_button);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fragment = new SearchFragment();
//                loadFragment(fragment);
                Intent myIntent = new Intent(MainActivity.this, SearchActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        //toolBar.setTitle("Scores");
        loadFragment(new ScoresFragment());
    }

    private NavigationBarView.OnItemSelectedListener mOnItemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_scores:
                    //toolBar.setTitle("Scores");
                    fragment = new ScoresFragment();
                    // fragment = new FragmentStanding();
                    loadFragment(fragment);
//                    Intent myIntent = new Intent(MainActivity.this, DetailMatchActivity.class);
//                    MainActivity.this.startActivity(myIntent);
                    return true;
                case R.id.navigation_favorites:
                    fragment = new FragmentStanding();
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
                    fragment = new FixturesFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        setVisible();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        setInvisible();
    }

    public void setInvisible() {
        progressOverlay.setVisibility(View.INVISIBLE);
    }
    public void setVisible() {
        progressOverlay.setVisibility(View.VISIBLE);
    }
 }