package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResourceViewEvent extends AppCompatActivity {

    private Button button_1,button_2;
    private TextView text_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_view_event);
        button_1=findViewById(R.id.button_1);
        button_2=findViewById(R.id.button2);
        text_1=findViewById(R.id.text2);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_1.setText("You click button1");
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_1.setText("You click button2");
            }
        });
    }
}
