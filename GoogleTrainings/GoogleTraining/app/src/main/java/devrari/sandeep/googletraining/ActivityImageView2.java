package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivityImageView2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view2);
        RadioGroup rg=findViewById(R.id.imageViewRG);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String temp="no item";
                switch (checkedId){
                    case R.id.sameDay:
                        temp="Same day";
                        break;
                    case R.id.nextDay:
                        temp="Next day";
                        break;
                    case R.id.pickUp:
                        temp=" pick up";
                        break;
                }
                Toast.makeText(ActivityImageView2.this, "Chosen: "+temp, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
