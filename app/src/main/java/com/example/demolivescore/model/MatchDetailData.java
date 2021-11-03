
package com.example.demolivescore.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class MatchDetailData {

    @SerializedName("yellow_cards")
    @Expose
    private String yellowCards;
    @SerializedName("red_cards")
    @Expose
    private String redCards;
    @SerializedName("substitutions")
    @Expose
    private String substitutions;
    @SerializedName("possesion")
    @Expose
    private String possesion;
    @SerializedName("free_kicks")
    @Expose
    private String freeKicks;
    @SerializedName("goal_kicks")
    @Expose
    private String goalKicks;
    @SerializedName("throw_ins")
    @Expose
    private String throwIns;
    @SerializedName("offsides")
    @Expose
    private String offsides;
    @SerializedName("corners")
    @Expose
    private String corners;
    @SerializedName("shots_on_target")
    @Expose
    private String shotsOnTarget;
    @SerializedName("shots_off_target")
    @Expose
    private String shotsOffTarget;
    @SerializedName("attempts_on_goal")
    @Expose
    private String attemptsOnGoal;
    @SerializedName("saves")
    @Expose
    private String saves;
    @SerializedName("fauls")
    @Expose
    private String fauls;
    @SerializedName("treatments")
    @Expose
    private String treatments;
    @SerializedName("penalties")
    @Expose
    private String penalties;
    @SerializedName("shots_blocked")
    @Expose
    private String shotsBlocked;
    @SerializedName("dangerous_attacks")
    @Expose
    private String dangerousAttacks;
    @SerializedName("attacks")
    @Expose
    private String attacks;
}