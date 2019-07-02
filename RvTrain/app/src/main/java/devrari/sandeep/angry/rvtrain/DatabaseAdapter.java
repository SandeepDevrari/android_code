package devrari.sandeep.angry.rvtrain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angry on 4/10/2018.
 */

public class DatabaseAdapter extends SQLiteOpenHelper {
    private static final String DB_NAME="rvtrain.db";
    private static  final int DB_VERSION=1;
    private static final String TABLE_NAME="trainee";
    private static final String COLUMN_ID="trainee_id";
    private static final String COLUMN_NAME="trainee_name";
    private static final String COLUMN_NUMBER="trainee_number";
    private static final String TABLE_QUERY="create table "
            +TABLE_NAME+"("+COLUMN_ID+" integer primary key not null, "+COLUMN_NAME+" text not null, "+COLUMN_NUMBER+" text not null);";
    private Context context;
    public DatabaseAdapter(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }

    public void insert_data(ContactPojo contactPojo){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_ID,contactPojo.getId());
        contentValues.put(COLUMN_NAME,contactPojo.getName());
        contentValues.put(COLUMN_NUMBER,contactPojo.getNumber());
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }
    public List<ContactPojo> getAllTrainee(){
        List<ContactPojo> list=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);
        while(cursor.moveToNext()){
            ContactPojo pojo=new ContactPojo(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)));
            list.add(pojo);
        }
        return list;
    }
}
