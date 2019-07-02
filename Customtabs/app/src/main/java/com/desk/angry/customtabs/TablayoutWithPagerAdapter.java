package com.desk.angry.customtabs;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Angry on 4/17/2018.
 */

public class TablayoutWithPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private int numberOfTabs;
    private String[] tabsTitle;
    public TablayoutWithPagerAdapter(Context context, FragmentManager fm, int numberOfTabs, String[] tabsTitle) {
        super(fm);
        this.context=context;
        this.numberOfTabs=numberOfTabs;
        this.tabsTitle=tabsTitle;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
            {
                return null;//new Fragment_My_Feed();
            }
            case 1:
            {
                return null;//new Fragment_Trending();
            }
            case 2:
            {
                return null;//new Fragment_All_News();
            }
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabsTitle[position];
    }
}
