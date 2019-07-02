package devrari.sandeep.ocrapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import devrari.sandeep.ocrapp.recycler_adapters.SendToViewAdapter;

public class ActivitySendTo extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_to);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        if(bundle!=null){
            list=bundle.getStringArrayList("SEND_TO");
        }
        linkeUI();
        logicsHere();
    }

    private void logicsHere() {
        SendToViewAdapter sendToViewAdapter=new SendToViewAdapter(list,this);
        recyclerView.setAdapter(sendToViewAdapter);
    }

    private void linkeUI() {
        recyclerView=findViewById(R.id.sendToRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.image_tool,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sendToIt:{
                ///task here
            }
        }
        return true;
    }
}
