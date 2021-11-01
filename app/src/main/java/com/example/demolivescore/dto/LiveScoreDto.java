package com.example.demolivescore.dto;

import com.example.demolivescore.model.LiveScoreData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveScoreDto {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private LiveScoreData data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LiveScoreData getData() {
        return data;
    }

    public void setData(LiveScoreData data) {
        this.data = data;
    }
}
