package com.example.demolivescore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flag {
    @SerializedName("country_id")
    @Expose
    private String country_id;
    @SerializedName("team_id")
    @Expose
    private String team_id;

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }
}
