package com.example.demolivescore.adapter;

import android.content.Context;
import android.icu.util.LocaleData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demolivescore.R;
import com.example.demolivescore.model.Fixture;
import com.example.demolivescore.model.Team;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.ViewHolder> {
    List<Fixture> fixtures;
    public Context context;

    public FixturesAdapter(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

    public FixturesAdapter(List<Fixture> fixtures, Context context) {
        this.fixtures = fixtures;
        this.context = context;
    }

    @NonNull
    @Override
    public FixturesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_item, parent, false);
        return new FixturesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FixturesAdapter.ViewHolder holder, int position) {
        Fixture fixture = this.fixtures.get(position);
        holder.home.setText(fixture.getHomeName());
        holder.away.setText(fixture.getAwayName());
        holder.status.setText(fixture.getTime().substring(0, 5));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(fixture.getDate(), formatter);
        String txtDate = date.getDayOfMonth() + " " + date.getMonth().toString().substring(0, 3);
        holder.date.setText(txtDate);
    }

    @Override
    public int getItemCount() {
        return fixtures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView status;
        private TextView home;
        private TextView away;
        private ImageView home_logo;
        private ImageView away_logo;
        private TextView homeScore;
        private TextView awayScore;
        private TextView date;


        public ViewHolder(@androidx.annotation.NonNull View itemView){
            super(itemView);
            status = itemView.findViewById(R.id.txtMatchStatus);
            home = itemView.findViewById(R.id.txtHomeName);
            away = itemView.findViewById(R.id.txtAwayName);
            home_logo = itemView.findViewById(R.id.imageView);
            away_logo = itemView.findViewById(R.id.imageView2);
            homeScore = itemView.findViewById(R.id.txtHomeScore);
            awayScore = itemView.findViewById(R.id.txtAwayScore);
            date = itemView.findViewById(R.id.txtMatchDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Fixtures" + (getAdapterPosition() + 1) + " is clicked ", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
