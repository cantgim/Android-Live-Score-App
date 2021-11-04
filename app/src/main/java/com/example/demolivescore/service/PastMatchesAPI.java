package com.example.demolivescore.service;

import com.example.demolivescore.dto.LiveScoreDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PastMatchesAPI {
    @GET("http://livescore-api.com/api-client/scores/history.json?key=pyz5S7m6r0SC5Wrn&secret=qopVnOKW2wfSzyxY664Zer5GsXixTKVk")
    Call<LiveScoreDto> getPastMatches();
}
