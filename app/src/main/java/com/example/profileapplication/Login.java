package com.example.profileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity  {
    Button btnlogin,btnsignUP;
    String email,pass;
    EditText editTextEmail, editTextPass ;
    SQLiteDatabase db;
    Cursor  cursor;
    int status;
    String fname,lname,phone,loc,emailid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail = findViewById(R.id.edEmailIDPerson);
        editTextPass = findViewById(R.id.edPassword);
        btnlogin=findViewById(R.id.button1);
        btnsignUP=findViewById(R.id.button2);


        db=openOrCreateDatabase("mydb", Context.MODE_PRIVATE,null);

    }





    private  void showMessage(String title, String input) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(input);
        builder.setIcon(R.mipmap.myicon_round);
        builder.setCancelable(true);
        builder.show();}

    private void clearText() {
        editTextEmail.setText("");
        editTextPass.setText("");
    }

    public void register(View view) {
        Intent intent_my = new Intent(Login.this,MainActivity.class);
        startActivity(intent_my);
    }

    public void loginuser(View view) {
        email = editTextEmail.getText().toString().trim();
        pass = editTextPass.getText().toString().trim();
        if (email.isEmpty() || pass.isEmpty()) {
            cursor=db.rawQuery("SELECT * FROM mydb_test WHERE useremail='" +email+ "' AND userpassward='" +pass+"'",null);
        }
        if (cursor.moveToFirst()){
            status=1;
            fname=cursor.getString(0);
            lname=cursor.getString(1);
            emailid=cursor.getString(2);
            phone=cursor.getString(3);
            loc=cursor.getString(4);
            Intent intent_my = new Intent(Login.this,ProfileActivity.class);
            startActivity(intent_my);
            clearText();
        }
        else {
            showMessage("error","Invalid Login");
            clearText();
        }

    }
}


