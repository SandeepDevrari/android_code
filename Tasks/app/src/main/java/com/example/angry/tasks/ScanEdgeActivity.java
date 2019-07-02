package com.example.angry.tasks;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.scanlibrary.IScanner;
import com.scanlibrary.ResultFragment;
import com.scanlibrary.ScanConstants;
import com.scanlibrary.ScanFragment;
import com.scanlibrary.Utils;

import java.io.IOException;

public class ScanEdgeActivity extends AppCompatActivity implements IScanner, ComponentCallbacks2 {

    private ImageView scannedImage;
    private Bitmap bitmap;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_edge);
        init();
    }

    private void init() {
        scannedImage=findViewById(R.id.cropedImageHere);
        //firstCall();
    }

//    private void firstCall() {
//        Intent intent=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        //intent.setType("image/*");
//        //intent.addCategory(Intent.CATEGORY_OPENABLE);
//        startActivityForResult(intent, 7);
//    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == Activity.RESULT_OK) {
//            try {
//                switch (requestCode) {
//                    case 7:
//                        uri=data.getData();
//                        String[] filePathColumn = { MediaStore.Images.Media.DATA };
//                        Cursor cursor = getContentResolver().query(uri,filePathColumn, null, null, null);
//                        cursor.moveToFirst();
//                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                        String imgDecodableString = cursor.getString(columnIndex);
//                        cursor.close();
//                        bitmap= BitmapFactory.decodeFile(imgDecodableString);
//
//                        //bitmap= MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
//                        break;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            this.finish();
//        }
//    }
    public void scanFromHere(View view) {
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        FragmentForScanImages fragmentForScanImages=new FragmentForScanImages();
        //Bundle bundle=new Bundle();
        //bundle.putParcelable("DATAHERE", Utils.getUri(this,bitmap));
        //fragmentForScanImages.setArguments(bundle);
        fragmentTransaction.add(R.id.fragmentWorkHere,fragmentForScanImages);
        fragmentTransaction.addToBackStack("TOP1");
        fragmentTransaction.commit();
    }

    @Override
    public void onBitmapSelect(Uri uri) {
//        ScanFragment fragment = new ScanFragment();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(ScanConstants.SELECTED_BITMAP, uri);
//        fragment.setArguments(bundle);
//        android.app.FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(com.scanlibrary.R.id.content, fragment);
//        fragmentTransaction.addToBackStack(ScanFragment.class.toString());
//        fragmentTransaction.commit();
    }

    @Override
    public void onScanFinish(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            getContentResolver().delete(uri, null, null);
            scannedImage.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        ResultFragment fragment = new ResultFragment();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(ScanConstants.SCANNED_RESULT, uri);
//        fragment.setArguments(bundle);
//        android.app.FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(com.scanlibrary.R.id.content, fragment);
//        fragmentTransaction.addToBackStack(ResultFragment.class.toString());
//        fragmentTransaction.commit();
    }

    @Override
    public void onTrimMemory(int level) {
        switch (level) {
            case ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN:
                /*
                   Release any UI objects that currently hold memory.

                   The user interface has moved to the background.
                */
                break;
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE:
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW:
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL:
                /*
                   Release any memory that your app doesn't need to run.

                   The device is running low on memory while the app is running.
                   The event raised indicates the severity of the memory-related event.
                   If the event is TRIM_MEMORY_RUNNING_CRITICAL, then the system will
                   begin killing background processes.
                */
                break;
            case ComponentCallbacks2.TRIM_MEMORY_BACKGROUND:
            case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
            case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:
                /*
                   Release as much memory as the process can.

                   The app is on the LRU list and the system is running low on memory.
                   The event raised indicates where the app sits within the LRU list.
                   If the event is TRIM_MEMORY_COMPLETE, the process will be one of
                   the first to be terminated.
                */
                new AlertDialog.Builder(this)
                        .setTitle(com.scanlibrary.R.string.low_memory)
                        .setMessage(com.scanlibrary.R.string.low_memory_message)
                        .create()
                        .show();
                break;
            default:
                /*
                  Release any non-critical data structures.

                  The app received an unrecognized memory level value
                  from the system. Treat this as a generic low-memory message.
                */
                break;
        }
    }

    public native Bitmap getScannedBitmap(Bitmap bitmap, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4);

    public native Bitmap getGrayBitmap(Bitmap bitmap);

    public native Bitmap getMagicColorBitmap(Bitmap bitmap);

    public native Bitmap getBWBitmap(Bitmap bitmap);

    public native float[] getPoints(Bitmap bitmap);

    static {
        System.loadLibrary("opencv_java3");
        System.loadLibrary("Scanner");
    }
}
