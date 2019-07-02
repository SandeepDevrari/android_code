package com.example.angry.sampleapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    Button button1;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        button1=(Button)findViewById(R.id.button1);
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
    }
    public void Check_Login(View v)
    {
        String user="sandeepdevrari@gmail.com",code="sandy";
        System.out.println(String.valueOf(et1.getText()));
        System.out.println(String.valueOf(et2.getText()));
        if((String.valueOf(et1.getText())).equals(user) && (String.valueOf(et2.getText()).equals(code))) {
                Toast.makeText(SignIn.this, "Success", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(SignIn.this, "Code Failed", Toast.LENGTH_LONG).show();
            }
       /* }
        else
        {
            Toast.makeText(SignIn.this,"Failed", Toast.LENGTH_LONG).show();
        }*/
    }
}
