package devrari.sandeep.angry.rvtrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Views_Try extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views__try);
       final CheckBox ch1=findViewById(R.id.checkBoxMe);
        final CheckBox ch2=findViewById(R.id.checkBoxYou);
        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(),ch1.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(),ch2.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        RadioGroup rg=findViewById(R.id.radioGroup);
        final RadioButton rb1=findViewById(R.id.radioButtonMai);
        final RadioButton rb2=findViewById(R.id.radioButtonAap);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rb1.getId()==checkedId){
                    Toast.makeText(getApplicationContext(),rb1.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),rb2.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
