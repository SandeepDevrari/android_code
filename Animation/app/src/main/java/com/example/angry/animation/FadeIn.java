package com.example.angry.animation;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class FadeIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_in);
        ImageView iv1 = (ImageView)findViewById(R.id.fadeImg);
        int imagesToShow[] = { R.raw.pic1, R.raw.pic2,R.raw.pic3,R.raw.pic4 };
        Random rnd = new Random();
        int color = Color.argb(255, 255, 255, 255);
        Toast.makeText(this,""+color,Toast.LENGTH_LONG).show();
        System.out.println("%%%%%%%%%%%%% "+color);
        fade(iv1, imagesToShow, 0,false);
    }
    private void fade(final ImageView imageView, final int images[], final int imageIndex, final boolean forever) {
        int fadeInDuration = 500;
        int timeBetween = 3000;
        int fadeOutDuration = 1000;

        imageView.setVisibility(View.INVISIBLE);
        imageView.setImageResource(images[imageIndex]);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(fadeInDuration);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(fadeInDuration + timeBetween);
        fadeOut.setDuration(fadeOutDuration);

        AnimationSet animation = new AnimationSet(false);
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);
        animation.setRepeatCount(1);
        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (images.length - 1 > imageIndex) {
                    fade(imageView, images, imageIndex + 1,forever);
                }
                else {
                    if (forever){
                        fade(imageView, images, 0,forever);
                    }
                }
            }
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }
        });
    }
}
