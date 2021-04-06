package com.example.msi.otopark.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridView;

import com.example.msi.otopark.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.View;

import java.util.ArrayList;

public class MusteriGiris extends AppCompatActivity {
    ArrayList<User> users;
    GridAdapter gridAdapter2;
    GridView gridView;
    int sayac=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_giris);
        users = new ArrayList<>();


        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference();//database referansını oluşturduk
        gridAdapter2=new GridAdapter(this,users);
        gridView=(GridView)findViewById(R.id.gridView) ;


        Button yenikayit = (Button) findViewById(R.id.yenikayit);
        Button dolulukorani = (Button) findViewById(R.id.dolulukorani);

        yenikayit.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(getApplicationContext(),KayitEkrani.class);

               startActivity(intent);
            }
        });

        dolulukorani.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                gridView.setAdapter(gridAdapter2);//BUTONA BASINCA EKLEME YAPAR


            }
        });


        //users tablomun içindeki veriler
        myRef.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User user = postSnapshot.getValue(User.class);
                    //String ad, String soyad, String plaka, String eposta, String telefon, String aracmodel, String aracmarka
                    users.add(new User(
                            user.getAd(), user.getSoyad(), user.getPlaka(), user.getTelefon(), user.getAracmarka(),
                            user.getEposta(), user.getAracmodel()

                    ));

                    Log.d("LOG", user.getAd());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


            public void yenikayit(View view) {
                Intent intent = new Intent(getApplicationContext(), KayitEkrani.class);
                startActivity(intent);

            }

            public void doluluk(View view) {
               /* Intent intent = new Intent(getApplicationContext(), Doluluk.class);


                startActivity(intent);*/
}
        });
    }}