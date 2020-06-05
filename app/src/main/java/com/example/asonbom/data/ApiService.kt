package com.example.asonbom.data

import com.example.asonbom.data.requests.LoginRequest
import com.example.asonbom.data.responses.LoginResponse
import com.example.asonbom.data.responses.PostsResponse
import com.example.asonbom.utils.Constants
import retrofit2.Call
import retrofit2.http.*

interface ApiService {


    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>
    //@FormUrlEncoded
    //un login(@Body ("Content-Type: application/x-www-form-urlencoded") String:): Call<LoginResponse>
    //fun login(@Header("Content-Type: application/x-www-form-urlencoded") @Field ( "json") String: jsonRequest): Call<LoginResponse>


    @GET(Constants.POSTS_URL)
    //fun fetchPosts(@Header("Authorization") token: String): Call<PostsResponse>
    fun fetchPosts(): Call<PostsResponse>

    //@GET("prices?key=fadfeddc4de3cf17ebc1421b39578c20")
    //fun getData(): Observable<List<RetroCrypto>>

}