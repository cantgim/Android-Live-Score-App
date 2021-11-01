
package com.example.demolivescore.model;

import com.example.demolivescore.model.Live;
import com.example.demolivescore.model.Pre;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Odds {

    @SerializedName("live")
    @Expose
    private Live live;
    @SerializedName("pre")
    @Expose
    private Pre pre;

    public Live getLive() {
        return live;
    }

    public void setLive(Live live) {
        this.live = live;
    }

    public Pre getPre() {
        return pre;
    }

    public void setPre(Pre pre) {
        this.pre = pre;
    }

}
