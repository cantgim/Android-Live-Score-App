package com.example.demolivescore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Country {
    private String id;
    private String name;
    @SerializedName("is_real")
    @Expose
    private String isReal;
    private String leagues;
    private String scores;
    @SerializedName("national_team")
    @Expose
    private NationalTeam nationalTeam;
    private Federation federation;
}
