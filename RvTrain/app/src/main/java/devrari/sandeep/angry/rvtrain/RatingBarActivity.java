package devrari.sandeep.angry.rvtrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingBarActivity extends AppCompatActivity {

    RatingBar rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        rate=findViewById(R.id.ratingBar1);
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(fromUser){
                    Toast.makeText(RatingBarActivity.this,""+rating,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
