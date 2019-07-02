package com.example.angry.tasks;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class CameraClickActivity extends AppCompatActivity {

    private ImageView imageView;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_click);
        imageView=findViewById(R.id.imageView1);
    }

    public void clickImage(View view) {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
           startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode== RESULT_OK && data!=null){
            Log.w("***************",""+data);
            Bitmap bitmap=(Bitmap)( data.getExtras().get("data"));
            if(bitmap!=null) {
                imageView.setImageBitmap(bitmap);
            }
        }
        else{
            Log.w("$$$$$$$$$$$$$$$$$$$$$4",""+data);
        }
    }
}
