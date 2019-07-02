package devrari.sandeep.angry.rvtrain;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Sir ji");
        alert.setMessage("wait kr le..");
        alert.setPositiveButton("ha bhai", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        /*alert.setNegativeButton("Na Bhai", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });*/
        alert.setCancelable(false);
        alert.show();
    }
}
