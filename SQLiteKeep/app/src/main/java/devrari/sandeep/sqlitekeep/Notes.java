package devrari.sandeep.sqlitekeep;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Notes extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ConstraintSet set1=new ConstraintSet();
    private ConstraintSet set2=new ConstraintSet();
    private boolean onTakeNote_Done;
    private ConstraintLayout root;
    private NotesRecyclerAdapter notesRecyclerAdapter;
    private  TextView text;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        context=getApplicationContext();
        root=findViewById(R.id.notesMainLayout);
        text=findViewById(R.id.notesNoNotes);
        set2.clone(this,R.layout.activity_notes_2);
        set1.clone(root);
        onTakeNote_Done=false;

        recyclerView=findViewById(R.id.notesRecycler);
        NotesDatabaseAdapter notesDatabaseAdapter=new NotesDatabaseAdapter(this);
        notesRecyclerAdapter=new NotesRecyclerAdapter(this,notesDatabaseAdapter);
        if(notesRecyclerAdapter.getItemCount()>0){
            recyclerView.setVisibility(View.VISIBLE);
            text.setVisibility(View.INVISIBLE);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(notesRecyclerAdapter);

        TextView takeNote=findViewById(R.id.notes_toolbar_text);
        takeNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateMainLayout(v);
                if(notesRecyclerAdapter.getItemCount()>0){
                    recyclerView.setVisibility(View.VISIBLE);
                    text.setVisibility(View.INVISIBLE);
                }
                else {
                    recyclerView.setVisibility(View.INVISIBLE);
                    text.setVisibility(View.VISIBLE);
                }
                //notesRecyclerAdapter.notifyDataSetChanged();
            }
        });

        final EditText toolbar_title=findViewById(R.id.notes_toolbar_2_title);
        final EditText toolbar_msg=findViewById(R.id.notes_toolbar_2_msg);
        ImageButton done=findViewById(R.id.notes_toolbar_2_done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(context,v);
                String str=toolbar_msg.getText().toString();
                String ss=toolbar_title.getText().toString();
                if(!str.isEmpty()){
                    GetterSetterNotes getterSetterNotes=new GetterSetterNotes();//,,,"");
                    //Log.w("Data set Changed",""+notesRecyclerAdapter.getItemCount());
                    int p=notesRecyclerAdapter.getItemCount();
                    getterSetterNotes.setId(p-1);
                    getterSetterNotes.setTitle((ss.isEmpty()?"":ss));
                    getterSetterNotes.setMsg(str);
                    getterSetterNotes.setTime("");
                    notesRecyclerAdapter.addNewNote(getterSetterNotes);
                    recyclerView.scrollToPosition(p);
//                    long i=notesDatabaseAdapter.insert_notes(getterSetterNotes);
//                    getterSetterNotes.setId((int)(i));
                    //Log.w("Adapter Checker",""+(notesRecyclerAdapter==null?false:true));
//                    notesRecyclerAdapter=new NotesRecyclerAdapter(Notes.this,notesDatabaseAdapter.getterSetterNotesAll());
//                    recyclerView.setAdapter(notesRecyclerAdapter);
                    //notesRecyclerAdapter.notifyDataSetChanged();
                    //Log.w("Data set Changed",""+notesRecyclerAdapter.getItemCount());
                    //recyclerView.scrollToPosition(notesRecyclerAdapter.getItemCount());
                }
                toolbar_title.setText("");
                toolbar_msg.setText("");
                animateMainLayout(v);
                if(notesRecyclerAdapter.getItemCount()>0){
                    Log.w("visiblity ","On");
                    recyclerView.setVisibility(View.VISIBLE);
                    text.setVisibility(View.INVISIBLE);
                }
                else {
                    Log.w("visiblity ","Off");
                    recyclerView.setVisibility(View.INVISIBLE);
                    text.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_search_bar,menu);
        SearchManager searchManager=(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView=(SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }
    private void setAdapterToRecycler(){

    }

    public void animateMainLayout(View view) {
        TransitionManager.beginDelayedTransition(root);
        if(onTakeNote_Done){
            set1.applyTo(root);
            //setAdapterToRecycler();
        }
        else{
            set2.applyTo(root);
            //setAdapterToRecycler();
        }
        onTakeNote_Done=!onTakeNote_Done;
        //Log.i("value",""+onTakeNote_Done);
    }
    public static void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
