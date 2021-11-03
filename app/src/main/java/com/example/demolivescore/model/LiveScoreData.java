package com.example.demolivescore.model;

import java.util.List;


import com.example.demolivescore.model.Match;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class LiveScoreData {

    @SerializedName("match")
    @Expose
    private List<Match> match = null;

}