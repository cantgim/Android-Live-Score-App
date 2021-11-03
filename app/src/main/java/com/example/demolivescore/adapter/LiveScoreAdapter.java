package com.example.demolivescore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demolivescore.R;
import com.example.demolivescore.model.Match;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LiveScoreAdapter extends RecyclerView.Adapter<LiveScoreAdapter.ViewHolder> {
    private ArrayList<Match> matches;
    private Context mContext;

    @androidx.annotation.NonNull
    @Override
    public ViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View liveScoreView = inflater.inflate(R.layout.score_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(liveScoreView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull ViewHolder holder, int position) {
        Match match = matches.get(position);
        holder.status.setText("Live");
        holder.away.setText(match.getAwayName());
        holder.awayScore.setText(match.getScore().substring(4).trim());
        holder.home.setText(match.getHomeName());
        holder.homeScore.setText(match.getScore().substring(0,2).trim());

    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView status;
        private TextView home;
        private TextView away;
        private ImageView home_logo;
        private ImageView away_logo;
        private TextView homeScore;
        private TextView awayScore;

        public ViewHolder(@androidx.annotation.NonNull View itemView){
            super(itemView);
            status = itemView.findViewById(R.id.txtMatchStatus);
            home = itemView.findViewById(R.id.txtHomeName);
            away = itemView.findViewById(R.id.txtAwayName);
            home_logo = itemView.findViewById(R.id.imageView);
            away_logo = itemView.findViewById(R.id.imageView2);
            homeScore = itemView.findViewById(R.id.txtHomeScore);
            awayScore = itemView.findViewById(R.id.txtAwayScore);

        }
    }
}