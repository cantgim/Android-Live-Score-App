package com.example.demolivescore.dto;

import com.example.demolivescore.model.MatchDetailData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchDetailDto {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private MatchDetailData data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public MatchDetailData getData() {
        return data;
    }

    public void setData(MatchDetailData data) {
        this.data = data;
    }
}
