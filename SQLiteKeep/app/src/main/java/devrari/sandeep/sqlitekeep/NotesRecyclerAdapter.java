package devrari.sandeep.sqlitekeep;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 5/4/18.
 */

class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.NotesHolder> {
    private Context context;
    private List<GetterSetterNotes>list;
    private NotesDatabaseAdapter notesDatabaseAdapter;

    NotesRecyclerAdapter(Context context,NotesDatabaseAdapter db) {
        this.context = context;
        this.notesDatabaseAdapter=db;
        this.list = notesDatabaseAdapter.getterSetterNotesAll();
        Log.w("Adapter Constructor","Size: "+list.size());
    }

    @Override
    public NotesRecyclerAdapter.NotesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.layout_notes_view,parent,false);
        NotesHolder notesHolder=new NotesHolder(view);
        Log.w("Adapter view","Size: "+list.size());
        return notesHolder;
    }

    @Override
    public void onBindViewHolder(NotesRecyclerAdapter.NotesHolder holder, int position) {
        GetterSetterNotes notes=list.get(position);
        holder.title.setText(notes.getTitle());
        holder.msg.setText(notes.getMsg());
        Log.w("Adapter bind","Size: "+list.size());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotesHolder extends RecyclerView.ViewHolder {
        private TextView title,msg;
        private ImageButton deleteBT,reminderBT,colorBT,addImageBT,cameraBT;
        public NotesHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.notesViewTitle);
            msg=itemView.findViewById(R.id.notesViewMsg);
            itemView.setOnGenericMotionListener(new View.OnGenericMotionListener() {
                @Override
                public boolean onGenericMotion(View v, MotionEvent event) {
                    deleteBT.setVisibility(View.VISIBLE);
                    return true;
                }
            });

            deleteBT=itemView.findViewById(R.id.notes_toolbar_2_delete);
            reminderBT=itemView.findViewById(R.id.notes_toolbar_2_remind);
            colorBT=itemView.findViewById(R.id.notes_toolbar_2_change_color);
            addImageBT=itemView.findViewById(R.id.notes_toolbar_2_add_image);
            cameraBT=itemView.findViewById(R.id.notes_toolbar_2_camera_image);

            deleteBT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //
                }
            });
        }
    }
    public void addNewNote(GetterSetterNotes note){
        long i=notesDatabaseAdapter.insert_notes(note);
        int pos=note.getId();
        note.setId((int)(i));
        list.clear();
        list = notesDatabaseAdapter.getterSetterNotesAll();
        //notifyDataSetChanged();
        notifyItemInserted(pos+1);
    }
}
