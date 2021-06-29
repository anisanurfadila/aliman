package com.example.aliman;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;

public class ActivityDzikirCounter extends AppCompatActivity {
    TextView tvnama,tvnomor,tvmaks, tvarab;
    int max,hitungan;
    Button btpopup,bttambah,btkurang,btreset;
    Dialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir_counter);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);
        hitungan = 0;
        tvmaks = findViewById(R.id.txtmaks);

        bttambah = findViewById(R.id.btntambah);
        btkurang = findViewById(R.id.btnkurang);
        btreset = findViewById(R.id.btnreset);
        btpopup = findViewById(R.id.btnpopup);

        mDialog = new Dialog(this);

        Bundle bundle = getIntent().getExtras();
        String nomor = bundle.getString("a");

        Bundle gobundle = new Bundle();

        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
        switch (nomor)
        {
            case "1":
                tvnama.setText("Astaghfirullah");
                max = 99;
                tvmaks.setText(Integer.toString(max));
                gobundle.putString("data1", "1");
             //   tvarab.setText("أستغفر الله");

               // tvnomor.setText("1238929");
                break;
            case "2":
                tvnama.setText("Subhanallah");
                max = 99;
                tvmaks.setText(Integer.toString(max));
                gobundle.putString("data1", "2");
             //   tvnomor.setText("243739");
                break;
            case "3":
                tvnama.setText("Alhamdulillah");
                max = 99;
                tvmaks.setText(Integer.toString(max));
                gobundle.putString("data1", "3");
             //   tvnomor.setText("32387923");
                break;
            case "4":
                tvnama.setText("Allahuakbar");
                max = 99;
                tvmaks.setText(Integer.toString(max));
                gobundle.putString("data1", "4");
             //   tvnomor.setText("4372732");
                break;
            case "5":
                max = 99;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Laa Ilaaha Illallaahu Wahdahuu Laa Syariika Lah, Lahul Mulku Wa Lahul Hamdu Wa Huwa’Alaa Kulli Syai’in Qadhr");
                gobundle.putString("data1", "5");
                //   tvnomor.setText("5983239");
                break;
            case "6":
                max = 99;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Allaahumma antas salaamu wa minkas salaamu wa ilaika ya’uduus salaamu fa hayyinaa rabbanaa bis salaami wa adkhinal- jannata daaras salaami tabaarakta rabbanaa wa ta’aalaita yaa dzal jalaali wal ikram");
                gobundle.putString("data1", "6");
             //   tvnomor.setText("623989832");
                break;
            case "7":
                max = 99;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Wa ilaahukum ilaahuw waahidun laa ilaaha ilaa huwar rahmaanur rahiim.");
                gobundle.putString("data1", "7");
            //    tvnomor.setText("72399237");
                break;
            case "8":
                max = 99;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Allaahumma laa maani’a limaa a’thaita wa laa mu’thiya limaa mana’ta wa laa radda limaa qadhaita wa laa yanfa’u dzal-jaddi minkal-jaddu.");
                gobundle.putString("data1", "8");
            //    tvnomor.setText("8237323");
                break;
            case "9":
                max = 99;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Allaahu akbar kabiiraw wal-hamdu lillaahi katsiiraw wa subhaanallahi bukrataw wa ashiila. Laa ilaaha illallaahu wahdahuu laa syariikalahu, lahul mulku wa lahul hamdu yuhyii wa yumiitu wa huwa’alaa kulli syai’in qadiir");
                gobundle.putString("data1", "9");
            //    tvnomor.setText("9238723");
                break;
            case "10":
                max = 99;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Wa laa haula wa laa quwwata illaa billaahil-‘aliyyil ‘azhiim. Astagfirullaahal-‘azhiim.");
                gobundle.putString("data1", "10");
            //    tvnomor.setText("10329832");
                break;
        }

        bttambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hitungan<max) {
                    hitungan++;
                    vibe.vibrate(100);
                    tvnomor.setText(Integer.toString(hitungan));
                }
                else {
                    Toast.makeText(getApplicationContext(), "صَدَقَ اللهُ اْلعَظِيْمُ",Toast.LENGTH_LONG).show();

                }
            }
        });

        btkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungan--;
                tvnomor.setText(Integer.toString(hitungan));
            }
        });
        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungan = 0;
                tvnomor.setText(Integer.toString(hitungan));
            }
        });

        btpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityDzikirCounter.this,PopupInfo.class);
                i.putExtras(gobundle);
                startActivity(i);
            }
        });
    }


}