package com.example.asonbom.data

import com.example.asonbom.data.requests.LoginRequest
import com.example.asonbom.data.responses.LoginResponseK
import com.example.asonbom.data.responses.PostsResponse
import com.example.asonbom.utils.Constants
import retrofit2.Call
import retrofit2.http.*

interface ApiServiceK {


    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponseK>
    //@FormUrlEncoded
    //fun login(@Body ("Content-Type: application/x-www-form-urlencoded") String:): Call<LoginResponse>
    //fun login(@Header("Content-Type: application/x-www-form-urlencoded")
    // @Field ( "json") String: jsonRequest): Call<LoginResponse>


    @POST(Constants.LOGIN_URL)
    fun callSendJsonListPost(
        @Header("Content-Type: application/x-www-form-urlencoded") header: String,
        @Body list: String

    ): Call<LoginRequest>


    @GET(Constants.POSTS_URL)
    //fun fetchPosts(@Header("Authorization") token: String): Call<PostsResponse>
    fun fetchPosts(): Call<PostsResponse>
    abstract fun jsonLogin(): Call<LoginResponseK>

    //@GET("prices?key=fadfeddc4de3cf17ebc1421b39578c20")
    //fun getData(): Observable<List<RetroCrypto>>

}