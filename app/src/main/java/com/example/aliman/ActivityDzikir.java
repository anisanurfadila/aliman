package com.example.aliman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityDzikir extends AppCompatActivity {

    private ListView list;
    private ListViewAdapter adapter;

    String[] listNomor;
    String[] listDesc;

    public static ArrayList<ClassDzikir> classNomorArrayList = new ArrayList<ClassDzikir>();
    public static ArrayList<ClassDesc> classDescArrayList = new ArrayList<ClassDesc>();
    Bundle bundle = new Bundle();

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir);

        listNomor = new String[]{"1", "2", "3","4","5","6",
                "7","8","9","10"};

        listDesc = new String[]{
                "Astaghfirullah",
                "Subhanallah",
                "Alhamdulillah",
                "Allahuakbar",
                "Laa Ilaaha Illallaahu Wahdahuu Laa Syariika Lah, Lahul Mulku Wa Lahul Hamdu Wa Huwa’Alaa Kulli Syai’in Qadhr",
                "Allaahumma antas salaamu wa minkas salaamu wa ilaika ya’uduus salaamu fa hayyinaa rabbanaa bis salaami wa adkhinal- jannata daaras salaami tabaarakta rabbanaa wa ta’aalaita yaa dzal jalaali wal ikram.",
                "Wa ilaahukum ilaahuw waahidun laa ilaaha ilaa huwar rahmaanur rahiim.",
                "Allaahumma laa maani’a limaa a’thaita wa laa mu’thiya limaa mana’ta wa laa radda limaa qadhaita wa laa yanfa’u dzal-jaddi minkal-jaddu.",
                "Allaahu akbar kabiiraw wal-hamdu lillaahi katsiiraw wa subhaanallahi bukrataw wa ashiila. Laa ilaaha illallaahu wahdahuu laa syariikalahu, lahul mulku wa lahul hamdu yuhyii wa yumiitu wa huwa’alaa kulli syai’in qadiir.",
                "Wa laa haula wa laa quwwata illaa billaahil-‘aliyyil ‘azhiim. Astagfirullaahal-‘azhiim."};

        list = findViewById(R.id.listKontak);
        classNomorArrayList = new ArrayList<>();
        classDescArrayList = new ArrayList<>();

        for(int i=0;i<listNomor.length;i++){
            ClassDzikir classNomor = new ClassDzikir(listNomor[i]);
            classNomorArrayList.add(classNomor);
            ClassDesc classDesc = new ClassDesc(listDesc[i]);
            classDescArrayList.add(classDesc);
        }



        adapter = new ListViewAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nomor = classNomorArrayList.get(position).getNomor();

                bundle.putString("a",nomor.trim());
                Intent i = new Intent(getApplicationContext(), ActivityDzikirCounter.class);
                i.putExtras(bundle);

                startActivity(i);
            }
        });
    }
}