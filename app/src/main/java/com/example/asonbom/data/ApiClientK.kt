package com.example.asonbom.data

import android.content.Context
import com.example.asonbom.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClientK {
    private lateinit var apiService:ApiServiceK

    fun getApiService(context: Context): ApiServiceK {

        if (!::apiService.isInitialized){
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient(context))
                .build()

            apiService = retrofit.create(ApiServiceK::class.java)
        }

        return apiService

    }

    private fun okhttpClient(context: Context): OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(AuthInterceptorK(context))
                .build()
    }

}