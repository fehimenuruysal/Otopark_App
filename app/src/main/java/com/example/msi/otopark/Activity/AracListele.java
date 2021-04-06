package com.example.msi.otopark.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.msi.otopark.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AracListele extends AppCompatActivity {
    ArrayList<User> users;
    Button listele;

    GridAdapter gridAdapter;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_listele);

        users = new ArrayList<>();
        gridAdapter=new GridAdapter(this,users);
        gridView=(GridView)findViewById(R.id.gridView) ;


        listele = (Button) findViewById(R.id.listele);
        listele.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
               /* Intent intent = new Intent(getApplicationContext(),AracListele.class);
                startActivity(intent);*/
               /*for (int i=0; i< users.size();i++){//ARRAYE EKLEME YAPIYOR

                    Log.d("UYE",users.get(i).getAd());
                }*/

                gridView.setAdapter(gridAdapter);//BUTONA BASINCA EKLEME YAPAR
            }
        });

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference();//database referansını oluşturduk


        //users tablomun içindeki veriler
        myRef.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    User user=postSnapshot.getValue(User.class);
        //String ad, String soyad, String plaka, String eposta, String telefon, String aracmodel, String aracmarka
                    users.add(new User(
                            user.getAd(),user.getSoyad(),user.getPlaka(),user.getTelefon(),
                            user.getEposta(),user.getAracmarka(),user.getAracmodel()

                    )

                    );


                    Log.d("LOG",user.getAd());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}
