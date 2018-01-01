package com.example.root.nfc;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.steamcrafted.loadtoast.LoadToast;

public class SecondActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button=(Button)findViewById(R.id.scan_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(new Intent(SecondActivity.this,CRUDActivity.class)));
                Toast.makeText(SecondActivity.this,"NFC Device Found",Toast.LENGTH_SHORT).show();
               }
        });
    }
}
