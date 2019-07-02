package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityRcyclerView extends AppCompatActivity {

    private RecyclerView recycle;
    private Button add;
    private EditText name,job,exper;
    private EmployeeOfRV employeeOfRV;
    private CustomRecyclerClass recyclerClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcycler_view);

        recycle=findViewById(R.id.recyclerView_view);

        final SimpleListToComplexOne simpleListToComplexOne=new SimpleListToComplexOne();
        final ArrayList<EmployeeOfRV> totals=simpleListToComplexOne.getEmployees();

        add=findViewById(R.id.recyclerAdd);
        name=findViewById(R.id.recyclerName);
        job=findViewById(R.id.recyclerJobTitle);
        exper=findViewById(R.id.recyclerExperience);

        recyclerClass=new CustomRecyclerClass(totals,this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTemp=name.getText().toString(),jobTemp=job.getText().toString(),exTemp=exper.getText().toString();
                if(isValidData(nameTemp)&&isValidData(jobTemp)&&isValidData(exTemp)){
                    employeeOfRV=new EmployeeOfRV(nameTemp,exTemp,jobTemp);

                    totals.add(employeeOfRV);

                    recyclerClass.notifyDataSetChanged();
                    recycle.scrollToPosition(totals.size()-1);
                }
                else {
                    Toast.makeText(ActivityRcyclerView.this, "Invalid !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recycle.setAdapter(recyclerClass);
        recycle.setLayoutManager(new LinearLayoutManager(this));

    }
    public boolean isValidData(String str){
        return (str==null)?false:true;
    }
}
