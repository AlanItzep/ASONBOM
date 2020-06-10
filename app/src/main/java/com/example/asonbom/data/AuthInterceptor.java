package com.example.asonbom.data;

import com.google.gson.Gson;

public class AuthInterceptor {
    public  String json;
    public void params(Object data){
        Gson gson = new Gson();
        String jsonString = gson.toJson(data);
        json = jsonString;
    }
}
