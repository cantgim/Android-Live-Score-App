package com.example.demolivescore.service;

import com.example.demolivescore.dto.ResultDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryAPI {
    @GET("countries/list.json?&key=pyz5S7m6r0SC5Wrn&secret=qopVnOKW2wfSzyxY664Zer5GsXixTKVk")
    Call<ResultDto> getListOfCountries();

    @GET("federations/list.json?key=pyz5S7m6r0SC5Wrn&secret=qopVnOKW2wfSzyxY664Zer5GsXixTKVk")
    Call<ResultDto> getListFederations();

    @GET("leagues/table.json?key=PJRGYfC1NxmGPPnn&secret=8VPl12cJkrkOWbNLUErTU4VHBhoq6LNe&competition_id=2")
    Call<ResultDto> getListLeagueStanding();
}
