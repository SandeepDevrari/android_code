package devrari.sandeep.googletraining;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmnetActivityTemp extends AppCompatActivity {

    FragmentManager FM;
    FragmentTransaction FT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmnet_temp);
        Button bt1=findViewById(R.id.tempFragmentBT1);
        Button bt2=findViewById(R.id.tempFragmentBT2);
        Button bt3=findViewById(R.id.tempFragmentBT3);
        FM=getSupportFragmentManager();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FT=FM.beginTransaction();
                Fragment_Layout_1 layout_1=new Fragment_Layout_1();
                FT.add(R.id.tempFrameForFragment,layout_1);
                FT.addToBackStack("One");
                FT.commit();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FT=FM.beginTransaction();
                Fragment_Layout_2 layout_2=new Fragment_Layout_2();
                FT.add(R.id.tempFrameForFragment,layout_2);
                FT.addToBackStack("Two");
                FT.commit();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FT=FM.beginTransaction();
                Fragment_Layout_3 layout_3=new Fragment_Layout_3();
                FT.add(R.id.tempFrameForFragment,layout_3);
                FT.addToBackStack("Three");
                FT.commit();
            }
        });
    }
}
