package devrari.sandeep.googletraining;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SwapNavigationActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap_navigation);

        tab=findViewById(R.id.swipTab);
        pager=findViewById(R.id.swipViewpager);
        pager.setAdapter(new SwipeAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(pager);

    }

    private class SwipeAdapter extends FragmentPagerAdapter {

        private String[] str={"One","Two","Three"};
        public SwipeAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            switch(position){
                case 0:
                    fragment=new FragmentSwip_1();
                    break;
                case 1:
                    fragment=new FragmentSwip_2();
                    break;
                case 2:
                    fragment=new FragmentSwip_3();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return str.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return str[position];
        }
    }
}
