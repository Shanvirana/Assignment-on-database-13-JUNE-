package com.acadview.dbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBClass extends SQLiteOpenHelper {
    public DBClass(Context context) {
        super(context, "userdatabase2", null, 12);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE USER (Name text,Password text,Number text,Type text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists USER");
        onCreate(sqLiteDatabase);

    }

    public boolean onUpdate(String name,String newpassword){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String ar[] = {name};

        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Password",newpassword);

        sqLiteDatabase.update("USER",contentValues,"Name=?",ar);

        return true;
    }

    public boolean addData(String name, String password, String number,String type){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Password",password);
        contentValues.put("Number",number);
        contentValues.put("Type",type);

        sqLiteDatabase.insert("USER",null,contentValues);


        return true;

    }

    public boolean onDelete(String name){
        String ar[]={name};
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete("USER","pwd=?",ar);
        return true;

    }

    public Cursor getData(){

        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query("USER" ,null,null,null,null,null,null);




        return cursor;

    }



}
