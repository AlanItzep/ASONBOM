package com.example.asonbom.data

import android.content.Context
import com.example.asonbom.utils.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context) : Interceptor{

    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        sessionManager.fetchAuthToken()?.let{
            requestBuilder.addHeader("Autorization","Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}