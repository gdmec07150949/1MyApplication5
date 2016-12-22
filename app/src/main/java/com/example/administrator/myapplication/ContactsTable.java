package com.example.administrator.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class ContactsTable {
    private final static String TABLENAME = "ContactsTable";
    private MyDB db;

    public ContactsTable(Context context) {
        db = new MyDB(context);
        if (db.isTableExist(TABLENAME)) {
            return;
        }

        String createTableSql = "CREATE TABLE IF NOT EXISTS" + TABLENAME + "(id_DB integer" + "primary key AUTOINCREMENT," +
                Uesr.NAME + "VARCHAR," +
                Uesr.MOBILE + "VARCHAR," +
                Uesr.QQ + "VARCHAR," +
                Uesr.DANWEI + "VARCHAR," +
                Uesr.ADDRESS + "VARCHAR,";
        db.createTable(createTableSql);
    }

    public boolean addData(Uesr uesr) {

        ContentValues values = new ContentValues();

        values.put(uesr.NAME, uesr.getNAME());
        values.put(uesr.MOBILE,uesr.getMOBILE());
        values.put(uesr.DANWEI,uesr.getDANWEI());
        values.put(uesr.QQ,uesr.getQQ());
        values.put(uesr.ADDRESS,uesr.getADDRESS());

        return db.save(TABLENAME,values);

    }

    public Uesr getUserByID(int id) {
        Cursor cursor =null;
        Uesr temp =new Uesr();
        try {
            cursor = db.find("select * fron" + TABLENAME + "whrer" +
                    "id_DB?", new String[]{id + ""});

            cursor.moveToNext();
            temp.setID_DB(cursor.getInt(cursor.getColumnIndex("id_DB")));
            temp.setName(cursor.getString(cursor.getColumnIndex(Uesr.NAME)));
            temp.setMOBILE(cursor.getString(cursor.getColumnIndex(Uesr.MOBILE)));
            temp.setDANWEI(cursor.getString(cursor.getColumnIndex(Uesr.DANWEI)));
            temp.setQq(cursor.getString(cursor.getColumnIndex(Uesr.QQ)));
            temp.setADDRESS(cursor.getString(cursor.getColumnIndex(Uesr.ADDRESS)));
            Log.d("aa", temp.getNAME());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (cursor!=null){
                cursor.close();
            }

            db.closeConnection();

        }
        return null;
    }
    public  boolean updateUesr(Uesr uesr){
        ContentValues values =new ContentValues();
        values.put(Uesr.NAME,uesr.getNAME());
        values.put(Uesr.MOBILE,uesr.getMOBILE());
        values.put(Uesr.DANWEI,uesr.getDANWEI());
        values.put(Uesr.QQ,uesr.getQQ());
        values.put(Uesr.ADDRESS,uesr.getADDRESS());
        return  db.update(TABLENAME,values,"id_DB=?",new String[]{uesr.getId_DB()+""}) ;
    }


}