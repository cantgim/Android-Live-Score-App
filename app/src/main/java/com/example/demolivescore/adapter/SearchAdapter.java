package com.example.demolivescore.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.example.demolivescore.MainActivity;
import com.example.demolivescore.R;
import com.example.demolivescore.model.Country;
import com.example.demolivescore.service.FixtureAPI;
import com.example.demolivescore.ui.fixtures.FixturesActivity;
import com.example.demolivescore.ui.search.SearchActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<Country> countries;
    public SearchActivity searchActivity;

    private HashMap<String, Integer> competitionsMap = new HashMap<>();

    public Context context;

    public SearchAdapter(List<Country> countries){
        this.countries = countries;
        setCompetitionsMap();
    }

    public SearchAdapter(SearchActivity searchActivity, List<Country> countryList) {
        this.countries = countryList;
        this.searchActivity = searchActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countries.get(position);
        String countryId = country.getNationalTeam().getId();
        holder.name.setText(country.getName());
        Glide
                .with(context)
                .load("https://livescore-api.com/api-client/countries/flag.json?team_id="+countryId+"&key=PJRGYfC1NxmGPPnn&secret=8VPl12cJkrkOWbNLUErTU4VHBhoq6LNe")
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void filterList(ArrayList<Country> filteredList){
        countries = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(view.getContext(), "News" + countries.get(0).getName() + " is clicked ", Toast.LENGTH_LONG).show();
                    Integer competitionId = competitionsMap.get(countries.get(0).getName());
                    Intent intent = new Intent(context, FixturesActivity.class);
                    intent.putExtra("competition_id", competitionId);
                    context.startActivity(intent);
                }
            });
        }
    }

    private void setCompetitionsMap() {
        competitionsMap.put("Germany", 1);
        competitionsMap.put("England", 2);
        competitionsMap.put("Spain", 3);
        competitionsMap.put("Italy", 4);
        competitionsMap.put("France", 5);
    }
}
