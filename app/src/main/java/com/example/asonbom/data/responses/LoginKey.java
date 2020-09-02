package com.example.asonbom.data.responses;

import com.google.gson.annotations.SerializedName;

public class LoginKey {
    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("token")
    private String token;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void getPassword(String password) {
        this.password = password;
    }
    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token = token;
    }
}
