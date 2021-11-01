
package com.example.demolivescore.model;

import java.util.List;


import com.example.demolivescore.model.Match;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LiveScoreData {

    @SerializedName("match")
    @Expose
    private List<Match> match = null;

    public List<Match> getMatch() {
        return match;
    }

    public void setMatch(List<Match> match) {
        this.match = match;
    }

}
