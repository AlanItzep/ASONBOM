package com.example.asonbom.data.responses

import com.example.asonbom.data.models.User
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status_code")
    var statusCode:Int,

    @SerializedName("auth_token")
    var authToken:String,

    @SerializedName("user")
    var user: User?
)