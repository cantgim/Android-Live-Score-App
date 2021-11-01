package com.example.demolivescore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }

    public String getGoal_diff() {
        return goal_diff;
    }

    public void setGoal_diff(String goal_diff) {
        this.goal_diff = goal_diff;
    }
}
