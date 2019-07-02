package devrari.sandeep.googletraining;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityReadndPermission extends AppCompatActivity {

    private Button contacts,camera,messages;
    private Context context;
    private final int PERMISSION_CONTACT_REQUEST_CODE=1,PERMISSION_CAMERA_REQUEST_CODE=2;
    private boolean contactPermission=false,cameraPermission=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readnd_permission);
        context=getApplicationContext();
        contacts=findViewById(R.id.readPermissionReadContactsButton);
        camera=findViewById(R.id.readPermissionOpenCameraButton);
        messages=findViewById(R.id.readPermissionReadMeassagesButton);

        View.OnClickListener clickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.readPermissionReadContactsButton:
                        readContacts();
                        break;
                    case R.id.readPermissionOpenCameraButton:
                        openCamera();
                        break;
                    case R.id.readPermissionReadMeassagesButton:
                        readMeassages();
                        break;
                }
            }
        };
        contacts.setOnClickListener(clickListener);
        camera.setOnClickListener(clickListener);
        messages.setOnClickListener(clickListener);
    }

    private void readMeassages() {
    }

    private void openCamera() {
        if(!cameraPermission){
            checkPermissions("CAMERA");
        }
        else{
            Intent intent=new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager())!=null){
                startActivityForResult(intent,PERMISSION_CAMERA_REQUEST_CODE);
            }
        }
    }

    private void readContacts() {
        if(!contactPermission){
            checkPermissions("CONTACTS");
        }
        else{
            Intent intent=new Intent(context,ActivityContacts.class);
            startActivity(intent);
        }

    }
    private void checkPermissions(String str){
        if(str.equals("CONTACTS")){
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.READ_CONTACTS},PERMISSION_CONTACT_REQUEST_CODE);
            }
            else{
                contactPermission=true;
                readContacts();
            }
        }
        if(str.equals("CAMERA")){
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA},PERMISSION_CAMERA_REQUEST_CODE);
            }
            else{
                cameraPermission=true;
                //readContacts();
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case PERMISSION_CONTACT_REQUEST_CODE:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    contactPermission=true;
                }
                else{
                    contactPermission=false;
                    Snackbar.make(contacts,"Read Contacts permission is need",Snackbar.LENGTH_INDEFINITE).setAction("Allow", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkPermissions("CONTACTS");
                        }
                    }).show();
                }
                break;
            }
            case PERMISSION_CAMERA_REQUEST_CODE:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    cameraPermission=true;
                }
                else{
                    cameraPermission=false;
                    Snackbar.make(camera,"Camera permission is need",Snackbar.LENGTH_INDEFINITE).setAction("Allow", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkPermissions("CAMERA");
                        }
                    }).show();
                }
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PERMISSION_CAMERA_REQUEST_CODE & resultCode==RESULT_OK){
            if(data!=null){
                Bundle bundle=data.getExtras();
                Bitmap bitmap=(Bitmap) bundle.get("data");
                ConstraintLayout constraintLayout=findViewById(R.id.readndPermissionMainLayout);
                //ImageView imageView=findViewById(R.id.readndPermissionImageVIewLayout);
                BitmapDrawable drawable=new BitmapDrawable(bitmap);
                //imageView.setImageBitmap(bitmap);
                constraintLayout.setBackground(drawable);
            }
        }
    }
}
