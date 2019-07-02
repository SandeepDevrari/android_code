package devrari.sandeep.angry.rvtrain;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert);
        Button alertButton=findViewById(R.id.customAlertButton);
        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alert=new AlertDialog.Builder(CustomAlertActivity.this);
                View view= getLayoutInflater().inflate(R.layout.layout_custom_alert,null);
                alert.setTitle("LogIn");
                alert.setView(view);
                alert.show();
                alert.setCancelable(false);
                alert.create();
                ((Button)view.findViewById(R.id.customAlertLayButton)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //
                    }
                });
            }
        });
    }
}
