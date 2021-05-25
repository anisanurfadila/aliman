package com.example.aliman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityDzikirCounter extends AppCompatActivity {
    TextView tvnama,tvnomor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir_counter);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();

        String nomor = bundle.getString("a");

        switch (nomor)
        {
            case "1":
                tvnama.setText("Inayah M");
                tvnomor.setText("1238929");
                break;
            case "2":
                tvnama.setText("Ilham Mubarok");
                tvnomor.setText("243739");
                break;
            case "3":
                tvnama.setText("Erisna sutisna");
                tvnomor.setText("32387923");
                break;
            case "4":
                tvnama.setText("fikri fadlu");
                tvnomor.setText("4372732");
                break;
            case "5":
                tvnama.setText("Maulana hidayah");
                tvnomor.setText("5983239");
                break;
            case "6":
                tvnama.setText("Intan perwari");
                tvnomor.setText("623989832");
                break;
            case "7":
                tvnama.setText("vina panduwinata");
                tvnomor.setText("72399237");
                break;
            case "8":
                tvnama.setText("gita gutawa");
                tvnomor.setText("8237323");
                break;
            case "9":
                tvnama.setText("Vian Munawaroh");
                tvnomor.setText("9238723");
                break;
            case "10":
                tvnama.setText("Lutfiatun");
                tvnomor.setText("10329832");
                break;
        }

    }
}