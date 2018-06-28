package com.acadview.dbapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DELETE extends AppCompatActivity {
    Button delete;
    EditText name;
    DBClass dbClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        name=findViewById(R.id.editText4);
        delete=findViewById(R.id.button6);
        dbClass=new DBClass(getApplicationContext());

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_string=name.getText().toString();

                dbClass.onDelete(name_string);
                Toast toast=Toast.makeText(getApplicationContext(),"Details have been deleted !",Toast.LENGTH_SHORT);
                toast.show();

            }
        });
    }
}
