package com.example.demolivescore.service;

import com.example.demolivescore.dto.FixturesDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FixtureAPI {
    @GET("fixtures/matches.json?&key=pyz5S7m6r0SC5Wrn&secret=qopVnOKW2wfSzyxY664Zer5GsXixTKVk")
    Call<FixturesDto> getFixturesByCompetition(@Query("competition_id") Integer competitionId);
}
