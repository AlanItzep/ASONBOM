package com.example.asonbom.data.ui.register;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.asonbom.R;
import com.example.asonbom.data.ApiClient;
import com.example.asonbom.data.AuthInterceptor;
import com.example.asonbom.data.models.LoginData;
import com.example.asonbom.data.responses.CreateEmResponse;
import com.example.asonbom.data.responses.InfoStations;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements OnMapReadyCallback, Callback<CreateEmResponse> {

    String json;
    Object responseRaw;
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mMapView = findViewById(R.id.map_view_indicator);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);


        TimePicker picker = findViewById(R.id.timePicker1);
        picker.setIs24HourView(true);

        Button pickImage = findViewById(R.id.button_images);
        pickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(Register.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Register.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            100);
                    return;
                }
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("image/*");
                startActivityForResult(intent, 1);

            }
        });

        Button createEmer = findViewById(R.id.button_send);
        createEmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        CreateEmResponse datos = new CreateEmResponse();
        System.out.println("Esto es datos: " + datos + " ***************************************");

        AuthInterceptor datos2 = new AuthInterceptor();
        datos2.params(datos);

        System.out.println("Esto es datos2: " + datos2 + " ***************************************");

        Call<CreateEmResponse> calllogin = ApiClient.getApiService().setEme(datos2);
        calllogin.enqueue(new Callback<CreateEmResponse>() {
            @Override
            public void onResponse(Call<CreateEmResponse> call, Response<CreateEmResponse> response) {
                CreateEmResponse result1 = response.body();
                responseRaw = result1.toString();
                System.out.println(responseRaw);
            }

            @Override
            public void onFailure(Call<CreateEmResponse> call, Throwable t) {
                //for getting error in network put here Toast, so get the error on network
                //test.setText(t.toString());
                System.out.println(t);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            ImageView imageView = findViewById(R.id.images_view);
            List<Bitmap> bitmaps = new ArrayList<>();
            ClipData clipData = data.getClipData();
            if (clipData != null) {
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    Uri imageUri = clipData.getItemAt(i).getUri();
                    try {
                        InputStream is = getContentResolver().openInputStream(imageUri);
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        bitmaps.add(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Uri imageUri = data.getData();
                try {
                    InputStream is = getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    bitmaps.add(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (final Bitmap b : bitmaps) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageBitmap(b);
                            }
                        });
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(41.38879, 2.15899)).title("Marker"));
    }

    @Override
    public void onResponse
            (Call<CreateEmResponse> call, Response<CreateEmResponse> response) {

    }

    @Override
    public void onFailure(Call<CreateEmResponse> call, Throwable t) {

    }
}
