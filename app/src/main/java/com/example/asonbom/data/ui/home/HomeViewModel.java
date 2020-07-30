package com.example.asonbom.data.ui.home;

import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.asonbom.R;
import com.example.asonbom.data.ApiClient;
import com.example.asonbom.data.responses.InfoStations;

import org.json.JSONException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel{

    private MutableLiveData<String> mText;

    //Object responseRaw;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("this is home fragment");
        System.out.println("hola mundo *******************************");

        /*
        Call<InfoStations.LoginResponse> casld = ApiClient.getApiService().getStations();
        casld.enqueue(new Callback<InfoStations.LoginResponse>() {
            @Override
            public void onResponse(Call<InfoStations.LoginResponse> call, Response<InfoStations.LoginResponse> response) {
                InfoStations.LoginResponse result1 = response.body();

                responseRaw = result1.getEstaciones();
                System.out.println("ESTO ES RESPONSE RAW  *****************************  " + responseRaw);
            }

            @Override
            public void onFailure(Call<InfoStations.LoginResponse> call, Throwable t) {
                System.out.println("HA FALLADO *********************    ");
            }
        });*/

        //mText = new MutableLiveData<>();
        //mText.setValue(responseRaw.toString());

    }

    public LiveData<String> getText() {
        return mText;
    }
/*
    @Override
    public void onResponse(Call<InfoStations> call, Response<InfoStations> response) {
        if (response.isSuccessful()) {
            InfoStations infoStations = response.body();
        }
    }

    @Override
    public void onFailure(Call<InfoStations> call, Throwable t) {
        System.out.println(t);
    }*/
}