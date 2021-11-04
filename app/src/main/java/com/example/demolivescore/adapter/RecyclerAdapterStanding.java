package com.example.demolivescore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.demolivescore.R;
import com.example.demolivescore.model.Team;

import java.util.ArrayList;

public class RecyclerAdapterStanding extends RecyclerView.Adapter<RecyclerAdapterStanding.ViewHolder> {

    ArrayList<Team> teams;
    public RecyclerAdapterStanding(ArrayList<Team> teams) {
        this.teams = teams;
    }

    @NonNull
    @Override
    public RecyclerAdapterStanding.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.standing_layout, parent,false);
        return new ViewHolder(itemView);
    }

    public Context context;
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.textViewId.setText(team.getRank());
        holder.textViewName.setText(team.getName());
        holder.textViewMatch.setText(team.getMatches());
        holder.textViewGoalDiff.setText(team.getGoal_diff());
        holder.textViewPoint.setText(team.getPoints());
//        Glide.with(context)
//                .load("https://lsm-static-prod.livescore.com/medium/enet/9825.png")
//                .apply(new RequestOptions().override(100, 100))
//                .into(holder.imageView);
        switch (position){
            case 0:
                holder.imageView.setImageResource(R.drawable.chelsea);
                break;
            case 1:
                holder.imageView.setImageResource(R.drawable.liverpool);
                break;
            case 2:
                holder.imageView.setImageResource(R.drawable.mancity);
                break;
            case 3:
                holder.imageView.setImageResource(R.drawable.westham);
                break;
            case 4:
                holder.imageView.setImageResource(R.drawable.manu);
                break;
            case 5:
                holder.imageView.setImageResource(R.drawable.arsenal);
                break;
            case 6:
                holder.imageView.setImageResource(R.drawable.wolve);
                break;
            case 7:
                holder.imageView.setImageResource(R.drawable.brighton);
                break;
            case 8:
                holder.imageView.setImageResource(R.drawable.tottenham);
                break;
            case 9:
                holder.imageView.setImageResource(R.drawable.everton);
                break;
            case 10:
                holder.imageView.setImageResource(R.drawable.leicester);
                break;
            case 11:
                holder.imageView.setImageResource(R.drawable.brendfort);
                break;
            case 12:
                holder.imageView.setImageResource(R.drawable.crystal);
                break;
            case 13:
                holder.imageView.setImageResource(R.drawable.southamton);
                break;
            case 14:
                holder.imageView.setImageResource(R.drawable.aston);
                break;
            case 15:
                holder.imageView.setImageResource(R.drawable.watford);
                break;
            case 16:
                holder.imageView.setImageResource(R.drawable.leed);
                break;
            case 17:
                holder.imageView.setImageResource(R.drawable.burney);
                break;
            case 18:
                holder.imageView.setImageResource(R.drawable.newcastle);
                break;
            case 19:
                holder.imageView.setImageResource(R.drawable.norwich);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewId;
        ImageView imageView;
        TextView textViewName;
        TextView textViewMatch;
        TextView textViewGoalDiff;
        TextView textViewPoint;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewId);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewMatch = itemView.findViewById(R.id.textViewMatch);
            textViewGoalDiff = itemView.findViewById(R.id.textViewGoalDiff);
            textViewPoint = itemView.findViewById(R.id.textViewPoint);

        }
    }
}