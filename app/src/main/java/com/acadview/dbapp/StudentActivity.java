package com.acadview.dbapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentActivity extends AppCompatActivity {
    TextView textView;
    DBClass dbClass;
    Button show,edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        textView=findViewById(R.id.textView6);

        dbClass=new DBClass(getApplicationContext());
        show=findViewById(R.id.button3);
        edit=findViewById(R.id.button4);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor= dbClass.getData();

                if(cursor.moveToFirst()){
                    do{


                        String name = cursor.getString(cursor.getColumnIndex("Name"));
                        String password=cursor.getString(cursor.getColumnIndex("Password"));
                        String number=cursor.getString(cursor.getColumnIndex("Number"));

                        textView.setText("Welcome Student\n"+"Email id :"+name+" PASSWORD :"+password+" NUMBER :"+number+"\n");

                    }while(cursor.moveToNext());
                }
            }
        });

       edit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(StudentActivity.this,Update.class);
               startActivity(intent);
           }
       });
    }
}
