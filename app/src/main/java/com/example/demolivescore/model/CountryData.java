
package com.example.demolivescore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class CountryData {

    @SerializedName("country")
    @Expose
    private List<Country> country = null;

}
