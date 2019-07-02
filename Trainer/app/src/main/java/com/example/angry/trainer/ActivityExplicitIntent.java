package com.example.angry.trainer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityExplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);
        ui_init();
    }

    private void ui_init() {
        findViewById(R.id.explicit_intent_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8979221199"));
                startActivity(intent2);
            }
        });
    }
}
