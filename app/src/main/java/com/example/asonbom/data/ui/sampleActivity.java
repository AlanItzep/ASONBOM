package com.example.asonbom.data.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.asonbom.R;
import com.example.asonbom.data.ApiService;
import com.example.asonbom.data.requests.LoginRequest;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class sampleActivity extends AppCompatActivity implements View.OnClickListener, Callback<LoginRequest> {
    private View btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.btn_login);
        btn.setOnClickListener(this);
    }

    public void onClick(View view){
        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .build();
        ApiService apiInterface = retrofit.create(ApiService.class);

        //prepare call in Retrofit 2.0
        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("email","moises@moises.com");
            paramObject.put("password","admin");

            JSONObject paramComplete = new JSONObject();
            paramComplete.put("json",paramObject);

            String request = "{\"email\":\"moises@moises.com\",\"password\":\"admin\"}";
            RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),request);

            Call<LoginRequest> userCall = apiInterface.getUser(body);
            userCall.enqueue(this);

            System.out.println("BODY: " + body);
            System.out.println(userCall);
        } catch (JSONException e){
            e.printStackTrace();
        }*/
    }

    @Override
    public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {
        System.out.println(response);
    }

    @Override
    public void onFailure(Call<LoginRequest> call, Throwable t) {
        System.out.println("ERROR: " + t+ "LOGIN REQUEST: ");
    }
}
