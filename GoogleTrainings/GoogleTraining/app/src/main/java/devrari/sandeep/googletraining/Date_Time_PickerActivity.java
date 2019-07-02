package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Date_Time_PickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date__time__picker);
        ToggleButton tb=findViewById(R.id.pickerToggle);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    FragmentDatePicker datePicker=new FragmentDatePicker();
                    datePicker.show(getSupportFragmentManager(),"Date Fragment Picker");
                }
                else{
                    FragmentTimePicker timePicker=new FragmentTimePicker();
                    timePicker.show(getSupportFragmentManager(),"Time Fragment Picker");
                }
            }
        });
    }

    public void setTimeTost(int hourOfDay, int minute) {
        Toast.makeText(this, ""+hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
    }

    public void setDateTost(int year, int month, int dayOfMonth) {
        Toast.makeText(this, ""+dayOfMonth+"-"+month+"/"+year, Toast.LENGTH_SHORT).show();
    }
}
