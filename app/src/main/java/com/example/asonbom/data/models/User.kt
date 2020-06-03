package com.example.asonbom.data.models

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    var id: String,

    @SerializedName("first_name")
    var first_name:String,

    @SerializedName("last_name")
    var last_name:String,

    @SerializedName("email")
    var email: String
)