package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityRecyclerTemp extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_temp);
        recyclerView=findViewById(R.id.tempRecyclerView);
        TempDataRecycler tempDataRecycler=new TempDataRecycler();
        TempAdapterRecycle adapterRecycle=new TempAdapterRecycle(this,tempDataRecycler.totals);
        recyclerView.setAdapter(adapterRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private class TempDataRecycler{
        int[] images;
        String[] names;
        ArrayList<GetterSetterTempRecycle> totals;
        GetterSetterTempRecycle getterSetterTempRecycle;
        TempDataRecycler(){
            images=new int[]{R.drawable.donut_circle,R.drawable.donut_circle,R.drawable.donut_circle,R.drawable.donut_circle,R.drawable.donut_circle,R.drawable.donut_circle,R.drawable.donut_circle};
            names=new String[]{"Donat","Donat","Donat","Donat","Donat","Donat","Donat","Donat"};
            totals=new ArrayList<>();
            for(int i=0;i<images.length;i++){
                getterSetterTempRecycle=new GetterSetterTempRecycle(images[i],names[i]);
                totals.add(getterSetterTempRecycle);
            }
        }
    }
}
