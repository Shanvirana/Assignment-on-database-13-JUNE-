package com.acadview.dbapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SHOW extends AppCompatActivity {
    TextView show;
    DBClass dbClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        show=findViewById(R.id.textView2);

        dbClass=new DBClass(getApplicationContext());

       Cursor cursor= dbClass.getData();

       if(cursor.moveToFirst()){
           do{


                String name = cursor.getString(cursor.getColumnIndex("Name"));
                String password=cursor.getString(cursor.getColumnIndex("Password"));
               String number=cursor.getString(cursor.getColumnIndex("Number"));

               show.setText(show.getText()+"NAME :"+name+" PASSWORD :"+password+" NUMBER :"+number+"\n");

           }while(cursor.moveToNext());
       }

    }
}
