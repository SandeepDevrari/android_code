package com.example.angry.pm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CapchaAct extends AppCompatActivity {

    RadioGroup rgb1;
    RadioButton rb1;
    ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capcha);
        iv1=(ImageView)findViewById(R.id.CaptchaIm);
        rgb1=(RadioGroup)findViewById(R.id.CaptchaRG);
        rb1=(RadioButton)findViewById(R.id.imNotRobot);
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                TextCaptcha tc=new TextCaptcha(300,400);
                iv1.setImageBitmap(tc.getImage());
            }
        });
    }
}
