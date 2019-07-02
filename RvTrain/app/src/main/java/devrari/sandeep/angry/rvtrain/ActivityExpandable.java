package devrari.sandeep.angry.rvtrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityExpandable extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private List<String>header;
    private HashMap<String,List<String>> child;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        expandableListView=findViewById(R.id.expandable);

        //Data
        header=new ArrayList<>();
        List<String>temp=new ArrayList<>();
        for(int i=1;i<11;i++){
            header.add("header "+i);
            temp.add("item "+i);
        }
        child=new HashMap<>();
        for(String str:header){
            child.put(str,temp);
        }

        CustomExpandableListAdapter customExpandableListAdapter=new CustomExpandableListAdapter(this,header,child);
        expandableListView.setAdapter(customExpandableListAdapter);
    }
}
