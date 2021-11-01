
package com.example.demolivescore.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pre {

    @SerializedName("X")
    @Expose
    private Object x;
    @SerializedName("1")
    @Expose
    private Object _1;
    @SerializedName("2")
    @Expose
    private Object _2;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object get1() {
        return _1;
    }

    public void set1(Object _1) {
        this._1 = _1;
    }

    public Object get2() {
        return _2;
    }

    public void set2(Object _2) {
        this._2 = _2;
    }

}
