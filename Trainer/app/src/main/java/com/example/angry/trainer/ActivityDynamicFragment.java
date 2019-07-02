package com.example.angry.trainer;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityDynamicFragment extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        findViewById(R.id.addFragment).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.dynamicFragment,new Fragment_Dynamic());
        fragmentTransaction.addToBackStack("ABC");
        fragmentTransaction.commit();
    }
}
