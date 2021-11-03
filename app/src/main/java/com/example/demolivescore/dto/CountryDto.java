
package com.example.demolivescore.dto;

import com.example.demolivescore.model.CountryData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@lombok.Data
public class CountryDto {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private CountryData data;
}
