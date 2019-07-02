package devrari.sandeep.angry.rvtrain;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivitySimpleListView extends AppCompatActivity {

    AlertDialog alertDialog=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        ListView listview=findViewById(R.id.simpleListView_1);
        HandleData hh=new HandleData();
        //String[] name=new String[]{"ABC","BCD","DEF"};
        Log.i("**********************",""+(hh.getListOf()).get(2).getName());
        AdapterForSimpleList adapterForSimpleList=new AdapterForSimpleList(this,hh.getListOf());
        listview.setAdapter(adapterForSimpleList);
        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        //listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(ActivitySimpleListView.this);

                builder.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog=builder.create();
                alertDialog.setTitle("List Item");
                alertDialog.setMessage((parent.getItemAtPosition(position).getClass()).getName());
                alertDialog.show();
                alertDialog.setCancelable(false);
            }
        });
    }
    private class HandleData{
        int[] img;
        ArrayList<GetterSetterClass> listOf;
        String[] name;
        GetterSetterClass tempGetter;
        HandleData(){
            img=new int[]{R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
            name=new String[]{"ABC","BCD","DEF","ABC","BCD","DEF"};
            listOf=new ArrayList<>();
            for(int i=0;i<img.length;i++){
                tempGetter=new GetterSetterClass(img[i],name[i]);
                listOf.add(tempGetter);
            }

        }
        public int[] getImg(){
            return this.img;
        }
        public String[] getName(){
            return this.name;
        }
        public ArrayList<GetterSetterClass> getListOf(){
            return  this.listOf;
        }
    }
}
