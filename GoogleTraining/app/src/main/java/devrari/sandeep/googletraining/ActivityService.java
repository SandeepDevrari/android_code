package devrari.sandeep.googletraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

import devrari.sandeep.googletraining.custom_services.ServiceClassBasicConcept;

public class ActivityService extends AppCompatActivity implements View.OnClickListener{

    private ToggleButton toggleButton;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        linkingUI();
        logicsHere();

    }

    private void logicsHere() {
        Log.w("Main Thread Id-",""+Thread.currentThread().getId());
        intent=new Intent(getApplicationContext(), ServiceClassBasicConcept.class);
    }

    private void linkingUI() {
        toggleButton=findViewById(R.id.service_toggle_button);
        toggleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.service_toggle_button:{
                if(((ToggleButton)v).isChecked()){
                    startService(intent);
                }
                else{
                    stopService(intent);
                }
            }
        }
    }
}
