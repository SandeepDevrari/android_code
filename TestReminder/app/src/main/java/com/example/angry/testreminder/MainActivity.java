package com.example.angry.testreminder;

import android.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.angry.testreminder.adapter.RecyclerAdapterHere;
import com.example.angry.testreminder.database.DatabaseAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private AlertDialog alertDialog;
    private EditText msg;
    private TextView time;
    private int intt=0;
    private RecyclerAdapterHere recyclerAdapterHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkedUI();
        logicsHere();
    }

    private void logicsHere() {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        View view=getLayoutInflater().inflate(R.layout.layout_alert_custom,null);
        alert.setView(view);
        view.findViewById(R.id.alertTime).setOnClickListener(this);
        view.findViewById(R.id.alertSave).setOnClickListener(this);
        view.findViewById(R.id.alertCancle).setOnClickListener(this);
        msg=view.findViewById(R.id.alertMsg);
        time=view.findViewById(R.id.alertTime);
        alertDialog=alert.create();
        alertDialog.setCancelable(false);
        recyclerAdapterHere=new RecyclerAdapterHere(this);
        recyclerView.setAdapter(recyclerAdapterHere);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void linkedUI() {
        recyclerView=findViewById(R.id.allTask);
        findViewById(R.id.addTask).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.addTask:{
                alertDialog.show();
                break;
            }
            case R.id.alertSave:{
                DatabaseAdapter databaseAdapter=new DatabaseAdapter(this);
                databaseAdapter.insert(intt,msg.getText().toString(),null);
                intt++;
                alertDialog.dismiss();
                recyclerAdapterHere.notifyDataSetChanged();
                break;
            }
            case R.id.alertCancle:{
                alertDialog.dismiss();
                break;
            }
            case R.id.alertTime:{
                DialogFragment timeDialog=new TimePickerFragment();
                timeDialog.show(getFragmentManager(),"Select time");
                break;
            }
        }
    }
}
