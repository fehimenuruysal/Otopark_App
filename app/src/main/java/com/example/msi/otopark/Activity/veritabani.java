package com.example.msi.otopark.Activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//Bu class sistemin gömülü olan veritabanı ile kullanıcı arasında arayüz gibi bir katman görevi görür.

public class veritabani extends SQLiteOpenHelper {

    /* VERITABANI değişkeni ;
     *   Görevli id , ad , parolalarını tutan veri tabanının adını tutan final değişken
     *   Static ve final olama sebebi sistem süresince hiç bir noktadan değiştirilmemeli ve diğer aktivite classlardanda işlem yapılabilmeli .
     */
    private static final String VERITABANI = "gorevliler.db";

    /* SURUM değişkeni ;
     *  Veritabanı ile ilgili güncelleme geldiğinde mevcut versiyonu bizim için tutar.
     */
    private static int SURUM = 1;

    //Constructor
    public veritabani (Context con){
        super(con,VERITABANI ,null,SURUM);
    }

    //Genelde veritabanı oluşturulur. Burada yapılacak olan işlemler bir defalığına yapılır.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE gorevli (id INTEGER PRIMARY KEY AUTOINCREMENT,isim TEXT,parola TEXT);");
    }

    //Güncelleme gelince veritabani silinip güncel hali yüklenecektir.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE If EXISTS gorevli");
        onCreate(db);
    }
}
