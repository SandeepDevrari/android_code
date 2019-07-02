package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityDatabaseSQLite extends AppCompatActivity {

    private EditText data1,data2,data1re,data2modify;
    private Button add,remove,modify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_sqlite);
        data1=findViewById(R.id.databaseData1);
        data2=findViewById(R.id.databaseData2);
        data1re=findViewById(R.id.databaseData1Repeat);
        data2modify=findViewById(R.id.databaseData2Modify);
        add=findViewById(R.id.databaseAdd);
        remove=findViewById(R.id.databaseRemove);
        modify=findViewById(R.id.databaseModify);

        final DatabaseAdapter databaseAdapter=new DatabaseAdapter(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseAdapter.insert(data1.getText().toString(),data2.getText().toString());
            }
        });
    }
}
