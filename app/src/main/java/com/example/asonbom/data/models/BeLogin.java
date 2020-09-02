package com.example.asonbom.data.models;

import com.google.gson.annotations.SerializedName;

public class BeLogin {
    public BeLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

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

}
