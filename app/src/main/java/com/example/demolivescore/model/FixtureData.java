
package com.example.demolivescore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class FixtureData {

    @SerializedName("fixtures")
    @Expose
    public List<Fixture> fixtures = null;
    @SerializedName("next_page")
    @Expose
    public String nextPage;
    @SerializedName("prev_page")
    @Expose
    public Boolean prevPage;

}
