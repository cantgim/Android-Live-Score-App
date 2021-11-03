package com.example.demolivescore.dto;

import com.example.demolivescore.model.TeamData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class TeamDto {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private TeamData data;
}
