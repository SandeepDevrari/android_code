package com.desk.angry.customtabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class ActivityMain extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ViewPager viewPager =findViewById(R.id.viewpager);
//
//        String[] tabsTitle={"h","k","p"};
//
//        TablayoutWithPagerAdapter tablayoutWithPagerAdapter=new TablayoutWithPagerAdapter(this,getSupportFragmentManager(), 2,tabsTitle);
//        viewPager.setAdapter(tablayoutWithPagerAdapter);
//
//        sTabLayout viewPagerTab =findViewById(R.id.smartTab);
//        viewPagerTab.setViewPager(viewPager);
    }
}
