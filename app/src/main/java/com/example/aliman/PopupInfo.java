package com.example.aliman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

public class PopupInfo extends AppCompatActivity {

    TextView keterangan, arab,arti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info);

        keterangan = findViewById(R.id.tv_keterangan);
        arab = findViewById(R.id.tv_arabic);
        arti = findViewById(R.id.tv_arti);

        DisplayMetrics ds = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(ds);

        int width = ds.widthPixels;
        int height = ds.heightPixels;

        getWindow().setLayout((int)(width*.7),(int)(height*.5));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x=0;
        params.y = -20;
        getWindow().setAttributes(params);

        Bundle gobundle = getIntent().getExtras();
        String gobun = gobundle.getString("data1");

        switch (gobun)
        {
            case "1":
                keterangan.setText("Astaghfirullah");
                arab.setText("أستغفر الله");
                arti.setText("“Aku memohon ampun kepada Allah Yang Maha Agung ”");
                break;
            case "2":
                keterangan.setText("Subhanallah");
                arab.setText("سبحان الله");
                arti.setText("“Maha Suci Allah ”");
                break;
            case "3":
                keterangan.setText("Alhamdulillah");
                arab.setText("الحمد لله");
                arti.setText("“Segala puji bagi Allah Tuhan semesta alam. ”");
                break;
            case "4":
                keterangan.setText("Allahuakbar");
                arab.setText("الله أكبر");
                arti.setText("“Allah Maha Besar. ”");
                break;
            case "5":
                keterangan.setText("Laa Ilaaha Illallaahu Wahdahuu Laa Syariika Lah, Lahul Mulku Wa Lahul Hamdu Wa Huwa’Alaa Kulli Syai’in Qadhr");
                arab.setText("لا إله إلا الله وحداهو لا سياريكا لاه ، لاهول ملكو ولهول حمدو وهواعلا كولي سياعين قذر");
                arti.setText("“Tidak ada Tuhan yang wajib disembah kecuali Allah Yang Maha Esa. Tidak ada sekutu bagi-Nya. Dialah yang mempunyai kekuasaan dan kerajaan yang memerintahkan, bagi-Nya segala puji-pujian yang menghidupkan dan mematikan, dan Dia berkuasa atas segala sesuatu ”");
                break;
            case "6":
                keterangan.setText("Allaahumma antas salaamu wa minkas salaamu wa ilaika ya’uduus salaamu fa hayyinaa rabbanaa bis salaami wa adkhinal- jannata daaras salaami tabaarakta rabbanaa wa ta’aalaita yaa dzal jalaali wal ikram");
                arab.setText("الله يما أنتس سلام ومينكاس سلام وإليكة يعودوس سلام فا هاينا ربانة بيس سلام وأدخين - جاناتا داراس سلام تباركتا ربانة وتعالايتا يا دزال جلالي والإكرام");
                arti.setText("“Ya Allah Engkau adalah Dzat yang mempunyai kesejahteraan dan daripada- Mulah kesejahteraan itu dan kepada- Mulah akan kembali lagi segala kesejahteraan itu. Ya Tuhan kami, hidupkanlah kami dengan sejahtera. Dan masukkanlah kami ke dalam surga kampung kesejahteraan. Engkaulah yang kuasa memberiberkah yang banyak dan Engkaulah Yang Maha Tinggi, wahai Zat yang memiliki keagungan dan kemuliaan. ”");
                break;
            case "7":
                keterangan.setText("Wa ilaahukum ilaahuw waahidun laa ilaaha ilaa huwar rahmaanur rahiim.");
                arab.setText("وعلي حكم الله ووحيدون لا إله إلاه حور رحمنور رحيم.");
                arti.setText("“Tuhanmu adalah Tuhan Yang Maha Esa, tidak ada Tuhan melainkan Dia, Yang Maha Pengasih lagi Maha Penyayang. ”");
                break;
            case "8":
                keterangan.setText("Allaahumma laa maani’a limaa a’thaita wa laa mu’thiya limaa mana’ta wa laa radda limaa qadhaita wa laa yanfa’u dzal-jaddi minkal-jaddu.");
                arab.setText("اللهما لا معاني ليما عثيتة ولا مؤثية ليما منعت ولا رده ليما قضايتة ولا ينفعو دزال-جدي مينكال-جدو");
                arti.setText("“Ya Allah, tidak ada yang menghalangi segala apa yang Engkau berikan. Dan tidak ada yang dapat memberikan segala yang Engkau larang. Dan tidak ada yang menolak segala apa yang Engkau putuskan. Dan tidak bermanfaat kepada orang yang kaya di sisi Engkau segala kekayaannya. ”");
                break;
            case "9":
                keterangan.setText("Allaahu akbar kabiiraw wal-hamdu lillaahi katsiiraw wa subhaanallahi bukrataw wa ashiila. Laa ilaaha illallaahu wahdahuu laa syariikalahu, lahul mulku wa lahul hamdu yuhyii wa yumiitu wa huwa’alaa kulli syai’in qadiir");
                arab.setText("الله أكبر كبريراو والحمد لله كاتسيراو وسبحان الله بكراتاو واشييلا. لا إلآها إلا الله وحداه لا سياريكالهو ، لاهول مولكو ولاهول حمدو يوهيي ويومييتو وا هووا لالا كولي سيايين قدير");
                arti.setText("“Allah Maha Besar lagi sempurna kebesaran-Nya. Segala puji bagi Allah dengan puji yang banyak. Maha Suci Allah sepanjang pagi dan petang. Tidak ada Tuhan yang wajib disembah kecuali Allah Yang Maha Esa. Tidak ada sekutu bagi-Nya. Dialah yang mempunyai kekuasaan dan kerajaan yang memerintahkan, bagi-Nya segala puji- pujian yang menghidupkan dan mematikan, dan Dia berkuasa atas segala sesuatu. ”");
                break;
            case "10":
                keterangan.setText("Wa laa haula wa laa quwwata illaa billaahil-‘aliyyil ‘azhiim. Astagfirullaahal-‘azhiim.");
                arab.setText("ولا حولا ولا قواطة إلا بالله-علييل");
                arti.setText("“Dan tidak ada daya upaya dan kekuataan melainkan dengan pertolongan Allah Maha Tinggi lagi Maha Mulia. Saya mohon ampun kepada Allah Yang Maha Agung.”");
                break;
        }


    }
}