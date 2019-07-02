package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HW_LifeCycle extends AppCompatActivity {

    TextView countTxt;
    Button incrementer;
    EditText saver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw__life_cycle);
        countTxt=findViewById(R.id.counterTxt);
        incrementer=findViewById(R.id.pressIncreaseCounter);
        saver=findViewById(R.id.saveThisEditTxt);
        incrementer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTxt.setText((Integer.parseInt(countTxt.getText().toString())+1)+"");
            }
        });
    }
}
