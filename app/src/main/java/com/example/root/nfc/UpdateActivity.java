package com.example.root.nfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
EditText u1,u2,u3,u4,u5,u6;
   Button update,cancel;
    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        u1=(EditText)findViewById(R.id.u1);
        u2=(EditText)findViewById(R.id.u2);
        u3=(EditText)findViewById(R.id.u3);
        u4=(EditText)findViewById(R.id.u4);
        u5=(EditText)findViewById(R.id.u5);
        u6=(EditText)findViewById(R.id.u6);
        update=(Button)findViewById(R.id.btn_update);
        cancel=(Button)findViewById(R.id.button_cancel);
        db=new DbHelper(this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String g1=u1.getText().toString();
                String g2=u2.getText().toString();
                String g3=u3.getText().toString();
                String g4=u4.getText().toString();
                String g5=u5.getText().toString();
                String g6=u6.getText().toString();
              int count = db.update(new NFC(g2,g3,g4,g5,g6,g1));
if(count==1)
{
    Toast.makeText(UpdateActivity.this,"done",Toast.LENGTH_SHORT).show();
}
db.update(new NFC("bike","11","221099","suzuki","africa","7"));
            }
        });
        }
}
