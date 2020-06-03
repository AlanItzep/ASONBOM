package com.example.asonbom.data.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.asonbom.R
import com.example.asonbom.data.ApiClient
import com.example.asonbom.data.requests.LoginRequest
import com.example.asonbom.data.responses.LoginResponse
import com.example.asonbom.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        apiClient.getApiService().login(LoginRequest(email="moises@moises.com", password = "admin"))
            .enqueue(object : Callback<LoginResponse>{
                override fun onFailure(call: Call<LoginResponse>, t: Throwable){
                    //Error Login In
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>){
                    val loginResponse = response.body()

                    if(loginResponse?.statusCode == 200 && loginResponse.user != null){
                        sessionManager.saveAuthToken(loginResponse.authToken)
                    }else{
                        //Error Login in
                    }
                }

            })
    }
}