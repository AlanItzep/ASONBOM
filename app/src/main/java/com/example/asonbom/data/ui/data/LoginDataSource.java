package com.example.asonbom.data.ui.data;

import com.example.asonbom.data.ApiClient;
import com.example.asonbom.data.AuthInterceptor;
import com.example.asonbom.data.models.BeLogin;
import com.example.asonbom.data.responses.LoginKey;
import com.example.asonbom.data.ui.data.model.LoggedInUser;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource implements Callback<LoginKey> {
    Object responseRaw;
    String json;

    public Result<LoggedInUser> login(String username, String password) {

        BeLogin datos = new BeLogin(username,password);
        AuthInterceptor datos2 = new AuthInterceptor();
        datos2.params(datos);
        Call<LoginKey> calllogin = ApiClient.getApiService().getKey(datos2);
        calllogin.enqueue(new Callback<LoginKey>() {
            @Override
            public void onResponse(Call<LoginKey> call, Response<LoginKey> response) {
                LoginKey resutl = response.body();
                responseRaw = resutl.getToken();
                System.out.println("TOKEN: "+ responseRaw.toString());
            }

            @Override
            public void onFailure(Call<LoginKey> call, Throwable t) {

            }
        });
        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            " Usuario preferido !");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }

    @Override
    public void onResponse(Call<LoginKey> call, Response<LoginKey> response) {

    }

    @Override
    public void onFailure(Call<LoginKey> call, Throwable t) {

    }
}
