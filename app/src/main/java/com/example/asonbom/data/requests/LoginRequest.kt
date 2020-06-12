package com.example.asonbom.data.requests

import com.google.gson.annotations.SerializedName

data class LoginRequest(

    @SerializedName("email")
    var email: String,

    @SerializedName("password")
    var password: String,

    @SerializedName("gettoken")
    var gettoken: Boolean = true
)