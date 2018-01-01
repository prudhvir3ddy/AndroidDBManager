package com.example.root.nfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CRUDActivity extends AppCompatActivity {
Button create,read,update,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
        create=(Button)findViewById(R.id.button_create);
        read=(Button)findViewById(R.id.button_read);
        update=(Button)findViewById(R.id.button_update);
        delete=(Button)findViewById(R.id.button_delete);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CRUDActivity.this,CreateActivity.class));
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CRUDActivity.this,ReadActivity.class));
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CRUDActivity.this,UpdateActivity.class));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CRUDActivity.this,DeleteActivity.class));
            }
        });
    }

}
