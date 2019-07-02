package devrari.sandeep.angry.rvtrain;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class ActivityGridView extends AppCompatActivity {

    private GridView grid;
    private String[] str;
    private int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        grid=findViewById(R.id.gridView1);
        str=new String[]{"hello","this","is","no one"};
        images=new int[]{R.drawable.ic_clip,R.drawable.ic_clip,R.drawable.ic_clip,R.drawable.ic_clip,R.drawable.ic_clip,R.drawable.ic_clip};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);
        grid.setAdapter(arrayAdapter);
        //CustomGridViewBase customGridViewBase=new CustomGridViewBase(this,images);
        //grid.setAdapter(customGridViewBase);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(ActivityGridView.this);
                final AlertDialog alertDialog=builder.create();
                alertDialog.setTitle("List Item");
                alertDialog.setMessage(parent.getItemAtPosition(position).toString());
                builder.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
    }
}
