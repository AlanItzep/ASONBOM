package com.example.asonbom.data.responses;

import com.google.gson.annotations.SerializedName;

public class InfoStations {

    @SerializedName("Code")
    public int code;

    @SerializedName("status")
    public String status;

    @SerializedName("estaciones")
    public Object response = null;


    public int getCode(){
        return code;
    }

    public String getStatus(){
        return status;
    }

    public void setCode(){
        this.code = code;
    }

    public void setStatus(){
        this.status = status;
    }

    public static class LoginResponse {
        @SerializedName("token")
        private String token;
        @SerializedName("user")
        private Object user;

        public String getToken(){
           return token;
        }
        public void setToken(String token){
            this.token = token;
        }
        public  Object getUser(){
            return user;
        }
        public void setUser(Object user){
            this.user = user;
        }
    }
}
