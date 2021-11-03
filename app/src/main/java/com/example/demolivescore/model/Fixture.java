
package com.example.demolivescore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Fixture {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("time")
    @Expose
    public String time;
    @SerializedName("round")
    @Expose
    public String round;
    @SerializedName("home_name")
    @Expose
    public String homeName;
    @SerializedName("away_name")
    @Expose
    public String awayName;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("league_id")
    @Expose
    public String leagueId;
    @SerializedName("competition_id")
    @Expose
    public String competitionId;
    @SerializedName("home_id")
    @Expose
    public String homeId;
    @SerializedName("away_id")
    @Expose
    public String awayId;
    @SerializedName("competition")
    @Expose
    public Competition competition;
    @SerializedName("league")
    @Expose
    public League league;

}
