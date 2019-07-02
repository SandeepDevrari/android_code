package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Debug extends AppCompatActivity {

    TextView result;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        Button add=findViewById(R.id.debug_add);
        t1=findViewById(R.id.editText1);
        t2=findViewById(R.id.editText2);
        result=findViewById(R.id.debugResult);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+" "+(Integer.parseInt(t1.getText().toString())+Integer.parseInt(t2.getText().toString())));
            }
        });
    }
}
