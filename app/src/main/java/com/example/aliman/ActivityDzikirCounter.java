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
    //deklarasi variabel
    TextView tvnama,tvnomor,tvmaks;
    int max,hitungan;
    Button btpopup,bttambah,btkurang,btreset;
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir_counter);

        //menghubungkan variabel dengan komponen yang ada di layout
        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);
        //hilai awal hitungan 0
        hitungan = 0;
        tvmaks = findViewById(R.id.txtmaks);

        bttambah = findViewById(R.id.btntambah);
        btkurang = findViewById(R.id.btnkurang);
        btreset = findViewById(R.id.btnreset);
        btpopup = findViewById(R.id.btnpopup);

        //membuat objek dari dialog
        mDialog = new Dialog(this);

        //mengambil bundle yang dikirim lewat intent tadi
        Bundle bundle = getIntent().getExtras();
        //memberi nilai pd variabel nomor dengan nilai bundle dengan kata kunci a
        String nomor = bundle.getString("a");
        //membuat bundle baru untuk menyimpan data yg nntinya kan dikirim untuk halaman lain
        Bundle gobundle = new Bundle();

        //dmembuat objek vibrator
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
        //switch case dengan kondisi nomor
        switch (nomor)
        {
            //jika nomor 1
            case "1":
                // set tvnama,tvmaks, beri nilai max, dan masukan nilai kedalam bundle
                tvnama.setText("Astaghfirullah");
                max = 99;
                tvmaks.setText(Integer.toString(max));
                gobundle.putString("data1", "1");
                break;
            //jika nomor 2
            case "2":
                // set tvnama,tvmaks, beri nilai max, dan masukan nilai kedalam bundle
                tvnama.setText("Subhanallah");
                max = 99;
                tvmaks.setText(Integer.toString(max));
                gobundle.putString("data1", "2");
                break;
            //jika nomor 3
            case "3":
                // set tvnama,tvmaks, beri nilai max, dan masukan nilai kedalam bundle
                tvnama.setText("Alhamdulillah");
                max = 99;
                tvmaks.setText(Integer.toString(max));
                gobundle.putString("data1", "3");
                break;
            //jika nomor 4
            case "4":
                // set tvnama,tvmaks, beri nilai max, dan masukan nilai kedalam bundle
                tvnama.setText("Allahuakbar");
                max = 99;
                tvmaks.setText(Integer.toString(max));
                gobundle.putString("data1", "4");
                break;
            //jika nomor 5
            case "5":
                // set tvnama,tvmaks, beri nilai max, dan masukan nilai kedalam bundle
                max = 10;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Laa Ilaaha Illallaahu Wahdahuu Laa Syariika Lah, Lahul Mulku Wa Lahul Hamdu Wa Huwa’Alaa Kulli Syai’in Qadhr");
                gobundle.putString("data1", "5");
                break;
            //jika nomor 6
            case "6":
                // set tvnama,tvmaks, beri nilai max, dan masukan nilai kedalam bundle
                max = 10;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Allaahumma antas salaamu wa minkas salaamu wa ilaika ya’uduus salaamu fa hayyinaa rabbanaa bis salaami wa adkhinal- jannata daaras salaami tabaarakta rabbanaa wa ta’aalaita yaa dzal jalaali wal ikram");
                gobundle.putString("data1", "6");
                break;
            //jika nomor 7
            case "7":
                // set tvnama,tvmaks, beri nilai max, dan masukan nilai kedalam bundle
                max = 10;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Wa ilaahukum ilaahuw waahidun laa ilaaha ilaa huwar rahmaanur rahiim.");
                gobundle.putString("data1", "7");
                break;
            //jika nomor 8
            case "8":
                // set tvnama,tvmaks, beri nilai max, dan masukan nilai kedalam bundle
                max = 10;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Allaahumma laa maani’a limaa a’thaita wa laa mu’thiya limaa mana’ta wa laa radda limaa qadhaita wa laa yanfa’u dzal-jaddi minkal-jaddu.");
                gobundle.putString("data1", "8");
                break;
            //jika nomor 9
            case "9":
                // set tvnama,tvmaks, beri nilai max, dan masukan nilai kedalam bundle
                max = 10;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Allaahu akbar kabiiraw wal-hamdu lillaahi katsiiraw wa subhaanallahi bukrataw wa ashiila. Laa ilaaha illallaahu wahdahuu laa syariikalahu, lahul mulku wa lahul hamdu yuhyii wa yumiitu wa huwa’alaa kulli syai’in qadiir");
                gobundle.putString("data1", "9");
                break;
            //jika nomor 10
            case "10":
                // set tvnama,tvmaks, beri nilai max, dan masukan nilai kedalam bundle
                max = 10;
                tvmaks.setText(Integer.toString(max));
                tvnama.setText("Wa laa haula wa laa quwwata illaa billaahil-‘aliyyil ‘azhiim. Astagfirullaahal-‘azhiim.");
                gobundle.putString("data1", "10");
                break;
        }

        //method jika button tambah diklik
        bttambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cek kondisi jika hitungan kurang dari mac
                if (hitungan<max) {
                    //jika ya, hitungan ditambah
                    hitungan++;
                    //vibraor nyala, maka ho getar dengan lama 100 milisecond
                    vibe.vibrate(100);
                    //set nilai pada tvnomor
                    tvnomor.setText(Integer.toString(hitungan));
                }
                else {
                    //jika sudah maks maka hitungan selesai
                    Toast.makeText(getApplicationContext(), "صَدَقَ اللهُ اْلعَظِيْمُ",Toast.LENGTH_LONG).show();

                }
            }
        });

        //method jika button kurang diklik
        btkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hitungan berkurang
                hitungan--;
                //set nniali pd tvnomor
                tvnomor.setText(Integer.toString(hitungan));
            }
        });
        //method jika btn reset diklik,
        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hitungan mulai dr awal
                hitungan = 0;
                //set nniali pd tvnomor
                tvnomor.setText(Integer.toString(hitungan));
            }
        });
        //method button popup diklik
        btpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buat objek intent untuk masuk ke halaman popup
                Intent i = new Intent(ActivityDzikirCounter.this,PopupInfo.class);
                //masukan gobundle kedalam intent
                i.putExtras(gobundle);
                //halaman baru dibuka
                startActivity(i);
            }
        });
    }


}