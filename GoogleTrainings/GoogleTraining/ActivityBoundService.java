package devrari.sandeep.googletraining;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import devrari.sandeep.googletraining.custom_services.BoundServiceClass;

public class ActivityBoundService extends AppCompatActivity implements View.OnClickListener{

    private ToggleButton startEnd,bindUnbind;
    private Intent intent;
    private ServiceConnection serviceConnection;
    private BoundServiceClass boundServiceClass;
    private Button getNumber;
    private TextView showTheNumber;
    private boolean isbounded=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);
        linkingUI();
        logicsHere();
    }

    private void logicsHere() {
        intent=new Intent(getApplicationContext(), BoundServiceClass.class);
    }

    private void linkingUI() {
        startEnd=findViewById(R.id.boundServiceStartEndButton);
        bindUnbind=findViewById(R.id.boundServiceBindUnbind);
        getNumber=findViewById(R.id.boundServiceGetNumber);
        showTheNumber=findViewById(R.id.boundServiceText);
        startEnd.setOnClickListener(this);
        bindUnbind.setOnClickListener(this);
        getNumber.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boundServiceStartEndButton:{
                if(((ToggleButton)v).isChecked()){
                    startService(intent);
                    Log.w("Service - ","Started");
                }
                else{
                    stopService(intent);
                    Log.w("Service - ","Stopped");
                }
                break;
            }
            case R.id.boundServiceBindUnbind:{
                if(((ToggleButton)v).isChecked()){
                    if(serviceConnection==null){
                        serviceConnection=new ServiceConnection() {
                            @Override
                            public void onServiceConnected(ComponentName name, IBinder service) {
                                BoundServiceClass.BinderService binderService= (BoundServiceClass.BinderService) service;
                                boundServiceClass=binderService.getBinder();
                                isbounded=true;
                                Log.w("Service Connection ",""+isbounded);
                            }

                            @Override
                            public void onServiceDisconnected(ComponentName name) {
                                isbounded=false;
                                Log.w("Service Connection ",""+isbounded);
                            }
                        };
                        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
                        Log.w("Service - ","Service Binded");
                    }
                }
                else{
                    if(isbounded) {
                        unbindService(serviceConnection);
                        isbounded=false;
                        Log.w("Service - ","Service Unbinded");
                    }
                }
                break;
            }
            case R.id.boundServiceGetNumber:{
                String s="no service!!";
                if(boundServiceClass!=null & isbounded){
                    s= String.valueOf(boundServiceClass.getNumber());
                }
                showTheNumber.setText(s);
                break;
            }
        }
    }
}
