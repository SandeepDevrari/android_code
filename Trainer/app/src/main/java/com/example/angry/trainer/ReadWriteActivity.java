package com.example.angry.trainer;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadWriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write);
        String file ="InternalFile.txt";

        String fileContents = "Hello world!";
//        FileOutputStream outputStream;
//        try {
//            outputStream = openFileOutput(file, Context.MODE_PRIVATE);
//            outputStream.write(fileContents.getBytes());
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        File directory = getBaseContext().getFilesDir();
//        File fileName = new File(directory, file);
//        FileInputStream fileInputStream;
//        try {
//            String str="";
//            fileInputStream=openFileInput(fileName.getName());
//            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
//            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
//            StringBuilder stringBuilder=new StringBuilder("");
//            while((str=bufferedReader.readLine())!=null){
//                stringBuilder.append(str);
//            }
//            Toast.makeText(this, stringBuilder, Toast.LENGTH_SHORT).show();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File fileEx;
        if(isExAvailable()){
            fileEx=new File(getExternalFilesDir("Path"),"ABCDEF.txt");
        }
        else{
            fileEx=null;
        }
        FileOutputStream outputStream = null;
        if(fileEx!=null) {
            try {
                outputStream = new FileOutputStream(fileEx);
                outputStream.write(fileContents.getBytes());
                outputStream.flush();
                outputStream.close();
                Toast.makeText(this, "Write sucessful", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String temp="";
        FileInputStream fileInputStream= null;
        if(isExStorageReadOnly()|| isExAvailable()) {
            try {
                fileInputStream = new FileInputStream(fileEx);

                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder(temp);
                while ((temp = bufferedReader.readLine()) != null) {
                    stringBuilder.append(temp);
                }
                Toast.makeText(this, stringBuilder, Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean isExAvailable(){
        String exState= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(exState)){
            return true;
        }
        return false;
    }
    private boolean isExStorageReadOnly(){
        String exState= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(exState)){
            return true;
        }
        else{
            return false;
        }
    }
}
