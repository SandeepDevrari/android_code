package devrari.sandeep.angry.rvtrain;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CallFragmentActivity extends AppCompatActivity implements CallToInterface {

    private FragmentManager FM;
    private FragmentTransaction FT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_fragment);
        FM=getSupportFragmentManager();
        FT=FM.beginTransaction();
        OneFragment one=new OneFragment();
        one.setFragment(this);
        FT.add(R.id.fragmentArea,one);
        FT.commit();
    }

    @Override
    public void callToInterface() {
        FT=FM.beginTransaction();
        TwoFragment two=new TwoFragment();
        FT.add(R.id.fragmentArea,two);
        FT.commit();
    }
}
