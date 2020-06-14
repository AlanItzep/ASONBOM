package com.example.asonbom.data.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asonbom.R;
import com.example.asonbom.data.ApiClient;
import com.example.asonbom.data.AuthInterceptor;
import com.example.asonbom.data.models.LoginData;
import com.example.asonbom.data.models.RowInfo;
import com.example.asonbom.data.models.RowListAdapter;
import com.example.asonbom.data.responses.InfoStations;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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

                    ListView mListView = findViewById(R.id.person_list);
                    ArrayList<String> subList = new ArrayList<>();

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


                    System.out.println("ESTO ES SUBLIST "+subList);
                    List<String> objNames = Arrays.asList("sub","email","nombre","apellido","telefono","rango","rol","estacion","iat","exp");
                    List<String> objTitles =  Arrays.asList( "Sub estación","Email","Nombre","Apellido","Teléfono","Rango","Rol","Estación","iat","exp");

                    RowInfo sub = new RowInfo(objTitles.get(0), subList.get(0));
                    RowInfo email = new RowInfo(objTitles.get(1), subList.get(1));
                    RowInfo nombre = new RowInfo(objTitles.get(2), subList.get(2));
                    RowInfo apellido = new RowInfo(objTitles.get(3), subList.get(3));
                    RowInfo telefono = new RowInfo(objTitles.get(4), subList.get(4));
                    RowInfo rango = new RowInfo(objTitles.get(5), subList.get(5));
                    RowInfo rol = new RowInfo(objTitles.get(6), subList.get(6));
                    RowInfo estacion = new RowInfo(objTitles.get(7), subList.get(7));
                    RowInfo iat = new RowInfo(objTitles.get(8), subList.get(8));
                    RowInfo exp = new RowInfo(objTitles.get(9), subList.get(9));

                    ArrayList<RowInfo> rowList = new ArrayList<>();

                    rowList.add(sub);
                    rowList.add(email);
                    rowList.add(nombre);
                    rowList.add(apellido);
                    rowList.add(telefono);
                    rowList.add(rango);
                    rowList.add(rol);
                    rowList.add(estacion);
                    rowList.add(iat);
                    rowList.add(exp);


                    RowListAdapter adapter = new RowListAdapter(LoginActivity.this, R.layout.row_layout, rowList);
                    mListView.setAdapter(adapter);
                    System.out.println(rowList);
                    /*
                    ListView lv = findViewById(R.id.person_list);
                    ArrayAdapter<String> adapters= new ArrayAdapter<>(LoginActivity.this, R.layout.row_layout, R.id.text_name, list);
                    final ArrayAdapter adapter = new ArrayAdapter<>(LoginActivity.this, R.layout.row_layout, R.id.text_info, subList);
                    lv.setAdapter(adapters);
                    lv.setAdapter(adapter);
                    */
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
