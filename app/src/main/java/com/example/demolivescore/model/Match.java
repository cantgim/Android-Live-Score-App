
package com.example.demolivescore.model;



import com.example.demolivescore.model.Odds;
import com.example.demolivescore.model.Outcomes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Match {

    @SerializedName("scheduled")
    @Expose
    private String scheduled;
    @SerializedName("competition_id")
    @Expose
    private Integer competitionId;
    @SerializedName("ps_score")
    @Expose
    private String psScore;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("odds")
    @Expose
    private Odds odds;
    @SerializedName("last_changed")
    @Expose
    private String lastChanged;
    @SerializedName("competition_name")
    @Expose
    private String competitionName;
    @SerializedName("home_id")
    @Expose
    private Integer homeId;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("away_name")
    @Expose
    private String awayName;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("away_id")
    @Expose
    private Integer awayId;
    @SerializedName("ht_score")
    @Expose
    private String htScore;
    @SerializedName("home_name")
    @Expose
    private String homeName;
    @SerializedName("added")
    @Expose
    private String added;
    @SerializedName("h2h")
    @Expose
    private String h2h;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("has_lineups")
    @Expose
    private Boolean hasLineups;
    @SerializedName("ft_score")
    @Expose
    private String ftScore;
    @SerializedName("events")
    @Expose
    private String events;
    @SerializedName("fixture_id")
    @Expose
    private Integer fixtureId;
    @SerializedName("et_score")
    @Expose
    private String etScore;
    @SerializedName("outcomes")
    @Expose
    private Outcomes outcomes;
    @SerializedName("info")
    @Expose
    private String info;

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public String getPsScore() {
        return psScore;
    }

    public void setPsScore(String psScore) {
        this.psScore = psScore;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Odds getOdds() {
        return odds;
    }

    public void setOdds(Odds odds) {
        this.odds = odds;
    }

    public String getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(String lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getAwayId() {
        return awayId;
    }

    public void setAwayId(Integer awayId) {
        this.awayId = awayId;
    }

    public String getHtScore() {
        return htScore;
    }

    public void setHtScore(String htScore) {
        this.htScore = htScore;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getH2h() {
        return h2h;
    }

    public void setH2h(String h2h) {
        this.h2h = h2h;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getHasLineups() {
        return hasLineups;
    }

    public void setHasLineups(Boolean hasLineups) {
        this.hasLineups = hasLineups;
    }

    public String getFtScore() {
        return ftScore;
    }

    public void setFtScore(String ftScore) {
        this.ftScore = ftScore;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public Integer getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(Integer fixtureId) {
        this.fixtureId = fixtureId;
    }

    public String getEtScore() {
        return etScore;
    }

    public void setEtScore(String etScore) {
        this.etScore = etScore;
    }

    public Outcomes getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(Outcomes outcomes) {
        this.outcomes = outcomes;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
