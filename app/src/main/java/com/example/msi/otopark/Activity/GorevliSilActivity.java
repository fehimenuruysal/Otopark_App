package com.example.msi.otopark.Activity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.msi.otopark.R;

public class GorevliSilActivity extends AppCompatActivity {

    public veritabani gorevliler; // Referans olan nesne daha oluşturulmamış veritabanı nesnesi

    public TextView ad; // Silinecek olan görevli adının ekrandan alındıktan sonra atanacağı değişken

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorevli_sil);
        gorevliler = new veritabani(this); //Varolan veritabanındaki static tanımlanan veritabanını this ile bu aktivitede oluşturup kullanmayı sağlar.
    }

    public void gorevli_sil(View view) {
        ad = (TextView) findViewById(R.id.silinen_gorevli); //Ekrandan girilen görevli adını id ile çeker , textview olarak çevirir ve ad değişkenine atar.
        String gorevli_ad = ad.getText().toString(); // ad değişkenini String haline getirir.
        SQLiteDatabase db = gorevliler.getReadableDatabase(); //Veritabanı okunmak üzere açılır. SQliteDatabase db nesnesinin referans olarak göstermesi sağlanır.

        /*
         * SQLiteDatabase sistemindeki delete işlemi yapılır .
         * Parametreler  ; tablo adı  , hangi kolon üzerinden arama yapılacağı (SQL komutunu stringleştirmek için "=?" kısmı ) , ve aranacak ad
         * int kontrol denilmesinin sebebi eğer silme bulup görevliyi silerse sistem kontor değişkenine 1 doğru çalışmadı ise bulamadıysa 0 değeri atar.
         */
        int kontrol = db.delete("gorevli", "isim" + "=?", new String[]{gorevli_ad});

        //Kontrol değişkeninin içine işlemin işleyişi ile atanan değere göre işlemin yapılıp yapılamadığı alerti kullanıcıya sağlanır.
        if (kontrol == 1) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("İşlem Bilgisi ");
            alert.setMessage("Görevli Başarı İle Silindi.");
            alert.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            alert.show();
        }else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("İşlem Bilgisi ");
            alert.setMessage("Görevli Silme İşlemi Kaydın Mevcut Olmadığı İçin  Gerçekleştirilememektedir.");
            alert.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            alert.show();

        }
    }
}