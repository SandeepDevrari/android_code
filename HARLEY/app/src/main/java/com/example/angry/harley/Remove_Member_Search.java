package com.example.angry.harley;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Remove_Member_Search extends AppCompatActivity {

    EditText et12;
    ImageButton im1;
    SQLiteDatabase db;
    String qry;
    public void Connect_Database()
    {
        try {
            db = openOrCreateDatabase("HarleyDb", MODE_PRIVATE, null);
            System.out.println("***************"+db+"******************");
            qry = "create table if not exists harleyTable(VehNo varchar primary key,OwnNm varchar not null,YrMfr varchar not null,VehPic varchar not null)";
            db.execSQL(qry);
            Toast.makeText(Remove_Member_Search.this, "Connected Database", Toast.LENGTH_LONG).show();

        } catch (Exception ex) {
            System.out.println("***************"+ex.getMessage()+"******************");
            ex.printStackTrace();
        }
    }
    public Cursor fetchDetailes_Vehicle(String vehicle)
    {
        Cursor result=null;
        try
        {
            qry="select YrMfr,OwnNm from harleyTable where VehNo='"+vehicle+"'";
            System.out.println(qry+"%%%%%%%%%%%%%%%");
            result=db.rawQuery(qry, null);
            result.moveToFirst();
            System.out.println("***************Data Selected Veh no******************");
            System.out.println("total row count  " + result.getCount());
            System.out.println("total col  " + result.getColumnCount());
            System.out.println("col names  " + result.getColumnNames());
        }
        catch(Exception e)
        {
            System.out.println(e.getCause());
            e.printStackTrace();

        }
        return(result);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove__member__search);
        et12=(EditText)findViewById(R.id.editText12);
        im1=(ImageButton)findViewById(R.id.imageButton1);
        Connect_Database();
    }
    public void fetch_Vehicle_Details(View v)
    {
        Cursor c=fetchDetailes_Vehicle(et12.getText().toString());
        if(c!=null && c.moveToFirst()) {
            Intent intt = new Intent(Remove_Member_Search.this, Remove_Member.class);
            intt.putExtra("vehicleNo",et12.getText().toString());
            intt.putExtra("vehicleYear", c.getString(0));
            intt.putExtra("vehicleName", c.getString(1));
            System.out.println("%%%%%%%ShareData%%%%%%%%");
            startActivity(intt);
        }
    }
}
