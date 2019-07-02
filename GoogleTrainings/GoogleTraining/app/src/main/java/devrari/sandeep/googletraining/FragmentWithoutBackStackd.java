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

public class FragmentWithoutBackStackd extends AppCompatActivity {

    private ToggleButton tb;
    private TextView tv;
    private FragmentManager fm;
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_without_back_stackd);
        tb=findViewById(R.id.noBackStackToggleButton);
        tv=findViewById(R.id.noBackStackTextView1);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    addFragment();
                }
            }
        });
        final TextView tt=findViewById(R.id.noBackStackTextView1);
        tt.setText("0");

        fm=getSupportFragmentManager();

        fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                tt.setText(""+fm.getBackStackEntryCount());

                StringBuilder str=new StringBuilder("Current: "+fm.getBackStackEntryCount()+"\n");

                for(int i=fm.getBackStackEntryCount()-1;i>=0;i--){
                    FragmentManager.BackStackEntry entry=fm.getBackStackEntryAt(i);
                    str.append(entry+"\n");
                }
                Log.i("No Back-Stack",str.toString());
            }
        });
    }

    private void addFragment() {
        ft=fm.beginTransaction();
        Fragment fragment=fm.findFragmentById(R.id.noBackStackFragmentArea);
        if(fragment instanceof Fragment_Layout_1){
            fragment=new Fragment_Layout_2();
        }
        else if(fragment instanceof Fragment_Layout_2){
            fragment=new Fragment_Layout_3();
        }
        else if(fragment instanceof Fragment_Layout_3){
            fragment=new Fragment_Layout_1();
            //Toast.makeText(this, "NO More left!!!", Toast.LENGTH_SHORT).show();
        }
        else{
            fragment=new Fragment_Layout_1();
        }
        if(fragment!=null){
        ft.replace(R.id.noBackStackFragmentArea,fragment,"No Back Stack");//add
        ft.addToBackStack("Replace" +fragment.toString());
        ft.commit();}
    }

    @Override
    public void onBackPressed() {
        Fragment fragment=fm.findFragmentById(R.id.noBackStackFragmentArea);
        if(fragment!=null){
            ft=fm.beginTransaction();
            ft.remove(fragment);
            ft.addToBackStack("remove" +fragment.toString());
            ft.commit();
        }
        else{
            super.onBackPressed();
        }
    }
}
