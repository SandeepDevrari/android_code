package devrari.sandeep.googletraining;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

public class HW_Constrate_Anim extends AppCompatActivity {

    ConstraintSet set1=new ConstraintSet();
    ConstraintSet set2=new ConstraintSet();
    boolean set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw__constrate__anim);
        final ConstraintLayout root=(ConstraintLayout) findViewById(R.id.orignalBeauty);
        set2.clone(this,R.layout.activity_hw__constrate__anim2);
        set1.clone(root);
        set=false;

        ImageView startAnim=findViewById(R.id.beautyClick);
        startAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition(root);
                ConstraintSet cons = set ? set1 : set2;
                cons.applyTo(root);
                set=!set;
            }
        });
    }
}