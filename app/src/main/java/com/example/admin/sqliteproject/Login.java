package com.example.admin.sqliteproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
  EditText mail,pass;
  Button lodinbtn;
  SQLiteDatabase sqLiteDatabase;
  SQLiteOpenHelper sqLiteOpenHelper;
Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqLiteOpenHelper = new DataBaseHelper(this);
        sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase();
        mail=(EditText)findViewById(R.id.editText6);
        pass = (EditText)findViewById(R.id.editText7);
        lodinbtn = (Button)findViewById(R.id.button2);
        lodinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String email = mail.getText().toString();
                String password = pass.getText().toString();
              Boolean Chkemailpass = sqLiteOpenHelper.emailpassword(email,password);
              if (Chkemailpass==true)
                  Toast.makeText(getApplicationContext(),"Successfully login",Toast.LENGTH_SHORT);
              else
                  Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT);
            }
        });
    }
}
