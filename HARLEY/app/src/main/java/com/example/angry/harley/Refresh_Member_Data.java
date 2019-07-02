package com.example.angry.harley;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Refresh_Member_Data extends AppCompatActivity {

    String data_arry[];
    Button bt7;
    TextView tv5,tv6,tv7;
    EditText et6,et7,et8;
    Spinner sp1;
    boolean re;
    SQLiteDatabase db;
    String qry;
    public boolean Connect_Database()
    {
        try {
            db = openOrCreateDatabase("HarleyDb", MODE_PRIVATE, null);
            //System.out.println("***************"+db+"******************");
            qry = "create table if not exists harleyTable(VehNo varchar primary key,OwnNm varchar not null,YrMfr varchar not null,VehPic varchar not null)";
            db.execSQL(qry);
            Toast.makeText(Refresh_Member_Data.this,"Connected Database" ,Toast.LENGTH_LONG).show();

        } catch (Exception ex) {
            System.out.println("***************"+ex.getMessage()+"******************");
            ex.printStackTrace();
        }
        return(true);
    }
    public Cursor fetch_Use_pk(String sp1)
    {
        Cursor result=null;
        try
        {
            qry="select OwnNm,YrMfr,VehPic from harleyTable where VehNo='"+sp1+"'";
            result=db.rawQuery(qry, null);
            System.out.println("***************Data Selected******************");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return(result);
    }
    public Cursor fetch_pk()
    {
        Cursor result=null;
        try
        {
            qry="select VehNo from harleyTable";
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
    public boolean update_Data(String et1,String et2,String sp1)
    {
        try {
            qry="update harleyTable set YrMfr='"+et1+"',VehPic='"+et2+"' where VehNo='"+sp1+"'";
            System.out.println(qry);
            db.execSQL(qry);
            System.out.println("***************Data Update******************");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return (true);
    }
    public void delete_AllData()
    {
        try {
            qry="delete from harleyTable";
            db.execSQL(qry);
            System.out.println("***************Data Deleted******************");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh__member__data);
        bt7=(Button)findViewById(R.id.button7);
        tv5=(TextView)findViewById(R.id.textView5);
        tv6=(TextView)findViewById(R.id.textView6);
        tv7=(TextView)findViewById(R.id.textView7);
        et6=(EditText)findViewById(R.id.editText6);
        et7=(EditText)findViewById(R.id.editText7);
        et8=(EditText)findViewById(R.id.editText8);
        sp1=(Spinner)findViewById(R.id.spinner);
        re=Connect_Database();
        Toast.makeText(Refresh_Member_Data.this, "Connected:" + re, Toast.LENGTH_LONG).show();
        Cursor rslt=fetch_pk();
        rslt.moveToFirst();
        data_arry=new String[rslt.getCount()];
        int o=0;`
        System.out.println(rslt.isLast());
        while(o<rslt.getCount()+1)////while(rslt.moveToNext())//!rslt.isLast()
        {

            System.out.println(o++);
            for(int i=0;i<rslt.getColumnCount();i++)
            {
                data_arry[i]=rslt.getString(i);
                System.out.println(data_arry[i]);
            }
            rslt.moveToNext();
            o++;
            System.out.println(rslt.moveToNext());
        }
        System.out.println("Exited Loop."+data_arry.toString());
        try
        {
            for(int j=0;j<data_arry.length;j++)
            {
                System.out.println("===================="+data_arry[j]+"====================");
            }
            ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,data_arry);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //System.out.println(aa.getCount());
            //System.out.println(sp1.toString());
            sp1.setAdapter(aa);
            sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Cursor result=fetch_Use_pk(sp1.getSelectedItem().toString());
                result.moveToFirst();
                et6.setText(result.getString(0));
                et7.setText(result.getString(1));
                et8.setText(result.getString(2));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                e.printStackTrace();
            }
    }
    public void update_Button7(View v)
    {
        re=update_Data(et7.getText().toString(), et8.getText().toString(), sp1.getSelectedItem().toString());
        Toast.makeText(Refresh_Member_Data.this, "Updated" + re, Toast.LENGTH_LONG).show();
        //delete_AllData();
        Intent intt=new Intent(Refresh_Member_Data.this,Android_Database_Harley.class);
        startActivity(intt);
    }

}
