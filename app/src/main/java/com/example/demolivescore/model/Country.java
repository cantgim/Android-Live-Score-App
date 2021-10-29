
package com.example.demolivescore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsReal() {
        return isReal;
    }

    public void setIsReal(String isReal) {
        this.isReal = isReal;
    }

    public String getLeagues() {
        return leagues;
    }

    public void setLeagues(String leagues) {
        this.leagues = leagues;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public NationalTeam getNationalTeam() {
        return nationalTeam;
    }

    public void setNationalTeam(NationalTeam nationalTeam) {
        this.nationalTeam = nationalTeam;
    }

    public Federation getFederation() {
        return federation;
    }

    public void setFederation(Federation federation) {
        this.federation = federation;
    }

}
