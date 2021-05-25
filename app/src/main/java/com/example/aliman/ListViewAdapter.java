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

    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ClassDzikir> arrayList;
    private List<ClassDzikir> appList;
    private ArrayList<ClassDesc> arrayList2;
    private List<ClassDesc> appList2;

    public ListViewAdapter(Context context)
    {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ClassDzikir>();
        this.arrayList.addAll(ActivityDzikir.classNomorArrayList);
        this.arrayList2 = new ArrayList<ClassDesc>();
        this.arrayList2.addAll(ActivityDzikir.classDescArrayList);
    }



    public class ViewHolder{
        TextView nomor;
        TextView desc;
    }


    @Override
    public int getCount() {
        return ActivityDzikir.classNomorArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return ActivityDzikir.classNomorArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if(view == null)
        {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview,null);

            holder.nomor = (TextView) view.findViewById(R.id.tvnomor_item);
            holder.desc = (TextView) view.findViewById(R.id.tvdesc_item);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        holder.nomor.setText(ActivityDzikir.classNomorArrayList.get(i).getNomor());
        holder.desc.setText(ActivityDzikir.classDescArrayList.get(i).getDesc());
        return view;
    }
}
