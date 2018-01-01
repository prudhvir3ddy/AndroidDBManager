package com.example.root.nfc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 13/4/17.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_NFC = "nfc";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_DATE = "date";
    private static final String KEY_COMPANY_NAME = "company_name";
    private static final String KEY_COMPANY_LOCATION = "company_location";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NFC_TABLE = "CREATE TABLE " +  TABLE_NFC  + "(" + KEY_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME
                + " VARCHAR, " + KEY_NUMBER + " VARCHAR, " + KEY_DATE + " VARCHAR, " + KEY_COMPANY_NAME
                + " VARCHAR, " + KEY_COMPANY_LOCATION + " VARCHAR " + ")";
        db.execSQL(CREATE_NFC_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NFC);

        // Create tables again
        onCreate(db);
    }

    public void add(NFC nfc) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID,nfc.getId());
        contentValues.put(KEY_NAME, nfc.getName());
        contentValues.put(KEY_NUMBER, nfc.getNumber());
        contentValues.put(KEY_DATE, nfc.getDate());
        contentValues.put(KEY_COMPANY_NAME, nfc.getCompany_name());
        contentValues.put(KEY_COMPANY_LOCATION, nfc.getCompany_location());
        db.insert(TABLE_NFC, null, contentValues);
        db.close();
    }
    NFC getN(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NFC, new String[] { KEY_ID,
                        KEY_NAME, KEY_NUMBER,KEY_DATE,KEY_COMPANY_NAME,KEY_COMPANY_LOCATION}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        NFC nfc = new NFC((cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));

        return nfc;


    }

    public ArrayList<NFC> get() {
        ArrayList<NFC> nfcList = new ArrayList<NFC>();
        String selectQuery = "SELECT  * FROM " + TABLE_NFC;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                NFC nfc = new NFC();
                nfc.setId(cursor.getString(0));
                nfc.setName(cursor.getString(1));
                nfc.setNumber(cursor.getString(2));
                nfc.setDate(cursor.getString(3));
                nfc.setCompany_name(cursor.getString(4));
                nfc.setCompany_location(cursor.getString(5));
                nfcList.add(nfc);
            } while (cursor.moveToNext());
        }
        return nfcList;
    }
    public int update(NFC nfc){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_NAME, nfc.getName());
        contentValues.put(KEY_NUMBER, nfc.getNumber());
        contentValues.put(KEY_DATE, nfc.getDate());
        contentValues.put(KEY_COMPANY_NAME, nfc.getCompany_name());
        contentValues.put(KEY_COMPANY_LOCATION, nfc.getCompany_location());

        int count=db.update(TABLE_NFC,contentValues,KEY_ID+"=?",new String[]{String.valueOf(nfc.getId())});
        db.close();
        return count;
    }
    public int delete(NFC nfc) {
        SQLiteDatabase db = this.getWritableDatabase();
        int count=db.delete(TABLE_NFC, KEY_ID+ " = ?",
                new String[] { String.valueOf(nfc.getId()) });
        db.close();
        return count;
    }
}