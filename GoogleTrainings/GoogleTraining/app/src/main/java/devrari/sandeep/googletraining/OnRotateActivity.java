package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OnRotateActivity extends AppCompatActivity {

    private String temp="temp";
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_rotate);
        Toast.makeText(this,"ho gya na",Toast.LENGTH_SHORT).show();
        EditText t=findViewById(R.id.rotateEditText);
        t.setText(temp);
        final TextView tv=findViewById(R.id.rotateTxt);
        tv.setText("default");
        if(savedInstanceState!=null){
            tv.setText(savedInstanceState.getString("iValue"));
            i=Integer.parseInt(savedInstanceState.getString("iValue"));
        }
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(""+(i++));
            }
        });
        Spinner spin=findViewById(R.id.rotateSpiner);
        ArrayAdapter<CharSequence> adap=ArrayAdapter.createFromResource(getApplicationContext(),R.array.rotateSpinArray,android.R.layout.simple_dropdown_item_1line);
        spin.setAdapter(adap);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"nothing is selected",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("iValue",i+"");
    }
}
