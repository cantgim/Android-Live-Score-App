package com.example.demolivescore.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Match {

    @SerializedName("scheduled")
    @Expose
    private String scheduled;
    @SerializedName("competition_id")
    @Expose
    private Integer competitionId;
    @SerializedName("ps_score")
    @Expose
    private String psScore;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("odds")
    @Expose
    private Odds odds;
    @SerializedName("last_changed")
    @Expose
    private String lastChanged;
    @SerializedName("competition_name")
    @Expose
    private String competitionName;
    @SerializedName("home_id")
    @Expose
    private Integer homeId;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("away_name")
    @Expose
    private String awayName;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("away_id")
    @Expose
    private Integer awayId;
    @SerializedName("ht_score")
    @Expose
    private String htScore;
    @SerializedName("home_name")
    @Expose
    private String homeName;
    @SerializedName("added")
    @Expose
    private String added;
    @SerializedName("h2h")
    @Expose
    private String h2h;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("has_lineups")
    @Expose
    private Boolean hasLineups;
    @SerializedName("ft_score")
    @Expose
    private String ftScore;
    @SerializedName("events")
    @Expose
    private String events;
    @SerializedName("fixture_id")
    @Expose
    private Integer fixtureId;
    @SerializedName("et_score")
    @Expose
    private String etScore;
    @SerializedName("outcomes")
    @Expose
    private Outcomes outcomes;
    @SerializedName("info")
    @Expose
    private String info;

}