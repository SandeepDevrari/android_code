package devrari.sandeep.angry.rvtrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class Activity_MultiAutoCompleteTextView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__multi_auto_complete_text_view);
        MultiAutoCompleteTextView multi=findViewById(R.id.multiAutoCompleteTextView_1);
        String[] str={"ABC","DEF","GHI","XYZ"};
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,str);
        multi.setAdapter(arrayAdapter);
        multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
