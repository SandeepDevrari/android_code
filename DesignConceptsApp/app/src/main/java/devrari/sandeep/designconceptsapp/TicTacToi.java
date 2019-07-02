package devrari.sandeep.designconceptsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TicTacToi extends AppCompatActivity {

    private ImageView im1,im2,im3,im4,im5,im6,im7,im8,im9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toi);
        im1=findViewById(R.id.ticImageView1);
        im2=findViewById(R.id.ticImageView2);
        im3=findViewById(R.id.ticImageView3);
        im4=findViewById(R.id.ticImageView4);
        im5=findViewById(R.id.ticImageView5);
        im6=findViewById(R.id.ticImageView6);
        im7=findViewById(R.id.ticImageView7);
        im8=findViewById(R.id.ticImageView8);
        im9=findViewById(R.id.ticImageView9);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im1.setTranslationX(-1000f);
                im1.setImageResource(R.drawable.red);
                im1.setAlpha(1f);
                im1.animate().translationXBy(1000f).setDuration(1_000);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im2.setTranslationY(1000f);
                im2.setImageResource(R.drawable.red);
                im2.setAlpha(1f);
                im2.animate().translationYBy(-1000f).setDuration(1_000);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im3.setTranslationX(1000f);
                im3.setImageResource(R.drawable.red);
                im3.setAlpha(1f);
                im3.animate().translationXBy(-1000f).setDuration(1_000);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im4.setTranslationX(-1000f);
                im4.setImageResource(R.drawable.red);
                im4.animate().translationXBy(1000f).setDuration(1_000);
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im5.setAlpha(0f);
                im5.setImageResource(R.drawable.red);
                im5.animate().alphaBy(1f).setDuration(1_000);
            }
        });
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im6.setTranslationX(1000f);
                im6.setImageResource(R.drawable.red);
                im6.animate().translationXBy(-1000f).setDuration(1_000);
            }
        });
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im7.setTranslationX(-1000f);
                im7.setImageResource(R.drawable.red);
                im7.animate().translationXBy(1000f).setDuration(1_000);
            }
        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im8.setTranslationY(-1000f);
                im8.setImageResource(R.drawable.red);
                im8.animate().translationYBy(1000f).setDuration(1_000);
            }
        });
        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im9.setTranslationX(1000f);
                im9.setImageResource(R.drawable.red);
                im9.animate().translationXBy(-1000f).setDuration(1_000);
            }
        });

    }
}
