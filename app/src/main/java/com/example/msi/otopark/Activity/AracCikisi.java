package com.example.msi.otopark.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.msi.otopark.R;

public class AracCikisi extends AppCompatActivity {
    EditText plaka,cikissaati;
    Button cikisonayla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_cikisi);

        cikisonayla =(Button) findViewById(R.id.cikisonayla);
        plaka=(EditText)findViewById(R.id.plaka);
        cikissaati=(EditText)findViewById(R.id.cikissaati);


        cikisonayla.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(getApplicationContext(),AracCikisi.class);
                startActivity(intent);
            }
        });
    }
}
