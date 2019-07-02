package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AllMenusActivity extends AppCompatActivity {

    private TextView allText,allTextAction,allTextPop;
    private ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_menus);
        allText=findViewById(R.id.allMenuText);
        allText.setText("“I think you will find/When your death takes its toll/All the money you made/Will never buy back your soul…”\n" +
                "\n" +
                "The protest song to end all protest songs, Dylan voiced the concerns of a generation when he penned this anti-war lyric. With Vietnam raging, and conscription forcing young Americans to fight in a war they didn’t understand, the lyrics captured all of their rage, fear and disgust perfectly. Sung in the first person, from the point of view of a young man who doesn’t want to be forced to join the army, makes the song all the more personal. The melody here is so simple, and yet this song has been covered by more artists than you can count – it’s all thanks to those incredibly powerful lyrics.\n" +
                "\n");
        registerForContextMenu(allText);

        allTextAction=findViewById(R.id.allActionModeText);
        allTextAction.setText("“That’s great, it starts with an earthquake, birds and snakes…”");
        allTextPop=findViewById(R.id.allPopText);
        allTextPop.setText("Mah Nà Mah Nà");
        allTextAction.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(actionMode!=null){
                    return false; //if action mode is already activated then return false otherwise true.
                }
                actionMode=startSupportActionMode(actionModeCallback);
                return true;
            }
        });
        allTextPop.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popupMenu=new PopupMenu(AllMenusActivity.this,v);
                popupMenu.inflate(R.menu.all_popup_menu);
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.allPopUpCopy:
                                Toast.makeText(AllMenusActivity.this, "Copied Text", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.allPopUpPaste:
                                Toast.makeText(AllMenusActivity.this, "no Paste", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                return true;
            }
        });
    }
    private ActionMode.Callback actionModeCallback=new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.all_action_mode,menu);
            mode.setTitle("try");


            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            switch (item.getItemId()){
                case R.id.allActionModeCut:
                    Toast.makeText(AllMenusActivity.this, "cut", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.allActionModeEdit:
                    Toast.makeText(AllMenusActivity.this, "edit", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.allActionModeShare:
                    Toast.makeText(AllMenusActivity.this, "share", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode=null;
        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.all_menu_floting_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case R.id.allFlotingEdit:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.allFlotingShare:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.allFlotingDelete:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
