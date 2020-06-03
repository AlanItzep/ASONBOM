package com.example.asonbom.data

import com.example.asonbom.data.requests.LoginRequest
import com.example.asonbom.data.responses.LoginResponse
import com.example.asonbom.data.responses.PostsResponse
import com.example.asonbom.utils.Constants
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST(Constants.LOGIN_URL)
    @FormUrlEncoded
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET(Constants.POSTS_URL)
    //fun fetchPosts(@Header("Authorization") token: String): Call<PostsResponse>
    fun fetchPosts(): Call<PostsResponse>
}