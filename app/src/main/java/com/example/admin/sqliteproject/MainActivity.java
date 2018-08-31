package com.example.admin.sqliteproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      DataBaseHelper dataBaseHelper;
      EditText first,last,pass,mail,phones,conpass;
      Button regbtn,logbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseHelper = new DataBaseHelper(this);
        first = (EditText)findViewById(R.id.editText);
        last = (EditText)findViewById(R.id.editText2);
        pass = (EditText)findViewById(R.id.editText3);
        mail = (EditText)findViewById(R.id.editText4);
        phones = (EditText)findViewById(R.id.editText5);
        conpass = (EditText)findViewById(R.id.editText8);
        regbtn = (Button)findViewById(R.id.button);
        logbtn = (Button)findViewById(R.id.button3);
        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mine = new Intent(MainActivity.this,Login.class);
                startActivity(mine);
            }
        });
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = first.getText().toString();
                String lname = last.getText().toString();
                String Pass = pass.getText().toString();
                String Email = mail.getText().toString();
                String Phone = phones.getText().toString();
                if (fname.equals("")||lname.equals("")||Pass.equals("")||Email.equals("")||Phone.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }else {
                    if (conpass.equals(Pass)) {
                        Boolean chkemail = dataBaseHelper.chkemail(Email);
                        if (chkemail == true) {
                            Boolean insert = dataBaseHelper.insert(Email, Pass);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent mine = new Intent(MainActivity.this,Login.class);
                                startActivity(mine);
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Password doesn't match",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
