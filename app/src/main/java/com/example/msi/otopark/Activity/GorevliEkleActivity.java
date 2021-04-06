package com.example.msi.otopark.Activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.msi.otopark.R;

public class GorevliEkleActivity extends AppCompatActivity {

    public veritabani gorevliler; // Referans olan nesne daha oluşturulmamış veritabanı nesnesi

    public TextView ad; // Sisteme girmeye çalışan görevlinin ekrandan adını alınıp atanacağı değişken.
    public TextView parola ; // Sisteme girmeye çalışan görevlinin ekrandan parolasını alınıp atanacağı değişken.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorevli_ekle);
        gorevliler = new veritabani(this); // Görevli ad ve parolaları tutan veritabanı bu aktivite için this ile içerikleri aktarılarak oluştulur.
    }

    public void ekle_button(View view){
        Görevli gorevli = new Görevli();
        ad =(TextView)findViewById(R.id.ad); //Girilen ad alınır ve textview türüne çevrilir.
        String gorevli_ad = ad.getText().toString(); // Textview türündeki veride kullanım kolaylığı için stringe çevrilir.
        gorevli.setIsim(gorevli_ad);
        parola = (TextView)findViewById(R.id.parola);//Girilen parola alınır ve textview türüne çevrilir.
        String sifre = parola.getText().toString(); // Textview türündeki veride kullanım kolaylığı için stringe çevrilir.
        gorevli.setParola(sifre);
        KayitEkle(gorevli); // Kayıt ekle fonksiyonuna eklenecek kaydın kolon içerikleri paramatre olarak gönderilir.
    }

    public void KayitEkle(Görevli gorevli){
        SQLiteDatabase db = gorevliler.getWritableDatabase(); // Görevli bilgileri tutulan veritabanı yazma modunda açılır.
        ContentValues veriler = new ContentValues(); // Kayıt için veriler nesnesi oluşturulur.
        veriler.put("isim", gorevli.getIsim()); // isim kolonuna görevli nesnsinin ad değişkeni koyulur.
        veriler.put("parola",gorevli.getParola()); // parola kolonuna görevli nesnsinin parola değişkeni koyulur.
        db.insertOrThrow("gorevli", null, veriler); // SQLite veritabanı fonksiyonu olan insertOrThrow ile kayıt veri tabanına eklenir.

        //Herhangi bir koşul amaçlanmadığından kısıt bulunmadığından görevli tarafından görevli eklenmesi kesin gerçekleşecektir.Bu yüzdenn kontrol oluşturmadan alert verilir.
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("İşlem Bilgisi ");
        alert.setMessage("Görevli Başarı İle Eklendi");
        alert.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {}
        });
        alert.show();
    }
}