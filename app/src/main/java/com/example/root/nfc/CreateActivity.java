package com.example.root.nfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6;
    Button button,button2;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
      db=new DbHelper(this);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
        e6=(EditText)findViewById(R.id.e6);
button=(Button)findViewById(R.id.btn_submit);
        button2=(Button)findViewById(R.id.btn_cancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String  s2= e2.getText().toString();
                String  s3=e3.getText().toString();
                String  s4=e4.getText().toString();
                String s5=e5.getText().toString();
                String  s6=e6.getText().toString();

                db.add(new NFC(s2,s3,s4,s5,s6,s1));
                Toast.makeText(CreateActivity.this,"Data Added",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
    }
}
