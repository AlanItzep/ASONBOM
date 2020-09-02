package com.example.asonbom.data;

import com.example.asonbom.data.responses.CreateEmResponse;
import com.example.asonbom.data.responses.InfoStations;
import com.example.asonbom.data.responses.LoginKey;
import com.example.asonbom.utils.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    // Personal information
    @POST(Constants.LOGIN_URL)
    Call<InfoStations.LoginResponse> getToken(@Body AuthInterceptor body);
    // Get token key
    @POST(Constants.LOGIN_URL)
    Call<LoginKey> getKey(@Body AuthInterceptor body);
    //Create new emergency
    @POST(Constants.CRT_EMERG)
    Call<CreateEmResponse> setEme(@Body AuthInterceptor body);
    @GET(Constants.LIST_STAT)
    Call<InfoStations.LoginResponse> getStations();

}
