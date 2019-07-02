package devrari.sandeep.angry.rvtrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ArrayAdapterToAuto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_to_auto);
        AutoCompleteTextView autoTxt=findViewById(R.id.autoText);
        String[] strTempDict=new String[]{"Sandeep","Devrari"};
        ArrayAdapter<String> adpterAuto=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,strTempDict);
        autoTxt.setAdapter(adpterAuto);
    }
}
