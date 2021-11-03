package com.example.demolivescore.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class TeamData {
    @SerializedName("country")
    @Expose
    private List<Country> country = null;

    @SerializedName("table")
    @Expose
    private List<Team> table = null;
}
