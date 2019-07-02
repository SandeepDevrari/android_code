package com.example.angry.trainer;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityIntents extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private int textCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);
        ui_init();
        ui_flow();
        if(savedInstanceState!=null){
            textCount=savedInstanceState.getInt("count");
            textView.setText(textCount+"");
        }

    }

    private void ui_flow() {
        textView.setOnClickListener(this);
        findViewById(R.id.config_change_activity_button).setOnClickListener(this);
    }

    private void ui_init() {
        textView=findViewById(R.id.config_change_text);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.config_change_text:{
                textView.setText(""+(textCount++));
                break;
            }
            case R.id.config_change_activity_button:{
                Intent intent=new Intent(ActivityIntents.this,ActivityExplicitIntent.class);
                startActivity(intent);
                break;
            }
        }
    }

    public void change_activity(View view) {
        Intent intent=new Intent(ActivityIntents.this,ActivityExplicitIntent.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",textCount);
    }
}
