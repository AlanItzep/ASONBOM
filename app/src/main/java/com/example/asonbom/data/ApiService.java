package com.example.asonbom.data;

import com.example.asonbom.data.responses.InfoStations;
import com.example.asonbom.utils.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST(Constants.LOGIN_URL)
    Call<InfoStations.LoginResponse> getToken(@Body AuthInterceptor body);
    @GET(Constants.LIST_STAT)
    Call<InfoStations> getStations();

}
