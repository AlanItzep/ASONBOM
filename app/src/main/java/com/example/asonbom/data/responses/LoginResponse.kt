package com.example.asonbom.data.responses

import com.example.asonbom.data.models.User
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class LoginResponse(
    @SerializedName("status_code")
    var statusCode:Int,

    @SerializedName("auth_token")
    var authToken:String,

    @SerializedName("user")
    var user: User?,

    @SerializedName("token")
    var getToken: String,

    @SerializedName("sample_json")
    val sampleJson: JSONObject = JSONObject("""{"email":"moises@moises.com", "password":"admin"}""")
)