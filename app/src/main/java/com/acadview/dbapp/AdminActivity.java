package com.acadview.dbapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    TextView show;
    DBClass dbClass;
    ArrayList<String> record;
    ListView listView;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        record = new ArrayList<String>();
        listView=findViewById(R.id.list);

        show=findViewById(R.id.text);
        dbClass=new DBClass(getApplicationContext());
        cursor= dbClass.getData();


        if(cursor.moveToFirst()){
            do{

                String name = cursor.getString(cursor.getColumnIndex("Name"));
                String password=cursor.getString(cursor.getColumnIndex("Password"));
                String number=cursor.getString(cursor.getColumnIndex("Number"));
                String type=cursor.getString(cursor.getColumnIndex("Type"));

                if(type.equalsIgnoreCase("student")){
                    record.add("name = "+name+" password = "+password+" number = "+number);
                }


            }while(cursor.moveToNext());
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(AdminActivity.this,android.R.layout.simple_list_item_1,record);
        listView.setAdapter(arrayAdapter);


    }
}
