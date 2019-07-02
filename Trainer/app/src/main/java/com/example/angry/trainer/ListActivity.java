package com.example.angry.trainer;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //Snackbar.make(findViewById(R.id.listActLay),"SNACK",Snackbar.LENGTH_SHORT).show();
        ui_init();
        ui_flow();
    }

    private void ui_flow() {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("ABC");
        arrayList.add("ABCDC");
        arrayList.add("ABCDDDD");
        arrayList.add("ABCaAAA");
        arrayList.add("ABCaAAAA");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }

    private void ui_init() {
        listView=findViewById(R.id.listViewFor);
    }
}
