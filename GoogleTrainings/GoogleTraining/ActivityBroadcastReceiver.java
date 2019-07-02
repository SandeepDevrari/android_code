package devrari.sandeep.googletraining;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityBroadcastReceiver extends AppCompatActivity {
    private BrodcastReceiverExtended brodcastReceiverExtended;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        brodcastReceiverExtended=new BrodcastReceiverExtended();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(brodcastReceiverExtended,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(brodcastReceiverExtended);
    }
}
