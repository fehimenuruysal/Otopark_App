package com.example.msi.otopark.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.msi.otopark.Activity.AracCikisi;
import com.example.msi.otopark.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class AracGirisi extends AppCompatActivity {
    Button aracgirisonayla;
    EditText plaka,girissaati;
    DatabaseReference dbRef;
    DateFormat df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_girisi);

        Date tarih = new Date();
        final SimpleDateFormat dakika = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        final String strdate = dakika.format(tarih);
        aracgirisonayla =(Button) findViewById(R.id.aracgirisonayla);
        plaka=(EditText)findViewById(R.id.plaka);
        girissaati=(EditText)findViewById(R.id.girissaati);
        //rootRef.child("time").setValue(ServerValue.TIMESTAMP);
        final FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

        aracgirisonayla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference newReferance=FirebaseDatabase.getInstance().getReference();
                dbRef=firebaseDatabase.getReference();
                System.out.println("tost"+ServerValue.TIMESTAMP+"     ");
                newReferance.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds:dataSnapshot.child("users").getChildren()){
                            HashMap<String, String> plakalar = (HashMap<String, String>) ds.getValue();
                                if(plakalar.containsValue(plaka.getText().toString())){
                                    dbRef.child("aracGiris").child(plaka.getText().toString()).setValue(
                                            new UserAracGiris(
                                                    plaka.getText().toString(),
                                                    strdate

                                            ));
                                }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                /*dbRef.push().setValue(
                  new UserAracGiris(
                         plaka.getText().toString(),
                         girissaati.getText().toString()

                  ));*/


            }
        });

    }

}
