package devrari.sandeep.angry.rvtrain;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Angry on 4/17/2018.
 */

public class TablayoutWithPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private int numberOfTabs;
    public TablayoutWithPagerAdapter(Context context,FragmentManager fm,int numberOfTabs) {
        super(fm);
        this.context=context;
        this.numberOfTabs=numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
            {
                return new OneFragment();
            }
            case 1:
            {
                return new TwoFragment();
            }
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
