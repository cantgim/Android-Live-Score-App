
package com.example.demolivescore.dto;

import com.example.demolivescore.model.FixtureData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class FixturesDto {

    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("data")
    @Expose
    public FixtureData data;

}
