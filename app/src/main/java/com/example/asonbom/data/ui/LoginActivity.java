package com.example.asonbom.data.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asonbom.R;
import com.example.asonbom.data.ApiClient;
import com.example.asonbom.data.AuthInterceptor;
import com.example.asonbom.data.models.LoginData;
import com.example.asonbom.data.responses.InfoStations;
import com.example.asonbom.data.responses.LoginResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, AdapterLayout.Listener, Callback<InfoStations> {
    private AdapterLayout adapterLayout;
    TextView test;
    String email = "moises@moises.com";
    String password = "admin";
    String responseRaw = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test = findViewById(R.id.txt_info);
        setContentView(R.layout.activity_login);
        final Button btn = findViewById(R.id.btn_login);
        btn.setOnClickListener(this);

/*
        Call<LoginResult> callLogin = ApiAdapter.getApiService().getToken(datosLogin);
        callLogin.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                test.setText(response.toString());
            }
            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                //for getting error in network put here Toast, so get the error on network
            }
        });*/
    }

    public void onClick(View view){
        test = findViewById(R.id.txt_info);
        Call<InfoStations> call = ApiClient.getApiService().getStations();
        call.enqueue(this);
        LoginData datos = new LoginData();

        AuthInterceptor datos2 = new AuthInterceptor();
        datos2.params(datos);

        //test.setText(datos2.json);

        System.out.println(datos2);
        Call<InfoStations.LoginResponse> calllogin= ApiClient.getApiService().getToken(datos2);
        calllogin.enqueue(new Callback<InfoStations.LoginResponse>() {
            @Override
            public void onResponse(Call<InfoStations.LoginResponse> call, Response<InfoStations.LoginResponse> response) {
                InfoStations.LoginResponse result1 = response.body();
                //textView.setText(result1.getUser().toString());
                System.out.println(result1);
            }

            @Override
            public void onFailure(Call<InfoStations.LoginResponse> call, Throwable t) {
                //for getting error in network put here Toast, so get the error on network
                test.setText(t.toString());
                System.out.println(t);
            }
        });
    }

    @Override
    public void onResponse(Call<InfoStations> call, Response<InfoStations> response) {
        if (response.isSuccessful()){
            InfoStations infoStations = response.body();
            responseRaw = infoStations.toString();
        }
    }

    @Override
    public void onFailure(Call<InfoStations> call, Throwable t) {
        System.out.println(t);

    }

    @Override
    public void onItemClick(@NotNull InfoStations infoStations) {
        Toast.makeText(this,"You clicked: "+infoStations.code,Toast.LENGTH_SHORT).show();
    }
}
