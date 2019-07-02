package devrari.sandeep.angry.rvtrain;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityTabLayoutWithPager extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_with_pager);
        tabLayout=findViewById(R.id.tablayout_TabLayout);
        viewPager=findViewById(R.id.tablayout_ViewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Tab One"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab Two"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        TablayoutWithPagerAdapter tablayoutWithPagerAdapter=new TablayoutWithPagerAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(tablayoutWithPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
