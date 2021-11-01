
package com.example.demolivescore.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

    public String getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(String halfTime) {
        this.halfTime = halfTime;
    }

    public String getFullTime() {
        return fullTime;
    }

    public void setFullTime(String fullTime) {
        this.fullTime = fullTime;
    }

    public Object getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(Object extraTime) {
        this.extraTime = extraTime;
    }

}
