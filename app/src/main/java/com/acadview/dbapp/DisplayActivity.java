package com.acadview.dbapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DisplayActivity extends AppCompatActivity {
        EditText email,pwd;
        DBClass dbClass;
        Button login,reset,register;
        Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        email=findViewById(R.id.editText);
        pwd=findViewById(R.id.editText2);


        login= findViewById(R.id.button);
        reset=findViewById(R.id.button2);
        register=findViewById(R.id.register);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setText(" ");
                pwd.setText(" ");
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        dbClass=new DBClass(getApplicationContext());
        cursor= dbClass.getData();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(cursor.moveToFirst()){
                    do{

                        String name = cursor.getString(cursor.getColumnIndex("Name"));
                        String password=cursor.getString(cursor.getColumnIndex("Password"));
                        String type=cursor.getString(cursor.getColumnIndex("Type"));
                        Log.d("TEST","inside do while");

                        if (name.equalsIgnoreCase(email.getText().toString()) && password.equals(pwd.getText().toString())){
                            Log.d("TEST","inside first if");
                            if(type.equalsIgnoreCase("admin")){
                                Intent intent = new Intent(DisplayActivity.this,AdminActivity.class);
                                startActivity(intent);

                            }else if(type.equalsIgnoreCase("student")){
                                Intent intent = new Intent(DisplayActivity.this, StudentActivity.class);
                                startActivity(intent);

                            }
                        }

                    }while(cursor.moveToNext());
                }

            }
        });





    }
}
