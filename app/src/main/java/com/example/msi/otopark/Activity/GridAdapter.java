package com.example.msi.otopark.Activity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.msi.otopark.R;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    ArrayList<User> users;
    LayoutInflater layoutInflater;
    Context context;
    //TextView tvAd,tvSoyad,tvPlaka,tvEposta,tvTelefon,tvModel,tvMarka;
    public GridAdapter (Activity activity , ArrayList<User> users){
        this.users=users;
        this.context=activity;
        this.layoutInflater=
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.gridview_gorunumu,null);


        TextView tvAd=(TextView)view.findViewById(R.id.tvAd);
        TextView tvSoyad=(TextView)view.findViewById(R.id.tvSoyad);
        TextView tvPlaka=(TextView)view.findViewById(R.id.tvPlaka);
        TextView tvEposta=(TextView)view.findViewById(R.id.tvEposta);
        TextView tvTelefon=(TextView)view.findViewById(R.id.tvTelefon);
        TextView tvModel=(TextView)view.findViewById(R.id.tvModel);
        TextView tvMarka=(TextView)view.findViewById(R.id.tvMarka);




        tvAd.setText(users.get(position).getAd());   //array listten alıyoruz users
        tvSoyad.setText(users.get(position).getSoyad());
        tvPlaka.setText(users.get(position).getPlaka());
        tvEposta.setText(users.get(position).getEposta());
        tvTelefon.setText(users.get(position).getTelefon());
        tvModel.setText(users.get(position).getAracmodel());
        tvMarka.setText(users.get(position).getAracmarka());



      return view;

    }

}
