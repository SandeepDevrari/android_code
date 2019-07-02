package com.example.angry.pm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtherLocations extends AppCompatActivity {

    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_locations);
        bt1=(Button)findViewById(R.id.search);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(OtherLocations.this,OtherLocations.class);
                startActivity(intt);
            }
        });
    }
}
