package com.example.demolivescore.service;

import com.example.demolivescore.dto.LiveScoreDto;
import com.example.demolivescore.dto.MatchDetailDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MatchAPI {
    @GET("https://livescore-api.com/api-client/matches/stats.json?&key=pyz5S7m6r0SC5Wrn&secret=qopVnOKW2wfSzyxY664Zer5GsXixTKVk")
    Call<MatchDetailDto> getMatchStatistic(@Query("match_id") Integer matchId);
}