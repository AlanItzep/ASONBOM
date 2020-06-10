package com.example.asonbom.data

import android.content.Context
import com.example.asonbom.utils.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptorK(context: Context) : Interceptor{

    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        sessionManager.fetchAuthToken()?.let{
            requestBuilder.addHeader("Authorization", "Bearer $it")
            //fun login(@Header("Content-Type: application/x-www-form-urlencoded") @Field ( "json") String: jsonRequest): Call<LoginResponse>
            //requestBuilder.addHeader("Content-Type","application/x-www-form-urlencoded")
            //"Accept: application/json",
            //"Content-type: application/x-www-form-urlencoded"
        }

        println("REQUEST BUILDER INFORMATION: $requestBuilder")
        println("SESSION MANAGER INFORMATION: $sessionManager")

        //"Content-Type: application/x-www-form-urlencoded"
        return chain.proceed(requestBuilder.build())

    }

}