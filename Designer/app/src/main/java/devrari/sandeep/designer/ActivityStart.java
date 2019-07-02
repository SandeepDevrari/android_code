package devrari.sandeep.designer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button getStart=findViewById(R.id.getstarted);
        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityStart.this,"welcome here",Toast.LENGTH_SHORT).show();
                Intent it=new Intent(ActivityStart.this,ActivityLog.class);
                startActivity(it);
            }
        });
    }
}
