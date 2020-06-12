package com.example.asonbom.data.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asonbom.R;
import com.example.asonbom.data.ApiClient;
import com.example.asonbom.data.AuthInterceptor;
import com.example.asonbom.data.models.LoginData;
import com.example.asonbom.data.responses.InfoStations;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements  Callback<InfoStations> {
    Object responseRaw;
    TextView test;

    String json;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        test = findViewById(R.id.txt_info);

        Call<InfoStations> call = ApiClient.getApiService().getStations();
        call.enqueue(this);
        LoginData datos = new LoginData();

        AuthInterceptor datos2 = new AuthInterceptor();
        datos2.params(datos);

        System.out.println(datos2);



        List<String> list= Arrays.asList("sub","email","nombre","apellido","telefono","rango","rol","estacion","iat","exp");

        List<String> list2= Arrays.asList("sub","email","nombre","apellido","telefono","rango","rol","estacion","iat","exp");

        //list.get(i), String.valueOf(subList.get(0))
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.text_name, list);
        //lv.setAdapter(adapter);


        Call<InfoStations.LoginResponse> calllogin= ApiClient.getApiService().getToken(datos2);
        calllogin.enqueue(new Callback<InfoStations.LoginResponse>() {
            @Override
            public void onResponse(Call<InfoStations.LoginResponse> call, Response<InfoStations.LoginResponse> response) {
                InfoStations.LoginResponse result1 = response.body();
                responseRaw = result1.getUser();
                System.out.println(responseRaw);
                String responseRawU = "{user=["+ responseRaw+"]}";
                Gson g = new Gson();
                json = g.toJson(responseRaw);

                try {
                    ArrayList<String> subList = new ArrayList<>();
                    HashMap<String,String> sub = new HashMap<>();

                    JSONObject jObj = new JSONObject(json);//.replaceAll("$=",":"));
                    subList.add(jObj.getString("sub"));
                    subList.add(jObj.getString("email"));
                    subList.add(jObj.getString("nombre"));
                    subList.add(jObj.getString("last_name"));
                    subList.add(jObj.getString("telefono"));
                    subList.add(jObj.getString("rango"));
                    subList.add(jObj.getString("rol"));
                    subList.add(jObj.getString("estacion"));
                    subList.add(jObj.getString("iat"));
                    subList.add(jObj.getString("exp"));
                    //subList.add(sub);
                    System.out.println("ESTO ES SUB "+sub);
                    System.out.println("ESTO ES SUBLIST "+subList);
                    for( int i = 0; i < subList.size() ;i++){
                        //ListAdapter adapter = new SimpleAdapter(LoginActivity.this, subList, R.layout.row_layout, new String[]{String.valueOf(list.get(i))}, new  int[]{ R.id.text_info});
                        //lv.setAdapter(adapter);

                        List<String> list2= Arrays.asList("sub","email","nombre","apellido","telefono","rango","rol","estacion","iat","exp");
                        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.text_name, list);
                        //lv.setAdapter(adapter);
                        System.out.println(i+" "+list2.get(i)+" "+subList.get(i));
                    }
                    ListView lv = findViewById(R.id.person_list);
                    ArrayAdapter<String> adapters= new ArrayAdapter<>(LoginActivity.this, R.layout.row_layout, R.id.text_name, list);
                    final ArrayAdapter adapter = new ArrayAdapter<>(LoginActivity.this, R.layout.row_layout, R.id.text_info, subList);
                    lv.setAdapter(adapters);
                    lv.setAdapter(adapter);

                } catch (JSONException ex) {
                    ex.printStackTrace();

                }
            }

            @Override
            public void onFailure(Call<InfoStations.LoginResponse> call, Throwable t) {
                //for getting error in network put here Toast, so get the error on network
                //test.setText(t.toString());
                System.out.println(t);
            }
        });


        //test.setText(json);
        //"sub","email","nombre","last_name","telefono","rango","rol","estacion","iat","exp"


/*

        ListAdapter adapter = new SimpleAdapter(LoginActivity.this, responseRaw, R.layout.row_layout, new String[]{"id","no_estacion","direccion","nombre","telefono","long","lat"},
                                                        new int[]{R.id.txt_id,R.id.txt_no_estacion,R.id.txt_direccion,R.id.txt_nombre,R.id.txt_telefono,R.id.txt_long,R.id.lat});
        sc.setAd
        System.out.println(responseRaw
                */
    }

    @Override
    public void onResponse(Call<InfoStations> call, Response<InfoStations> response) {
        if (response.isSuccessful()){
            InfoStations infoStations = response.body();
        }
    }

    public static class ViewHolder{
        public TextView textView;
    }

    @Override
    public void onFailure(Call<InfoStations> call, Throwable t) {
        System.out.println(t);

    }
}
