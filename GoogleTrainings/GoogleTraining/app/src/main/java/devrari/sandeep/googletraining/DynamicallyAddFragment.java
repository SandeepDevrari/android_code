package devrari.sandeep.googletraining;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class DynamicallyAddFragment extends AppCompatActivity {

    FragmentManager fragmentManagr;
    FragmentTransaction fragmentTrans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamically_add_fragment);

        fragmentManagr=getSupportFragmentManager();

        ToggleButton tb=findViewById(R.id.dynamicToggleButton);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    addFragment();
                }
                else{
                    //
                }
            }
        });

        final TextView tt=findViewById(R.id.dynamicTextView1);
        tt.setText("0");

        fragmentManagr.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                tt.setText(""+fragmentManagr.getBackStackEntryCount());
            }
        });
        //addFragment();
    }
    private void addFragment(){
        //Adding the Fragment Dynamically
        Fragment fragment=null;
        switch(fragmentManagr.getBackStackEntryCount()){
            case 0:
                fragment=new Fragment_Layout_1();
                break;
            case 1:
                fragment=new Fragment_Layout_2();
                break;
            case 2:
                fragment=new Fragment_Layout_3();
                break;
                default:
                    Toast.makeText(this, "No more Fragment left!!!", Toast.LENGTH_SHORT).show();
                    break;
        }
        if(fragment!=null){
            fragmentTrans=fragmentManagr.beginTransaction();    //because it is commit is needed with each fragment
            fragmentTrans.add(R.id.fragmentDynamic,fragment);
            fragmentTrans.addToBackStack("fragments_Stack");
            fragmentTrans.commit();
        }
    }

}
