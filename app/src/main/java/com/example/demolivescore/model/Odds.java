
package com.example.demolivescore.model;

import com.example.demolivescore.model.Live;
import com.example.demolivescore.model.Pre;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Odds {

    @SerializedName("live")
    @Expose
    private Live live;
    @SerializedName("pre")
    @Expose
    private Pre pre;

}