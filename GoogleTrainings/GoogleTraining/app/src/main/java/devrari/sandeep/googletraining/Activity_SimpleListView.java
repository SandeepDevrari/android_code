package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity_SimpleListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__simple_list_view);
        ListView listView=findViewById(R.id.simpleListView_view);
        SimpleListToComplexOne listToComplex=new SimpleListToComplexOne();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,listToComplex.getFirstName());//listToComplex.getEmployees());
        //listView.setAdapter(arrayAdapter);
        ComplexListUsingBaseAdapter complexListUsingBaseAdapter=new ComplexListUsingBaseAdapter(listToComplex.getEmployees(),this);
        listView.setAdapter(complexListUsingBaseAdapter);
    }
}
