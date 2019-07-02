package devrari.sandeep.designconceptsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ActivityFadeAnimation extends AppCompatActivity {

    private ImageView image_1,image_2,image_3,image_4,image_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_animation);
        image_1=findViewById(R.id.fadeImageView1);
        image_2=findViewById(R.id.fadeImageView2);
        image_3=findViewById(R.id.fadeImageView3);
        image_5=findViewById(R.id.fadeImageView5);
        image_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                image_1.animate().alpha(0f);//.setDuration(5_000)
//                image_2.animate().alpha(1f).setDuration(5_000);
                image_5.animate().alpha(0f).setDuration(3_500);
                image_5.animate().translationY(1800f).setDuration(3_000);
                image_3.animate().scaleX(0.5f).scaleY(0.5f).setDuration(6_000);
                image_2.animate().alpha(0f);
//
//
//                image_2.animate().translationZBy(1800f).setDuration(14_050);
//
//                image_2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(15_000);
            }
        });
        image_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_3.animate().alpha(0f).setDuration(3_050);
                image_3.animate().scaleX(2.3f).scaleY(2.3f).setDuration(3_000);
                image_2.animate().scaleX(2.3f).scaleY(2.3f);
                image_2.animate().alpha(0.4f).setDuration(3_050);
                Log.e("image 3","clicked");
            }
        });
        image_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("image 2","clicked");
                image_2.animate().alpha(1f);
                image_2.animate().alpha(0f).setDuration(4_050);
                image_2.animate().scaleX(0.3f).scaleY(0.3f).setDuration(3_000);
            }
        });
    }
}
