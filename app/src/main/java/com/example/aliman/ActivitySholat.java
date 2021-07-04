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



    //deklarasi variabel textview
    TextView st_hasil, txtNama,txtAlamat, textsubuh,textduhur,textashar,textmaghrib,textisya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sholat);

        //mmenghibungkan spinner pada komponen spinner di layout
        Spinner spinner = findViewById(R.id.spinner1);

        //menghbungkan array yg ada di string dgn nama testpin pada array adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.testspin, android.R.layout.simple_spinner_item);
        //setting dropdown dari untuk array adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //menghubungkan array adapter tadi pada spinner
        spinner.setAdapter(adapter);
        //jika spinner di klik
        spinner.setOnItemSelectedListener(this);

        //menghubungkan pada komponen di layout
        st_hasil = findViewById(R.id.tv_hasil);
        txtNama = findViewById(R.id.txtTestApiNama);
        textsubuh = findViewById(R.id.txt_subuh);
        textduhur = findViewById(R.id.txt_duhur);
        textashar = findViewById(R.id.txt_ashar);
        textmaghrib = findViewById(R.id.txt_maghrib);
        textisya = findViewById(R.id.txt_isya);

    }





    //mfunction jika item dalam spinner di klik
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //deklarasi variabel untuk meyimpan posisi/item dari spiner yg dipilih
        String text = parent.getItemAtPosition(position).toString();

        //switch case kondisi item yang dipilih
        switch (text){
            //jika test jambi maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Jambi":
                st_hasil.setText("Jambi");
                textsubuh.setText("04.50");
                textduhur.setText("12.06");
                textashar.setText("15.26");
                textmaghrib.setText("18.08");
                textisya.setText("19.18");
                //case jambi selesai
                break;

            //jika test medan maka jadwal (textview)pada layout akan berubah seperti dibawah ini
            case "Medan":
                st_hasil.setText("Medan");
                textsubuh.setText("04.55");
                textduhur.setText("12.31");
                textashar.setText("15.57");
                textmaghrib.setText("18.41");
                textisya.setText("19.56");
                break;

            //jika test jakarta maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Jakarta":
                st_hasil.setText("Jakarta");
                textsubuh.setText("04.41");
                textduhur.setText("11.58");
                textashar.setText("15.19");
                textmaghrib.setText("17.51");
                textisya.setText("19.05");
                break;

            //jika test bandung maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Bandung":
                st_hasil.setText("Bandung");
                textsubuh.setText("04.39");
                textduhur.setText("11.55");
                textashar.setText("15.16");
                textmaghrib.setText("17.51");
                textisya.setText("19.01");
                break;

            //jika test semarang maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Semarang":
                st_hasil.setText("Semarang");
                textsubuh.setText("04.28");
                textduhur.setText("11.44");
                textashar.setText("15.04");
                textmaghrib.setText("17.35");
                textisya.setText("18.50");
                break;

            //jika test yogyakarta maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Yogyakarta":
                st_hasil.setText("Yogyakarta");
                textsubuh.setText("04.29");
                textduhur.setText("11.44");
                textashar.setText("15.04");
                textmaghrib.setText("17.34");
                textisya.setText("18.50");
                break;

            //jika test surabaya maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Surabaya":
                st_hasil.setText("Surabaya");
                textsubuh.setText("04.19");
                textduhur.setText("11.35");
                textashar.setText("15.55");
                textmaghrib.setText("17.26");
                textisya.setText("18.40");
                break;

            //jika test denpasar maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Denpasar":
                st_hasil.setText("Denpasar");
                textsubuh.setText("05.11");
                textduhur.setText("12.25");
                textashar.setText("15.44");
                textmaghrib.setText("18.13");
                textisya.setText("19.28");
                break;

            //jika test mataram maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Mataram":
                st_hasil.setText("Mataram");
                textsubuh.setText("05.08");
                textduhur.setText("12.21");
                textashar.setText("15.40");
                textmaghrib.setText("18.10");
                textisya.setText("19.24");
                break;

            //jika test makassar maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Makassar":
                st_hasil.setText("Makassar");
                textsubuh.setText("04.49");
                textduhur.setText("12.08");
                textashar.setText("15.30");
                textmaghrib.setText("18.03");
                textisya.setText("19.17");
                break;

            //jika test pontianak maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Pontianak":
                st_hasil.setText("Pontianak");
                textsubuh.setText("04.20");
                textduhur.setText("11.48");
                textashar.setText("15.13");
                textmaghrib.setText("17.52");
                textisya.setText("19.06");
                break;

            //jika test palangkaraya maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Palangkaraya":
                st_hasil.setText("Palangkaraya");
                textsubuh.setText("04.06");
                textduhur.setText("11.30");
                textashar.setText("14.54");
                textmaghrib.setText("17.30");
                textisya.setText("18.44");
                break;

            //jika test banjarmasin maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Banjarmasin":
                st_hasil.setText("Banjarmasin");
                textsubuh.setText("05.05");
                textduhur.setText("12.27");
                textashar.setText("15.50");
                textmaghrib.setText("18.25");
                textisya.setText("19.39");
                break;

            //jika test samarinda maka jadwal (textview) pada layout akan berubah seperti dibawah ini
            case "Samarinda":
                st_hasil.setText("Samarinda");
                textsubuh.setText("04.50");
                textduhur.setText("12.17");
                textashar.setText("15.42");
                textmaghrib.setText("18.20");
                textisya.setText("19.34");
                break;

            //jika test jayapura maka jadwal (textview) pada layout akan berubah seperti dibawah ini
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