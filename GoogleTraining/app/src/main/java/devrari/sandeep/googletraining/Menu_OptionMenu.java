package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Menu_OptionMenu extends AppCompatActivity {

    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__option_menu);
        et1=findViewById(R.id.contextMenuET1);
        et2=findViewById(R.id.contextMenuET2);
        registerForContextMenu(et1);
        registerForContextMenu(et2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_actions,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.optionNow:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_say:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_okay:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.contextMenuET1:
                getMenuInflater().inflate(R.menu.context_menu_et1,menu);
                break;
            case R.id.contextMenuET2:
                getMenuInflater().inflate(R.menu.context_menu_et2,menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.contextMenu_item1:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextMenu_item2:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
