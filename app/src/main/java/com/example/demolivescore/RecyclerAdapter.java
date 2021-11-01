package com.example.demolivescore;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.demolivescore.model.Country;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<Country> countries;
    MainActivity mainActivity;
    Context context;

    public RecyclerAdapter(ArrayList<Country> countries){
        this.countries = countries;
    }

    public RecyclerAdapter(ArrayList<Country> countries, MainActivity mainActivity) {
        this.countries = countries;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Item" + (getAdapterPosition() + 1) + " is clicked ", Toast.LENGTH_LONG).show();
                }
            });
        }


    }

    public void filterList(ArrayList<Country> filteredList){
        countries = filteredList;
        notifyDataSetChanged();
    }

}
