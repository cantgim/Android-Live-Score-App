
package com.example.demolivescore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Country {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_real")
    @Expose
    private String isReal;
    @SerializedName("leagues")
    @Expose
    private String leagues;
    @SerializedName("scores")
    @Expose
    private String scores;
    @SerializedName("national_team")
    @Expose
    private NationalTeam nationalTeam;
    @SerializedName("federation")
    @Expose
    private Federation federation;

}
