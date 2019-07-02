package com.example.angry.harley;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Android_Database_Harley extends AppCompatActivity {

    //SQLiteDatabase db;
    Button b1,b2,b3,b4,b5;
    public boolean Connect_Database()
    {
        SQLiteDatabase db;
        try {
            db = openOrCreateDatabase("HarleyDb", MODE_PRIVATE, null);
            System.out.println("***************"+db+"******************");
            String qry = "create table if not exists harleyTable(VehNo varchar primary key,OwnNm varchar not null,YrMfr varchar not null,VehPic varchar not null)";
            db.execSQL(qry);
            Toast.makeText(Android_Database_Harley.this,"Connected Database" ,Toast.LENGTH_LONG).show();

        } catch (Exception ex) {
            System.out.println("***************"+ex.getMessage()+"******************");
            ex.printStackTrace();
        }
        return(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android__database__harley);
        b1=(Button)findViewById(R.id.button6);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        //ConnectMe con=new ConnectMe();
        //boolean re=con.Connect_Database();
        //Toast.makeText(Android_Database_Harley.this,"Connected:" ,Toast.LENGTH_LONG).show();
        boolean re=Connect_Database();
    }

    public void addMember(View v) {
        Intent intt1=new Intent(Android_Database_Harley.this,Add_Harley.class);
        startActivity(intt1);
    }

    public void refreshMemberData(View v)
    {
        Intent intt=new Intent(Android_Database_Harley.this,Refresh_Member_Data.class);
        startActivity(intt);
    }

    public void removeMember(View v)
    {
        Intent intt=new Intent(Android_Database_Harley.this,Remove_Member_Search.class);
        startActivity(intt);
    }

    public void searchMember(View v)
    {
        Intent intt=new Intent(Android_Database_Harley.this,Add_Harley.class);
        startActivity(intt);
    }

    public void quitAll(View v)
    {
        System.exit(0);
    }
}
