package com.example.angry.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnimInAndroHome extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_in_andro_home);
        bt1=(Button)findViewById(R.id.FadeInButton);
        bt2=(Button)findViewById(R.id.FAdeOutButton);
        bt3=(Button)findViewById(R.id.ZoomButton);
        bt4=(Button)findViewById(R.id.FlyButton);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(AnimInAndroHome.this,FadeIn.class);
                intt.putExtra("ButtonValue",bt1.getText().toString());
                startActivity(intt);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(AnimInAndroHome.this,AnimInAndroHome.class);
                intt.putExtra("ButtonValue",bt2.getText().toString());
                startActivity(intt);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(AnimInAndroHome.this,AnimShow.class);
                intt.putExtra("ButtonValue",bt3.getText().toString());
                startActivity(intt);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(AnimInAndroHome.this,AnimInAndroHome.class);
                intt.putExtra("ButtonValue",bt4.getText().toString());
                startActivity(intt);
            }
        });
    }
}
