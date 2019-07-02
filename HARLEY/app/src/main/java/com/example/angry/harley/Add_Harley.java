package com.example.angry.harley;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Harley extends AppCompatActivity {
    Button b1;
    EditText et1,et2,et4,et5;
    boolean re;
    String qry;
    SQLiteDatabase db;
    public boolean Connect_Database()
    {
        try {
            db = openOrCreateDatabase("HarleyDb", MODE_PRIVATE, null);
            System.out.println("***************"+db+"******************");
            qry = "create table if not exists harleyTable(VehNo varchar primary key,OwnNm varchar not null,YrMfr varchar not null,VehPic varchar not null)";
            db.execSQL(qry);
            Toast.makeText(Add_Harley.this,"Connected Database" ,Toast.LENGTH_LONG).show();

        } catch (Exception ex) {
            System.out.println("***************"+ex.getMessage()+"******************");
            ex.printStackTrace();
        }
        return(true);
    }
    public boolean insert_Data(String et1,String et2,String et4,String et5)
    {
        try {
            qry = "Insert into harleyTable values('"+et2+"','"+et1+"','"+et4+"','"+et5+"')";
            //System.out.println("***************"+db+"******************");
            System.out.println(qry);
            db.execSQL(qry);
            System.out.println("***************Data Inserted******************");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //System.out.println(et1+" DATA is here "+et2+" "+et4+" "+et5);
        return (true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__harley);
        b1=(Button)findViewById(R.id.button6);
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        et4=(EditText)findViewById(R.id.editText4);
        et5=(EditText)findViewById(R.id.editText5);
        //connectMe=new ConnectMe();
        //re=connectMe.Connect_Database();
        //Toast.makeText(Add_Harley.this,"Connected:"+re,Toast.LENGTH_LONG).show();
        re=Connect_Database();
    }

    public void save_Harley(View v) {
        re = insert_Data(et1.getText().toString(), et2.getText().toString(),et4.getText().toString(),et5.getText().toString());
        Toast.makeText(Add_Harley.this,"Inserted:"+re,Toast.LENGTH_LONG).show();
        //System.out.println(et1.getText().toString()+" DATA "+et2.getText().toString()+" "+et4.getText().toString()+" "+et5.getText().toString());
        Intent intt=new Intent(Add_Harley.this,Android_Database_Harley.class);
        startActivity(intt);
    }
}
