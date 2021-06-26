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

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.JsonIOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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


    TextView st_hasil, txtNama,txtAlamat, textsubuh,textduhur,textashar,textmaghrib,textisya;

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
        txtNama = findViewById(R.id.txtTestApiNama);
        textsubuh = findViewById(R.id.txt_subuh);
        textduhur = findViewById(R.id.txt_duhur);
        textashar = findViewById(R.id.txt_ashar);
        textmaghrib = findViewById(R.id.txt_maghrib);
        textisya = findViewById(R.id.txt_isya);

        try {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("https://api.myquran.com/v1/sholat/jadwal/1609/2021/06/23")
                    .method("GET", null)
                    .build();
            //    Response response = client.newCall(request).execute();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        final String myResponse = response.body().string();
                        ActivitySholat.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtNama.setText(myResponse);
                            }
                        });
                    }
                }
            });

        }
        catch (JsonIOException e){
            e.printStackTrace();
        }

        getData();;
    }

        // getData();

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

    private void getData() {
        AndroidNetworking.get("https://api.myquran.com/v1/sholat/jadwal/1609/2021/06/23")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            txtAlamat.setText(response.getString("lokasi"));
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                        // do anything with response
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                    }
                });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

        switch (text){
            case "Jambi":
                st_hasil.setText("Jambi");
                textsubuh.setText("04.50");
                textduhur.setText("12.06");
                textashar.setText("15.26");
                textmaghrib.setText("18.08");
                textisya.setText("19.18");
                break;
            case "Medan":
                st_hasil.setText("Medan");
                textsubuh.setText("04.55");
                textduhur.setText("12.31");
                textashar.setText("15.57");
                textmaghrib.setText("18.41");
                textisya.setText("19.56");
                break;
            case "Jakarta":
                st_hasil.setText("Jakarta");
                textsubuh.setText("04.41");
                textduhur.setText("11.58");
                textashar.setText("15.19");
                textmaghrib.setText("17.51");
                textisya.setText("19.05");
                break;
            case "Bandung":
                st_hasil.setText("Bandung");
                textsubuh.setText("04.39");
                textduhur.setText("11.55");
                textashar.setText("15.16");
                textmaghrib.setText("17.51");
                textisya.setText("19.01");
                break;
            case "Semarang":
                st_hasil.setText("Semarang");
                textsubuh.setText("04.28");
                textduhur.setText("11.44");
                textashar.setText("15.04");
                textmaghrib.setText("17.35");
                textisya.setText("18.50");
              /*  1505
                1638
                1709
                1810
                2622
                2013
                2214
                2113
                2310
                3329*/
                break;
            case "Yogyakarta":
                st_hasil.setText("Yogyakarta");
                textsubuh.setText("04.29");
                textduhur.setText("11.44");
                textashar.setText("15.04");
                textmaghrib.setText("17.34");
                textisya.setText("18.50");
                break;
            case "Surabaya":
                st_hasil.setText("Surabaya");
                textsubuh.setText("04.19");
                textduhur.setText("11.35");
                textashar.setText("15.55");
                textmaghrib.setText("17.26");
                textisya.setText("18.40");
                break;
            case "Denpasar":
                st_hasil.setText("Denpasar");
                textsubuh.setText("05.11");
                textduhur.setText("12.25");
                textashar.setText("15.44");
                textmaghrib.setText("18.13");
                textisya.setText("19.28");
                break;
            case "Mataram":
                st_hasil.setText("Mataram");
                textsubuh.setText("05.08");
                textduhur.setText("12.21");
                textashar.setText("15.40");
                textmaghrib.setText("18.10");
                textisya.setText("19.24");
                break;
            case "Makassar":
                st_hasil.setText("Makassar");
                textsubuh.setText("04.49");
                textduhur.setText("12.08");
                textashar.setText("15.30");
                textmaghrib.setText("18.03");
                textisya.setText("19.17");
                break;
            case "Pontianak":
                st_hasil.setText("Pontianak");
                textsubuh.setText("04.20");
                textduhur.setText("11.48");
                textashar.setText("15.13");
                textmaghrib.setText("17.52");
                textisya.setText("19.06");
                break;
            case "Palangkaraya":
                st_hasil.setText("Palangkaraya");
                textsubuh.setText("04.06");
                textduhur.setText("11.30");
                textashar.setText("14.54");
                textmaghrib.setText("17.30");
                textisya.setText("18.44");
                break;
            case "Banjarmasin":
                st_hasil.setText("Banjarmasin");
                textsubuh.setText("05.05");
                textduhur.setText("12.27");
                textashar.setText("15.50");
                textmaghrib.setText("18.25");
                textisya.setText("19.39");
                break;
            case "Samarinda":
                st_hasil.setText("Samarinda");
                textsubuh.setText("04.50");
                textduhur.setText("12.17");
                textashar.setText("15.42");
                textmaghrib.setText("18.20");
                textisya.setText("19.34");
                break;
            case "Jayapura":
                st_hasil.setText("Jayapura");
                textsubuh.setText("04.19");
                textduhur.setText("11.43");
                textashar.setText("15.06");
                textmaghrib.setText("17.42");
                textisya.setText("18.56");
                break;

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}