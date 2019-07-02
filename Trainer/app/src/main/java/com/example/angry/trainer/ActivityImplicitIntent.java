package com.example.angry.trainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityImplicitIntent extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        ui_init();
        ui_flow();
    }

    private void ui_flow() {
        findViewById(R.id.implicit_call).setOnClickListener(this);
    }

    private void ui_init() {
        editText=findViewById(R.id.implicit_intent_editText);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.implicit_call:{
                //
                break;
            }
        }
    }
}
