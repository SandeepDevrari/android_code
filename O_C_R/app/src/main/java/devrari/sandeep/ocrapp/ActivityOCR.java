package devrari.sandeep.ocrapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import devrari.sandeep.ocrapp.pojo_classes.GetndSet;
import devrari.sandeep.ocrapp.recycler_adapters.RecyclerAdapter;

public class ActivityOCR extends AppCompatActivity implements View.OnClickListener{

    private Context context;
    private ImageButton openMore,closeMore,openGallery,openCamera;
    private RecyclerView recyclerView;
    private ConstraintSet rootSet,copySet;
    private boolean isMore,isReadPermissionGiven;
    private ConstraintLayout rootLayout;
    private final int REQUEST_CODE_READ_STORAGE=1;
    private final int REQUEST_CODE_CAMERA=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr);
        layoutAnim();
        linkUI();
        checkReadPermissionGiven();
        logicHere();
    }

    private void logicHere() {
        final List<GetndSet>getndSetList=fetchImagesFromStore();
        final RecyclerAdapter recyclerAdapter;
        if(getndSetList!=null) {
            recyclerAdapter = new RecyclerAdapter(context,getndSetList);
            recyclerView.setAdapter(recyclerAdapter);
        }
    }

    private void layoutAnim() {
        context=getApplicationContext();
        rootLayout=findViewById(R.id.MainLayout);
        rootSet=new ConstraintSet();
        copySet=new ConstraintSet();
        rootSet.clone(rootLayout);
        copySet.clone(this,R.layout.activity_ocr_scrollable_toolbar);
        isMore=false;
    }

    private void linkUI() {
        recyclerView=findViewById(R.id.recyclerAllImages);
        recyclerView.setLayoutManager(new GridLayoutManager(context,4,GridLayoutManager.HORIZONTAL,false));

        openMore=findViewById(R.id.openMore);
        openMore.setOnClickListener(this);

        closeMore=findViewById(R.id.closeMore);
        closeMore.setOnClickListener(this);

        openGallery=findViewById(R.id.openGallery);
        openGallery.setOnClickListener(this);

        openCamera=findViewById(R.id.openCamera);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.openMore:{
                //TransitionManager.beginDelayedTransition(rootLayout);
                (isMore?rootSet:copySet).applyTo(rootLayout);
                isMore=!isMore;
                break;
            }
            case R.id.closeMore:{
                //TransitionManager.beginDelayedTransition(rootLayout);
                (isMore?rootSet:copySet).applyTo(rootLayout);
                isMore=!isMore;
                break;
            }
            case R.id.openGallery:{
                if(isReadPermissionGiven){
                    Intent intent=new Intent(context,ActivityCustomGallery.class);
                    startActivity(intent);
                }
                else{
                    checkReadPermissionGiven();
                }

//                intent.setAction(Intent.ACTION_PICK);
//                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                if(intent.resolveActivity(getPackageManager())!=null){

//                }
//                else{
//                    Toast.makeText(context, "No such Handler", Toast.LENGTH_SHORT).show();
//                }
                break;
            }
            case R.id.openCamera:{
                Toast.makeText(context, "No Camera now!!", Toast.LENGTH_SHORT).show();
                break;
            }
            default:{
                Toast.makeText(context, "No such option!!", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    @SuppressLint("ResourceType")
    private  List<GetndSet> fetchImagesFromStore(){
        List<GetndSet>list=new ArrayList<>();
        if(isReadPermissionGiven){
            ArrayList<File>files=new ArrayList<>();
            File dcimFolder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            files.add(dcimFolder);
            File picturesFolder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            files.add(picturesFolder);
            //File documentsFolder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            //files.add(documentsFolder);
            //File downloadsFolder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            //files.add(downloadsFolder);
            GetndSet getndSet;
            for(File fileTmp:files){
                if(fileTmp.exists()){
                    File[] fileArray=fileTmp.listFiles();
                    for(int i=0;i<fileArray.length;i++){
                        getndSet=new GetndSet();
                        getndSet.setPathUri(Uri.fromFile(fileArray[i]));
                        list.add(getndSet);
                    }
                }
            }
        }
        else{
            list=null;
//            Snackbar.make(recyclerView,"Storage Permission",Snackbar.LENGTH_INDEFINITE).setAction("Allow", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent();
//                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                    Uri uri = Uri.fromParts("package", getPackageName(), null);
//                    intent.setData(uri);
//                    startActivity(intent);
//                }
//            }).show();
        }
        return list;
    }


    public void checkReadPermissionGiven() {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            Snackbar.make(recyclerView,"Storage permission is required",Snackbar.LENGTH_INDEFINITE).setAction("Request", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityCompat.requestPermissions(ActivityOCR.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_READ_STORAGE);
                }
            }).show();
        }
        else{
            isReadPermissionGiven=true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_READ_STORAGE:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    isReadPermissionGiven=true;
                }
                else{
                    isReadPermissionGiven=false;
                }
                break;
            }
            default:{
                Log.e("REQUEST CODE -","NOT MATCH");
                break;
            }
        }

    }
}
