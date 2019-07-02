package com.example.angry.trainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListCustomActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<PojoClassForCustomListView> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_custom);
        ui_init();
        setData();
        ui_flow();
    }

    private void setData() {
        String[] texts=new String[]{
                "TextView 0","TextView 1","TextView 2","TextView 3","TextView 4","TextView 5","TextView 6","TextView 7","TextView 8","TextView 9"
        };
        String[] buttons=new String[]{
                "Button 0","Button 1","Button 2","Button 3","Button 4","Button 5","Button 6","Button 7","Button 8","Button 9"
        };
        for(int i=0;i<texts.length;i++){
            arrayList.add(new PojoClassForCustomListView(texts[i],buttons[i]));
        }
    }

    private void ui_flow() {
        CustomListAdapter customListAdapter=new CustomListAdapter(this, arrayList);
        listView.setAdapter(customListAdapter);
    }

    private void ui_init() {
        listView=findViewById(R.id.customListFor);
    }
}
