package com.example.root.nfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity {
DbHelper db;
    ArrayList<NFC> nfcList;
    Adapter adapter;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        db=new DbHelper(this);
        nfcList=new ArrayList<>();
        lv=(ListView)findViewById(R.id.lv);
        nfcList= db.get();
adapter=new Adapter(getApplicationContext(),nfcList);
        lv.setAdapter(adapter);

    }


}
