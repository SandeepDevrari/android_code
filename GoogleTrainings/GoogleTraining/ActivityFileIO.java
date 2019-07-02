package devrari.sandeep.googletraining;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ActivityFileIO extends AppCompatActivity {

    private Button read,write,readEx,writeEx;
    private EditText text;
    private final String fileName="FileIOAndroid.txt";
    private File fileEx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_io);
        read=findViewById(R.id.fileRead);
        write=findViewById(R.id.fileWrite);
        readEx=findViewById(R.id.fileReadEx);
        writeEx=findViewById(R.id.fileWriteEx);
        text=findViewById(R.id.fileText);
        if(isExAvailable()){
            fileEx=new File(getExternalFilesDir("Path"),"ABCDEF.txt");
        }
        else{
            fileEx=null;
        }
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    readFrom();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataToWrite=text.getText().toString();
                if(!dataToWrite.isEmpty()){
                    try {
                        writeTo(dataToWrite,MODE_PRIVATE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        writeEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(fileEx!=null) {
                        try {
                            writeToEx(text.getText().toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        });
        readEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExStorageReadOnly()|| isExAvailable()){
                    try {
                        readToEx();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(ActivityFileIO.this, "can't Read Ex", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void writeTo(String str,int MODE) throws IOException{
        FileOutputStream fileOutputStream=openFileOutput(fileName,MODE);
        if(!str.isEmpty()){
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        }
    }
    private void readFrom() throws IOException{
        String str="";
        FileInputStream fileInputStream=openFileInput(fileName);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder=new StringBuilder("");
        while((str=bufferedReader.readLine())!=null){
            stringBuilder.append(str);
        }
        Toast.makeText(this, stringBuilder, Toast.LENGTH_SHORT).show();
    }
    private void writeToEx(String str) throws IOException{
        if(!str.isEmpty()) {
            FileOutputStream outputStream = new FileOutputStream(fileEx);
            outputStream.write(str.getBytes());
            outputStream.flush();
            outputStream.close();
            Toast.makeText(this, "Write sucessful", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Write Failed!!", Toast.LENGTH_SHORT).show();
        }
    }
     private void readToEx() throws IOException{
        String temp="";
        FileInputStream fileInputStream=new FileInputStream(fileEx);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder=new StringBuilder(temp);
        while((temp=bufferedReader.readLine())!=null){
            stringBuilder.append(temp);
        }
         Toast.makeText(this, stringBuilder, Toast.LENGTH_SHORT).show();
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
     private boolean isExAvailable(){
         String exState=Environment.getExternalStorageState();
         if(Environment.MEDIA_MOUNTED.equals(exState)){
             return true;
         }
         return false;
     }
}
