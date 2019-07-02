package com.example.angry.trainer;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class ActivityPermissions extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private static final int REQUEST_CODE_READ_STORAGE=99;
    private static final int IMAGE_CAPTURE=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        ui_init();
        ui_flow();
        checkReadPermissionGiven();
        Intent intent=new Intent();
        Bundle bundle=new Bundle();
        bundle.putInt("FFF",9);
        intent.putExtras(bundle);
    }

    private void ui_flow() {
        imageView.setOnClickListener(this);
    }

    private void ui_init() {
        imageView=findViewById(R.id.clickToCapture);
    }

    public void checkReadPermissionGiven() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
//            Snackbar.make(recyclerView,"Storage permission is required",Snackbar.LENGTH_INDEFINITE).setAction("Request", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
                    ActivityCompat.requestPermissions(ActivityPermissions.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_READ_STORAGE);
//                }
//            }).show();
        }
        else{
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case REQUEST_CODE_READ_STORAGE :{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                }
                else{
                    AlertDialog.Builder builder=new AlertDialog.Builder(this);
                    builder.setTitle("Permission request");
                    builder.setMessage("Call permission is required in order to make a call");
                    builder.setPositiveButton("request", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            checkReadPermissionGiven();
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }
                break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.clickToCapture:{
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(intent,IMAGE_CAPTURE);
                }
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==IMAGE_CAPTURE && resultCode==RESULT_OK){
            Bundle extra=data.getExtras();
            Bitmap bitmap= (Bitmap) extra.get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}
