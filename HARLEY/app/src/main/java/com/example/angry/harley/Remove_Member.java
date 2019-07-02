package com.example.angry.harley;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Remove_Member extends AppCompatActivity {

    EditText et10,et11,et12;
    Button bt8;
    String vehicleNo,vehicleYear,vehicleName;
    SQLiteDatabase db;
    String qry;
    public void Connect_Database()
    {
        try {
            db = openOrCreateDatabase("HarleyDb", MODE_PRIVATE, null);
            System.out.println("***************"+db+"******************");
            qry = "create table if not exists harleyTable(VehNo varchar primary key,OwnNm varchar not null,YrMfr varchar not null,VehPic varchar not null)";
            db.execSQL(qry);
            Toast.makeText(Remove_Member.this, "Connected Database", Toast.LENGTH_LONG).show();

        } catch (Exception ex) {
            System.out.println("***************"+ex.getMessage()+"******************");
            ex.printStackTrace();
        }
    }
    public void delete_Vehicle(String vehicle)
    {
        try
        {
            qry="delete from harleyTable where VehNo='"+vehicle+"'";
            db.execSQL(qry);
            System.out.println("*********DATA DELETED***********");
        }
        catch(Exception e)
        {
            System.out.println(e.getCause());
            e.printStackTrace();

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove__member);
        bt8=(Button)findViewById(R.id.button8);
        et10=(EditText)findViewById(R.id.editText10);
        et11=(EditText)findViewById(R.id.editText11);
        et12=(EditText)findViewById(R.id.editText12);
        Intent intt=getIntent();
        vehicleNo=intt.getStringExtra("vehicleNo");
        vehicleYear=intt.getStringExtra("vehicleYear");
        vehicleName=intt.getStringExtra("vehicleName");
        et12.setText(vehicleNo);
        et10.setText(vehicleName);
        et11.setText(vehicleYear);
        Connect_Database();
    }

    public void delete_Button(View v)
    {
        delete_Vehicle(vehicleNo);
        Intent intt=new Intent(Remove_Member.this,Android_Database_Harley.class);
        startActivity(intt);
    }
}
