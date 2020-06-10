package com.example.asonbom.data.models;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("email")
    public String email = "moises@moises.com";

    @SerializedName("password")
    public String password = "admin";

    @SerializedName("gettoken")
    public Boolean gettoken = true;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void getPassword(String password){
        this.password = password;
    }
}
