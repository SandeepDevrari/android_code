package devrari.sandeep.googletraining;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class DesignControls extends AppCompatActivity {

    private EditText designEnterTxt,designPhoneTxt;
    private ToggleButton designTBEnter,designTBPhone;
    private CheckBox designOnBoth;
    private RadioGroup designRadioG;
    private Button designReset,designGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_controls);
        designEnterTxt=findViewById(R.id.designTextEnter);
        designPhoneTxt=findViewById(R.id.designTextNumber);
        designTBEnter=findViewById(R.id.toggleDesign1);
        designTBPhone=findViewById(R.id.toggleDesign2);
        designOnBoth=findViewById(R.id.designCheckBox);
        designRadioG=findViewById(R.id.radioGroupDesign);
        designReset=findViewById(R.id.designReset);
        designGo=findViewById(R.id.designGoOn);

        designTBEnter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    designEnterTxt.setEnabled(true);
                }
                else{
                    designEnterTxt.setEnabled(false);
                }
            }
        });

        designTBPhone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    designPhoneTxt.setEnabled(true);
                }
                else{
                    designPhoneTxt.setEnabled(false);
                }
            }
        });

        designOnBoth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    designTBEnter.setEnabled(true);
                    designTBPhone.setEnabled(true);
                }
                else{
                    designTBEnter.setEnabled(false);
                    designTBPhone.setEnabled(false);
                }
            }
        });

        designRadioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==findViewById(R.id.designOn).getId()){
                    designOnBoth.setEnabled(true);
                }
                else{
                    designOnBoth.setEnabled(false);
                }
            }
        });

        designReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert=new AlertDialog.Builder(DesignControls.this);
                alert.setTitle("Reset All");
                alert.setMessage("Are you sure ?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        designEnterTxt.setEnabled(true);
                        designPhoneTxt.setEnabled(true);
                        designTBEnter.setEnabled(true);
                        designTBPhone.setEnabled(true);
                        designOnBoth.setEnabled(true);
                        designRadioG.setEnabled(true);
                        dialog.dismiss();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alert.setCancelable(false);
                alert.show();
            }
        });
        designGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog pb=new ProgressDialog(DesignControls.this);
                pb.setTitle("Loading...");
                pb.setMessage("moving to Go..\nPlease wait...");
                pb.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pb.setButton(ProgressDialog.BUTTON_NEGATIVE, "cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                pb.show();
            }
        });
    }
}
