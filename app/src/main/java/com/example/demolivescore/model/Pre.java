
package com.example.demolivescore.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
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

}