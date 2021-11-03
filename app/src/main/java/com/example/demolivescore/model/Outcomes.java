package com.example.demolivescore.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Outcomes {

    @SerializedName("half_time")
    @Expose
    private String halfTime;
    @SerializedName("full_time")
    @Expose
    private String fullTime;
    @SerializedName("extra_time")
    @Expose
    private Object extraTime;

}