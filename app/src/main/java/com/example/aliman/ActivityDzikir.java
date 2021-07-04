package com.example.aliman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityDzikir extends AppCompatActivity {

    //deklarasi variabel jenis data listview
    private ListView list;
    //memanggil class listviewadapter dengan inisial adapter
    private ListViewAdapter adapter;

    //deklarasi array unyuk menyimpan data
    String[] listNomor;
    String[] listDesc;

    //panggil classdzikir dan classdesc
    public static ArrayList<ClassDzikir> classNomorArrayList = new ArrayList<ClassDzikir>();
    public static ArrayList<ClassDesc> classDescArrayList = new ArrayList<ClassDesc>();
    //membuat objek bundle
    Bundle bundle = new Bundle();
    //membuat objek intent
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir);
        //menyimpan nilai dalam array listnomor
        listNomor = new String[]{"1", "2", "3","4","5","6",
                "7","8","9","10"};
//meyimpan nilai dalam array listdesc
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

        //menghubungkan list pada komponen list di layout
        list = findViewById(R.id.listKontak);
        //membuat objek dari classNomor dan ClassDzikir menjadi arraylist
        classNomorArrayList = new ArrayList<>();
        classDescArrayList = new ArrayList<>();

        //membaca seluruh data pada array listNomor dan listDesc
        for(int i=0;i<listNomor.length;i++){
            //membuat objek classnomor dari class classdzikir
            ClassDzikir classNomor = new ClassDzikir(listNomor[i]);
           // binds string ke array
            classNomorArrayList.add(classNomor);

            //membuat objek classdesc dari class classdesc
            ClassDesc classDesc = new ClassDesc(listDesc[i]);
            // binds string ke array
            classDescArrayList.add(classDesc);
        }
        //membuat objek dari listviewadapter
        adapter = new ListViewAdapter(this);
        //binds adapter ke listview
        list.setAdapter(adapter);
        //membuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*..deklarasi variabel nama yang berisi item yang diklik*/
                String nomor = classNomorArrayList.get(position).getNomor();
                //memasukan value dari variabel nomor dengan kunci a dan dimasukan ke bundel
                bundle.putString("a",nomor.trim());
                //membuat objek intent
                Intent i = new Intent(getApplicationContext(), ActivityDzikirCounter.class);
                //memasukan bundel kedalamintent
                i.putExtras(bundle);
                //membuka halaman baru
                startActivity(i);
            }
        });
    }
}