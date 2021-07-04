package com.example.aliman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel button
    Button bdzikir,bjadwal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan button ke bbuton di layout
        bdzikir = findViewById(R.id.btndzikir);
        bjadwal = findViewById(R.id.btnjadwal);

        //function onclik pada button bdzikir
        bdzikir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //objek intent untuk pindah activity
                Intent i = new Intent(getApplicationContext(),ActivityDzikir.class);
                //pindah ke activity activitu dzikir
                startActivity(i);
            }
        });
        //function onclik pada button bjadwal
        bjadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //objek intent untuk pindah activity
                Intent i = new Intent(getApplicationContext(),ActivitySholat.class);
                //pindah ke activity activitu sholat
                startActivity(i);
            }
        });
    }
}