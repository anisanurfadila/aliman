package com.example.aliman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class ActivitySholat extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

/*    TextView subuh,dzuhur,ashar,maghrib,isya, greetText;
    private ListView listDaftarKota;
    private ListViewAdapter mDaftarKotaAdapter;
    String[] listKota;
    RequestQueue mQueue;
    public static String url = "https://api.myquran.com/v1/sholat/jadwal/1609/2021/06/23";*/
   /* TextView txthasil;
    RequestQueue mQueue;
    public static String url = "https://api.myquran.com/v1/sholat/jadwal/1609/2021/06/23";
    public static final String stSubuh = "subuh";
    public static final String stDzuhur = "dzuhur";
    public static final String stAshar = "ashar";
    public static final String stMaghrib = "maghrib";
    public static final String stIsya = "isya";*/

    TextView st_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sholat);


        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.testspin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        st_hasil = findViewById(R.id.tv_hasil);

/*
            ClassDzikir classNomor = new ClassDzikir(listNomor[i]);
            classNomorArrayList.add(classNomor);
            ClassDesc classDesc = new ClassDesc(listDesc[i]);
            classDescArrayList.add(classDesc);*/
       /* subuh = findViewById(R.id.tv_subuh);
        dzuhur = findViewById(R.id.tv_subuh);
        ashar = findViewById(R.id.tv_subuh);
        maghrib = findViewById(R.id.tv_subuh);
        isya = findViewById(R.id.tv_subuh);
        greetText = findViewById(R.id.greeting_text);


        mQueue = Volley.newRequestQueue(this);
        jsonParse();*/
    /*
    private void jsonParse() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("jadwal");
                            for(int i=0;i< jsonArray.length();i++){
                                JSONObject jadwal = jsonArray.getJSONObject(i);
                                subuh.setText(jadwal.getString("subuh"));
                                dzuhur.setText(jadwal.getString("subuh"));
                                ashar.setText(jadwal.getString("subuh"));
                                maghrib.setText(jadwal.getString("subuh"));
                                isya.setText(jadwal.getString("subuh"));



                                JSONObject jadwal = jsonArray.getJSONObject(i);
                                String subuh = jadwal.getString("subuh");
                                String dzuhur = jadwal.getString("dzuhur");
                                String ashar = jadwal.getString("ashar");
                                String maghrib = jadwal.getString("maghrib");
                                String isya = jadwal.getString("isya");

                                txthasil.append(
                                                "\n Subuh = "+String.valueOf(subuh)+
                                                "\n Dzuhur = " +String.valueOf(dzuhur)+
                                                "\n Ashar = "+String.valueOf(ashar)+
                                                "\n Maghrib = "+String.valueOf(maghrib)+
                                                "\n Isya = "+String.valueOf(isya)
                                );



                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );
        mQueue.add(request);
    }*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

        switch (text){
            case "satu":
                st_hasil.setText("INI ANGKA 1");
                break;
            case "dua":
                st_hasil.setText("INI ANGKA duwaa 2");
                break;
            case "tiga":
                st_hasil.setText("INI ANGKA TEEGa");
                break;
            case "empat":
                st_hasil.setText("INI ANGKA AMPAT");
                break;
        }


        Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}