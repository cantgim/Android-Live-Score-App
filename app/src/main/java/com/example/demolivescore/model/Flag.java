package com.example.demolivescore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Flag {
    @SerializedName("country_id")
    @Expose
    private String country_id;
    @SerializedName("team_id")
    @Expose
    private String team_id;
}
