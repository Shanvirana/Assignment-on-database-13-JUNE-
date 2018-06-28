package com.acadview.dbapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    EditText name,password;
    Button updtae;
    DBClass dbClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name=findViewById(R.id.editText5);
        password=findViewById(R.id.editText6);
        updtae=findViewById(R.id.button7);

        dbClass=new DBClass(getApplicationContext());

        updtae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_string=name.getText().toString();
                String password_string=password.getText().toString();

                dbClass.onUpdate(name_string,password_string);
                Toast toast=Toast.makeText(getApplicationContext(),"Details have been updated !",Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(Update.this,StudentActivity.class);
                startActivity(intent);
            }
        });

    }
}
