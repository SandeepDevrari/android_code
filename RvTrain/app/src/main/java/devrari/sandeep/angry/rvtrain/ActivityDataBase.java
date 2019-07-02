package devrari.sandeep.angry.rvtrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class ActivityDataBase extends AppCompatActivity {

    private int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        DatabaseAdapter databaseAdapter=new DatabaseAdapter(getApplicationContext());
        ContactPojo pojo=new ContactPojo((id++),"sandeep","8979221199");
        databaseAdapter.insert_data(pojo);
        pojo=new ContactPojo((id++),"devrari","8979221199");
        databaseAdapter.insert_data(pojo);
        pojo=new ContactPojo((id++),"devv","8979221199");
        databaseAdapter.insert_data(pojo);

        List<ContactPojo> list=databaseAdapter.getAllTrainee();

        StringBuilder stringBuilder=new StringBuilder();
        for(ContactPojo p:list){
            stringBuilder.append(p.getId()+","+p.getName()+","+p.getNumber()+"\n");
        }
        Log.w("DATA",""+stringBuilder);
    }
}
