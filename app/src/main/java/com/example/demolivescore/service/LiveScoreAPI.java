package com.example.demolivescore.service;

import com.example.demolivescore.dto.LiveScoreDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LiveScoreAPI {
    @GET("https://livescore-api.com/api-client/scores/live.json?&key=pyz5S7m6r0SC5Wrn&secret=qopVnOKW2wfSzyxY664Zer5GsXixTKVk")
    Call<LiveScoreDto> getLiveScore();
}
