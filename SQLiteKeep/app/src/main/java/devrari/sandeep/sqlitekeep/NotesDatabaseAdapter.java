package devrari.sandeep.sqlitekeep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/4/18.
 */

public class NotesDatabaseAdapter {
    private static final String DB_NAME="notes.db";
    private static final int DB_VERSION=1;

    private static final String TABLE_ONE_NAME="all_notes_here";
    private static final String TABLE_ONE_COLUMN_ONE="id";
    private static final String TABLE_ONE_COLUMN_TWO="title";
    private static final String TABLE_ONE_COLUMN_THREE="message";
    private static final String TABLE_ONE_COLUMN_FOURE="time_stamp";

    private static final String TABLE_ONE_QUERY="create table "+TABLE_ONE_NAME+"("+TABLE_ONE_COLUMN_ONE+" integer primary key autoincrement,"+TABLE_ONE_COLUMN_TWO+" text,"+TABLE_ONE_COLUMN_THREE+" text,"+TABLE_ONE_COLUMN_FOURE+" datetime default current_timestamp)";

    private Context context;
    private static NotesDatabaseAdapter notesAdapter;
    private NotesHelper notesHelper;

    public NotesDatabaseAdapter(Context context) {
        this.context = context;
        this.notesHelper = new NotesHelper(context,TABLE_ONE_NAME,null,DB_VERSION);
    }

    public static NotesDatabaseAdapter getNotesAdapter(Context context) {
        if(notesAdapter==null){
            notesAdapter=new NotesDatabaseAdapter(context);
        }
        return notesAdapter;
    }

    public long insert_notes(GetterSetterNotes note){
        ContentValues contentValues=new ContentValues();
        contentValues.put(TABLE_ONE_COLUMN_TWO,note.getTitle());
        contentValues.put(TABLE_ONE_COLUMN_THREE,note.getMsg());
        SQLiteDatabase database=notesHelper.getWritableDatabase();
        long i=database.insert(TABLE_ONE_NAME,null,contentValues);
        if(i>0){
            Log.w("data inserted",note.getTitle()+" "+note.getMsg());
        }
        database.close();
        return  i;
    }

    public void delete_note(GetterSetterNotes note){
        String[] str={String.valueOf(note.getId())};
        SQLiteDatabase database=notesHelper.getWritableDatabase();
        database.delete(TABLE_ONE_NAME,TABLE_ONE_COLUMN_ONE+"= ?",str);
        Log.w("data","deleted");
        database.close();
    }

    public void update_note(GetterSetterNotes note){
        ContentValues contentValues=new ContentValues();
        contentValues.put(TABLE_ONE_COLUMN_TWO,note.getTitle());
        contentValues.put(TABLE_ONE_COLUMN_THREE,note.getMsg());
        String[] str={String.valueOf(note.getId())};
        SQLiteDatabase database=notesHelper.getWritableDatabase();
        database.update(TABLE_ONE_NAME,contentValues,TABLE_ONE_COLUMN_ONE+"=?",str);
        database.close();
    }

    public GetterSetterNotes getterSetterNotesById(long id){
        SQLiteDatabase database=notesHelper.getReadableDatabase();
        String[] columns={TABLE_ONE_COLUMN_ONE,TABLE_ONE_COLUMN_TWO,
                TABLE_ONE_COLUMN_THREE,TABLE_ONE_COLUMN_FOURE};
        String[] where={String.valueOf(id)};
        Cursor cursor=database.query(TABLE_ONE_NAME,columns,TABLE_ONE_COLUMN_ONE+"=?",
                where,null,null,null);
        GetterSetterNotes getterSetterNotes=null;
        if(cursor!=null){
            cursor.moveToNext();
            getterSetterNotes=new GetterSetterNotes(cursor.getInt(cursor.getColumnIndex(TABLE_ONE_COLUMN_ONE)),
                    cursor.getString(cursor.getColumnIndex(TABLE_ONE_COLUMN_TWO)),
                    cursor.getString(cursor.getColumnIndex(TABLE_ONE_COLUMN_THREE)),
                    cursor.getString(cursor.getColumnIndex(TABLE_ONE_COLUMN_FOURE)));
        }
        cursor.close();
        return getterSetterNotes;
    }

    public List<GetterSetterNotes> getterSetterNotesAll(){
        List<GetterSetterNotes> list=new ArrayList<>();
        SQLiteDatabase database=notesHelper.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from "+TABLE_ONE_NAME+" order by "+TABLE_ONE_COLUMN_FOURE,null);
        GetterSetterNotes getterSetterNotes;
        while(cursor.moveToNext()){
            getterSetterNotes=new GetterSetterNotes(cursor.getInt(cursor.getColumnIndex(TABLE_ONE_COLUMN_ONE)),
                    cursor.getString(cursor.getColumnIndex(TABLE_ONE_COLUMN_TWO)),
                    cursor.getString(cursor.getColumnIndex(TABLE_ONE_COLUMN_THREE)),
                    cursor.getString(cursor.getColumnIndex(TABLE_ONE_COLUMN_FOURE)));
            list.add(getterSetterNotes);
        }
        cursor.close();
        database.close();
        Log.i("all","All read");
        return list;
    }

    public int getterSetterCount(){
        SQLiteDatabase database=notesHelper.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from "+TABLE_ONE_NAME,null);
        int i=cursor.getCount();
        return i;
    }

    private static class NotesHelper extends SQLiteOpenHelper{
        public NotesHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_ONE_QUERY);
            Log.i("DATABASE","table created!!");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists "+TABLE_ONE_NAME);
            onCreate(db);
            Log.w("DATABASE","Re created");
        }
    }
}
