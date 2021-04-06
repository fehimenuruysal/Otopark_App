package com.example.msi.otopark.Activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.msi.otopark.R;

public class gorevliGirisActivity extends AppCompatActivity {


    public veritabani gorevliler;

    private TextView ad;
    private TextView parola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorevli_giris);
        gorevliler = new veritabani(this); //Varolan veritabanındaki static tanımlanan veritabanını this ile bu aktivitede oluşturup kullanmayı sağlar.

        /*
         * Sistem açıldığında müşteriler görevli giriş sayfasına gelip kayıt oluşturmaması diye
         * görevli ekleme ve silme işlemleri gorevlinin işlemleri arasında yer alıyor .
         * Bu sebepten sistemi kullanacak olan otopark sahibine root bir kullanıcı sistem ilk açıldığında oluşturulur.
         * Sonradan silinebilinir. Amaç ilk girişi sağlamak ve müsterinin gorevli gibi kayıt oluşturmasını engellemektir.
         */
        KayitEkle("BSAT" , "BSAT123");

    }


    // Bu fonksiyon ile ad ve parola kontrolleri ile gorevlinin yetkinlerinin olduğu aktiviteye geçişi sağlanır.
    public void bilgiKontrol(View view) {
        SQLiteDatabase db = gorevliler.getReadableDatabase(); // Görevlilerin ad ve parolaları tutulan veritabanı okumaa modunda açılır.
        ad =(TextView)findViewById(R.id.ad); // Girilen görevli adını alır ve ad değişkenine textview cevrimi ile atar.
        String gorevli_ad = ad.getText().toString(); // Veriyi kullanım kolaylığı için stringe çevirir.
        parola = (TextView)findViewById(R.id.parola); // Girilen görevli parolasını alır ve parola değişkenine textview cevrimi ile atar.
        String sifre = parola.getText().toString();  // Veriyi kullanım kolaylığı için stringe çevirir.
        int kontrol = 0 ; // giriş işleminin sonucu hakkında bilgi sağlayan değişkendir.

        //Cursor nesnesi c pointer görevi görür. rawQuery ile sorgu yapılır eğer stringe dönüştürülen ad veritabanında varsa eşleştiği kayıt kolonları getirilir.

        Cursor c = db.rawQuery("SELECT isim,parola FROM gorevli WHERE isim like '"+gorevli_ad+"'", null);
        if(c!=null){ // Eşleşen kayıt varsa
            if(c.moveToFirst()){
                do{
                    String ad = c.getString((c.getColumnIndex("isim"))); //Kaydın isim kolonundaki değerini getirir ve atar .
                    String parola = c.getString(c.getColumnIndex("parola")); //Kaydın parola kolonundaki değerini getirir ve atar.
                    if(gorevli_ad.equals(ad) && (sifre.equals(parola))){ //Eğer girilen değerler kayıt kolonları ile eşleşiyorsa
                        //Intent classından bagla nesnesi oluşturarak butona basıldığında GorevliActivity ekranımıza geçişi sağlarız.
                        Intent bagla = new Intent(getApplicationContext(),KullaniciGiris.class);
                        //Sonrada baglamayı başlatmak için alt satırdaki komut kullanılır
                        startActivity(bagla);
                        kontrol = 1 ; // İsim ve parola eşleşti olarak işlem kontrol flagi 1 yapılır.
                        break;
                    }else{ //Girilen ada ait bir isim degeri var ama parola hatalı ise alert verir.
                        AlertDialog.Builder alert = new AlertDialog.Builder(this);
                        alert.setTitle("HATA");
                        alert.setMessage("Görevli adını veya parolayı kontrol edip tekrar deneyiniz!");
                        alert.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        alert.show();
                        kontrol =1 ;
                        break;
                    }
                }while(c.moveToNext());

            }
        }

        if(kontrol == 0) { //Flag set edilmemiş ve ilk koşulda sağlanmamışsa kayıt yok demektir. Uygun alert verilir.
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("HATA");
            alert.setMessage("Görevli Mevcut Değil !");
            alert.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alert.show();
        }
    }

    /**
     * Değerleri ContentValues nesnesine aktarır ve SQLite ekle komutu olan insertOrThrow fonksiyonunu kullanır.
     * Parametre olarak autoincrement id hariç kalan kolonlar için isim , parola bilgilerini alır.
     */
    public void KayitEkle(String isim, String parola){
        SQLiteDatabase db = gorevliler.getWritableDatabase();
        ContentValues veriler = new ContentValues();
        veriler.put("isim", isim);
        veriler.put("parola",parola);
        db.insertOrThrow("gorevli", null, veriler);

    }


}