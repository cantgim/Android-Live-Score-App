
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

    public String getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(String yellowCards) {
        this.yellowCards = yellowCards;
    }

    public String getRedCards() {
        return redCards;
    }

    public void setRedCards(String redCards) {
        this.redCards = redCards;
    }

    public String getSubstitutions() {
        return substitutions;
    }

    public void setSubstitutions(String substitutions) {
        this.substitutions = substitutions;
    }

    public String getPossesion() {
        return possesion;
    }

    public void setPossesion(String possesion) {
        this.possesion = possesion;
    }

    public String getFreeKicks() {
        return freeKicks;
    }

    public void setFreeKicks(String freeKicks) {
        this.freeKicks = freeKicks;
    }

    public String getGoalKicks() {
        return goalKicks;
    }

    public void setGoalKicks(String goalKicks) {
        this.goalKicks = goalKicks;
    }

    public String getThrowIns() {
        return throwIns;
    }

    public void setThrowIns(String throwIns) {
        this.throwIns = throwIns;
    }

    public String getOffsides() {
        return offsides;
    }

    public void setOffsides(String offsides) {
        this.offsides = offsides;
    }

    public String getCorners() {
        return corners;
    }

    public void setCorners(String corners) {
        this.corners = corners;
    }

    public String getShotsOnTarget() {
        return shotsOnTarget;
    }

    public void setShotsOnTarget(String shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }

    public String getShotsOffTarget() {
        return shotsOffTarget;
    }

    public void setShotsOffTarget(String shotsOffTarget) {
        this.shotsOffTarget = shotsOffTarget;
    }

    public String getAttemptsOnGoal() {
        return attemptsOnGoal;
    }

    public void setAttemptsOnGoal(String attemptsOnGoal) {
        this.attemptsOnGoal = attemptsOnGoal;
    }

    public String getSaves() {
        return saves;
    }

    public void setSaves(String saves) {
        this.saves = saves;
    }

    public String getFauls() {
        return fauls;
    }

    public void setFauls(String fauls) {
        this.fauls = fauls;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getPenalties() {
        return penalties;
    }

    public void setPenalties(String penalties) {
        this.penalties = penalties;
    }

    public String getShotsBlocked() {
        return shotsBlocked;
    }

    public void setShotsBlocked(String shotsBlocked) {
        this.shotsBlocked = shotsBlocked;
    }

    public String getDangerousAttacks() {
        return dangerousAttacks;
    }

    public void setDangerousAttacks(String dangerousAttacks) {
        this.dangerousAttacks = dangerousAttacks;
    }

    public String getAttacks() {
        return attacks;
    }

    public void setAttacks(String attacks) {
        this.attacks = attacks;
    }

}
