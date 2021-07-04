package com.example.aliman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    //deklarasi variabel context
    Context mContext;
    //deklarasi variabel inflater
    LayoutInflater inflater;
    //deklarasi variabel arraylist yg diambil dari Classdzikir
    private ArrayList<ClassDzikir> arrayList;
    private List<ClassDzikir> appList;
    //deklarasi variabel arraylist yg diambil dari Classdesc
    private ArrayList<ClassDesc> arrayList2;
    private List<ClassDesc> appList2;

    //kontruktor listview adapter
    public ListViewAdapter(Context context)
    {
        //beri nilai awal mcontext dgn context;
        mContext = context;

        //mengatur layout inflaater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);
        //membri nilai arraylist dari Classdzikir
        this.arrayList = new ArrayList<ClassDzikir>();
        //menambahkan semua elemen ke arraylist
        this.arrayList.addAll(ActivityDzikir.classNomorArrayList);

        //membri nilai arraylist dari Classdesc
        this.arrayList2 = new ArrayList<ClassDesc>();
        //menambahkan semua elemen ke arraylist2
        this.arrayList2.addAll(ActivityDzikir.classDescArrayList);
    }


    //CLASS UNTUK DEKLARASI TEMPAT UNTUK LMELETAKAN ISI KE DALAM LISTVIEW
    public class ViewHolder{
        //deklarasi variabel textview
        TextView nomor;
        TextView desc;
    }

    //fungsi getcount untuk mengembalikan jumlah item yang akan ditampilkan dalam list

    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return ActivityDzikir.classNomorArrayList.size();
    }

    //membuat function untuk mendapatkan posisi data item dari kumpulan array

    @Override
    public Object getItem(int i) {
        return ActivityDzikir.classNomorArrayList.get(i);
    }

    //mengembalikan nilai dari posisi item ke adapter
    @Override
    public long getItemId(int i) {
        return i;
    }

    //fungsi untuk tampil data, otomatis dipanggil
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabel view holder
        final ViewHolder holder;

        //cek kondisi apakah view null
        if(view == null)
        {
            //membuat objek view holder
            holder = new ViewHolder();
            //mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview,null);

            //menyambungkan textview yg ada di layout dengan holder
            holder.nomor = (TextView) view.findViewById(R.id.tvnomor_item);
            holder.desc = (TextView) view.findViewById(R.id.tvdesc_item);
            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain
            view.setTag(holder);

        } else {
            //mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder)view.getTag();
        }
        //set item ke textview
        holder.nomor.setText(ActivityDzikir.classNomorArrayList.get(i).getNomor());
        holder.desc.setText(ActivityDzikir.classDescArrayList.get(i).getDesc());
        //mengembalikan nilai ke variabel view
        return view;
    }
}
