package devrari.sandeep.googletraining;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by user on 20/4/18.
 */

public class BrodcastReceiverExtended extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "SMS received", Toast.LENGTH_SHORT).show();
    }
}
