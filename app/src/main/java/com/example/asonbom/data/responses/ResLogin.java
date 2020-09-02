package com.example.asonbom.data.responses;

import com.google.gson.annotations.SerializedName;

public class ResLogin {
    @SerializedName("code")
    public int code;

    @SerializedName("status")
    public String status;

    @SerializedName("token")
    public String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
