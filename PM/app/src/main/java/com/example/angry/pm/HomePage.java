package com.example.angry.pm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        bt1=(Button)findViewById(R.id.currentloc);
        bt2=(Button)findViewById(R.id.otherloc);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(HomePage.this,HomePage.class);
                startActivity(intt);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(HomePage.this,HomePage.class);
                startActivity(intt);
            }
        });
    }
}
