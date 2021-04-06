package com.example.msi.otopark.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.msi.otopark.R;

import java.util.ArrayList;

public class GridDoluluk extends BaseAdapter {
    int sayac=0;
    ArrayList<User> users;
    LayoutInflater layoutInflater2;
    Context context;//programın farklı yerinden bilgi almak için kullanılır.
    //TextView tvAd,tvSoyad,tvPlaka,tvEposta,tvTelefon,tvModel,tvMarka;
    public GridDoluluk (Activity activity , ArrayList<User> users){
        this.users=users;
        this.context=activity;
        this.layoutInflater2=
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /*public GridAdapter() {
        super();
    }*/

    @Override
    public int getCount() {

        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view2 = layoutInflater2.inflate(R.layout.gridview_doluluk,null);
        TextView tplaka=(TextView)view2.findViewById(R.id.tplaka);
        tplaka.setText(users.get(position).getPlaka());

        return view2;


    }
}
