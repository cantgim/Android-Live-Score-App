
package com.example.demolivescore.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("country")
    @Expose
    private List<Country> country = null;

    @SerializedName("table")
    @Expose
    private List<Team> table = null;

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    public List<Team> getTable() {
        return table;
    }

    public void setTable(List<Team> table) {
        this.table = table;
    }
}
