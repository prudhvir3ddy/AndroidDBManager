package com.example.root.nfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {
EditText editText;
    DbHelper db;
    Button button;
    ArrayList<NFC> nfcList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        editText = (EditText) findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        db=new DbHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String del=editText.getText().toString();
               int count= db.delete(new NFC(del));
                if(count==1) {
                    Toast.makeText(DeleteActivity.this, "deleted row", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
