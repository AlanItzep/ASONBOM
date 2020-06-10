package com.example.asonbom.data

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    //private val AUTH = "Basic "+ Base64.encodeToString("belalkhan:123456".toByteArray(), Base64.NO_WRAP)

    private const val BASE_URL = "http://pacific-lowlands-44228.herokuapp.com/"

    private fun okhttpClient(context: Context): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptorK(context))
            .build()
    }
    fun  instance(context: Context): ApiServiceK {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient(context))
            .build()

        return retrofit.create(ApiServiceK::class.java)
    }


}