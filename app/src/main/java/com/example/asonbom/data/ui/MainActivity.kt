package com.example.asonbom.data.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asonbom.R
import com.example.asonbom.data.ApiClientK
import com.example.asonbom.data.responses.PostsResponse
import com.example.asonbom.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var apiClient: ApiClientK
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiClient = ApiClientK()
        sessionManager = SessionManager(this)

        val button = findViewById<Button>(R.id.btn_login)
        button?.setOnClickListener()
        {fetchPosts()}
    }

    private fun fetchPosts(){
        apiClient.getApiService(this).fetchPosts()
            .enqueue(object : Callback<PostsResponse>{

                //Error fetching posts
                override fun onFailure(call:Call<PostsResponse>,t:Throwable){
                    Toast.makeText(applicationContext,"Error! ", Toast.LENGTH_SHORT).show()
                }

                //Handle function to display posts
                override fun onResponse(call: Call<PostsResponse>,response:Response<PostsResponse>){
                    if (response.isSuccessful){
                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_SHORT).show()

                    }
                    else{
                        Toast.makeText(applicationContext,"login not correct! ", Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }
}
