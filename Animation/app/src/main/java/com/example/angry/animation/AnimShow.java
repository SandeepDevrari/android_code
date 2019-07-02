package com.example.angry.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;

public class AnimShow extends AppCompatActivity {

    ImageView imageView;
    Animation zoomin,zoomout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_show);
        Intent intt=getIntent();
        String btVal=intt.getStringExtra("ButtonValue");
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

/*        imageView = (imageView)findViewById(R.id.yourImageViewId);
        zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);
        imageView.setAnimation(zoomin);
        imageView.setAnimation(zoomout);*/
    }
}
