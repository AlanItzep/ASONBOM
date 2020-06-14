package com.example.asonbom.data;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asonbom.R;
import com.example.asonbom.data.models.RowInfo;
import com.example.asonbom.data.models.RowListAdapter;

import java.util.ArrayList;

public class MultipleitemList extends AppCompatActivity {
    private static final String TAG = "MultipleitemList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d(TAG,"onCreate: started.");
        ListView mListView = (ListView) findViewById(R.id.person_list);

        //"sub","email","nombre","apellido","telefono","rango","rol","estacion","iat","exp"
        RowInfo sub = new RowInfo("sub", "7");
        RowInfo email = new RowInfo("email", "moises@mosises.com");
        RowInfo nombre = new RowInfo("nombre", "Moises");
        RowInfo apellido = new RowInfo("apellido", "Chavez");
        RowInfo telefono = new RowInfo("telefono", "40409090");
        RowInfo rango = new RowInfo("rango", "Bombero 1ra. Clase");
        RowInfo rol = new RowInfo("rol", "ROLE_USER");
        RowInfo estacion = new RowInfo("estacion", "cosa cosa");
        RowInfo iat = new RowInfo("iat", "1591869041");
        RowInfo exp = new RowInfo("exp", "1592473841");

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

        RowListAdapter adapter = new RowListAdapter(this, R.layout.row_layout, rowList);

        mListView.setAdapter(adapter);
    }


    /*

    // Crear una list view sencilla

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing_various);


        ListView list = findViewById(R.id.list_example);
        Log.d(TAG,"onCreate: started.");

        //Arrays.asList("sub","email","nombre","apellido","telefono","rango","rol","estacion","iat","exp")

        //ArrayList<String> names= new ArrayList<>();
        //names.add("sub");
        //names.add("email");
        //names.add("nombre");
        //names.add("apellido");
        //names.add("telefono");
        //names.add("rango");
        //names.add("rol");
        //names.add("estacion");
        //names.add("iat");
        //names.add("exp");

        List<String> names= Arrays.asList("sub","email","nombre","apellido","telefono","rango","rol","estacion","iat","exp");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.text_item, names);
        list.setAdapter(adapter);

    }
    */


    /*

    // colocar imagenes de forma sencilla

    private static final String TAG = "MultipleitemList";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing_various);
        Log.d(TAG,"onCreate: started.");
        ImageView firstImage = (ImageView) findViewById(R.id.first_image);

        int imageResource = getResources().getIdentifier("@drawable/gg", null,this.getPackageName());
        firstImage.setImageResource(imageResource);
    }
    // *************** XML FILE***************
        <ImageView
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:layout_centerVertical="true"
        android:layout_centerHorizontal="true"
        android:id="@+id/first_image"/>

    // *************** XML FILE***************
    */
}