package com.example.asonbom.data.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.asonbom.R
import com.example.asonbom.data.ApiClientK
import com.example.asonbom.utils.SessionManager

class LoginActivityk : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClientK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiClient = ApiClientK()
        sessionManager = SessionManager(this)



        val button = findViewById<Button>(R.id.btn_login)
        button?.setOnClickListener{
            //logLogin()
        }
    }
    /*
    private fun logLogin(){
        apiClient.getApiService(this).login(LoginRequest(email = "moises@moises.com", password = "admin"))
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        //Error Login In
                        Toast.makeText(applicationContext, "Error! ", Toast.LENGTH_SHORT).show()
                        txt_info.setText(t.toString())
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val loginResponse = response.body()

                        if (loginResponse?.statusCode == 200 && loginResponse.user != null) {
                            sessionManager.saveAuthToken(loginResponse.authToken)
                            Toast.makeText(
                                applicationContext,
                                loginResponse.authToken,
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            //Error Login in
                            Toast.makeText(
                                applicationContext,
                                response.toString(),
                                Toast.LENGTH_SHORT

                            ).show()
                            println("SESSION MANAGER ON lOGIN ACTIVITY $sessionManager")
                            println(response)
                            txt_info.setText(response.toString())
                        }
                    }

                })
        }*/
}
