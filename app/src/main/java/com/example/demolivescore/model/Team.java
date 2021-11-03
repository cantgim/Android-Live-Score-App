package com.example.demolivescore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Team {
    @SerializedName("league_id")
    @Expose
    private String league_id;
    @SerializedName("session_id")
    @Expose
    private String session_id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("points")
    @Expose
    private String points;
    @SerializedName("matches")
    @Expose
    private String matches;
    @SerializedName("goal_diff")
    @Expose
    private String goal_diff;
    @SerializedName("team_id")
    @Expose
    private String team_id;
}