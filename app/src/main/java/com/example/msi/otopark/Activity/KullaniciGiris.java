package com.example.msi.otopark.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.msi.otopark.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.view.View;

public class KullaniciGiris extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_giris);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        Button aracgiris = (Button) findViewById(R.id.aracgiris);
        Button araccikis = (Button) findViewById(R.id.araccikis);
        Button araclistele = (Button) findViewById(R.id.araclistele);
        Button kazanchesapla = (Button) findViewById(R.id.kazanchesapla);
        Button musteriyegec = (Button) findViewById(R.id.musteriyegec);

//        myRef.setValue("Hello, World!");

        aracgiris.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(getApplicationContext(),AracGirisi.class);
                startActivity(intent);
            }
        });

        araccikis.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(getApplicationContext(),AracCikisi.class);
                startActivity(intent);
            }
        });

        araclistele.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(getApplicationContext(),AracListele.class);
                startActivity(intent);
            }
        });
        kazanchesapla.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(getApplicationContext(),KullaniciGiris.class);
                startActivity(intent);
            }
        });
        musteriyegec.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(getApplicationContext(),MusteriGiris.class);
                startActivity(intent);
            }
        });

    }


    public void aracgiris(View view) {
        Intent intent = new Intent(getApplicationContext(), AracGirisi.class);
        startActivity(intent);



    }

    public void araccikis(View view) {
        Intent intent = new Intent(getApplicationContext(), AracCikisi.class);
        startActivity(intent);

    }

    public void araclistele(View view) {
        Intent intent = new Intent(getApplicationContext(), KullaniciGiris.class);
        startActivity(intent);

    }

    public void kazanchesapla(View view) {
        Intent intent = new Intent(getApplicationContext(), KullaniciGiris.class);
        startActivity(intent);

    }

    public void musteriyegec(View view) {
        Intent intent = new Intent(getApplicationContext(), MusteriGiris.class);
        startActivity(intent);



    }


    public void silme_gecis(android.view.View view) {
        //Intent classından bagla_silme_sayfasi nesnesi oluşturarak butona basıldığında GorevliSilActivity ekranımıza geçişi sağlarız.
        Intent bagla_silme_sayfasi= new Intent(getApplicationContext(),GorevliSilActivity.class);
        //Sonrada baglamayı başlatmak için alt satırdaki komut kullanılır
        startActivity(bagla_silme_sayfasi);
    }

    public void ekleme_gecis(android.view.View view) {
        //Intent classından bagla_eklme_sayfasi nesnesi oluşturarak butona basıldığında GorevliEkleActivity ekranımıza geçişi sağlarız.
        Intent bagla_eklme_sayfasi = new Intent(getApplicationContext(),GorevliEkleActivity.class);
        //Sonrada baglamayı başlatmak için alt satırdaki komut kullanılır
        startActivity(bagla_eklme_sayfasi);
    }
}