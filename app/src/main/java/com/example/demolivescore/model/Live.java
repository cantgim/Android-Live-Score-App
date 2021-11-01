
package com.example.demolivescore.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Live {

    @SerializedName("X")
    @Expose
    private Integer x;
    @SerializedName("1")
    @Expose
    private Double _1;
    @SerializedName("2")
    @Expose
    private Double _2;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Double get1() {
        return _1;
    }

    public void set1(Double _1) {
        this._1 = _1;
    }

    public Double get2() {
        return _2;
    }

    public void set2(Double _2) {
        this._2 = _2;
    }

}
