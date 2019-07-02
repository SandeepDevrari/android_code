package devrari.sandeep.googletraining;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityCustomNormalBrodcastReceiver extends AppCompatActivity {

    private LocalBroadcastManager broadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_normal_brodcast_receiver);
        broadcastManager=LocalBroadcastManager.getInstance(getApplicationContext());
    }

    public void customBroadcastCaller(View view) {
        Intent intent=new Intent();
        intent.setAction("this.is.the.custom.broadcast");
        intent.addCategory("android.intent.category.DEFAULT");
        sendBroadcast(intent);
        //for secure broadcast receiver set exported false in manifest file or
        //use the localbroadcastmanger as-
        //broadcastManager.sendBroadcast(intent);
    }
}
