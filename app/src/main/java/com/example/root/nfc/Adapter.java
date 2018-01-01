package com.example.root.nfc;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 14/4/17.
 */

public class Adapter extends ArrayAdapter<NFC> {
    ArrayList<NFC> nfcList;
    private DbHelper db;
    private Context context;

    public Adapter(@NonNull Context context, @NonNull ArrayList<NFC> nfcList) {
        super(context,R.layout.row, nfcList);
        db=new DbHelper(context);
        this.nfcList=nfcList;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        if(row==null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row, parent, false);
        }
        TextView tvid=(TextView)row.findViewById(R.id.db_id);
        TextView tvname=(TextView)row.findViewById(R.id.name);
        TextView tvnumber=(TextView)row.findViewById(R.id.number);
        TextView tvdate=(TextView)row.findViewById(R.id.date);
        TextView tvcompany_name=(TextView)row.findViewById(R.id.company_name);
        TextView tvcompany_loc=(TextView)row.findViewById(R.id.company_location);

NFC nfc=nfcList.get(position);
        String db_id=nfc.getId();
        String name=nfc.getName();
        String number=nfc.getNumber();
        String date=nfc.getDate();
        String company_name=nfc.getCompany_name();
        String company_loc=nfc.getCompany_location();
        tvid.setText(db_id);
tvname.setText(name);
        tvnumber.setText(number);
        tvdate.setText(date);
        tvcompany_name.setText(company_name);
        tvcompany_loc.setText(company_loc);
        return row;
    }
}
