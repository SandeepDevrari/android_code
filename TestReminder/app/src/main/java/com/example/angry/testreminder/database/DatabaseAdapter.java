package com.example.angry.testreminder.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Angry on 6/5/2018.
 */

public class DatabaseAdapter {
    private static final String DB_NAME="task_reminder";
    private static final int DB_VERSION=1;

    private static final String TABLE_NAME="task_table";
    private static final String COL_1="task_id";
    private static final String COL_2="task_msg";
    private static final String COL_3="task_time";
    private static final String TABLE_QUERY="create table "+TABLE_NAME+"("+COL_1+" integer primery key,"+COL_2+" text not null,"+COL_3+" text )";

    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private static DatabaseAdapter databaseAdapter;

    public DatabaseAdapter(Context context){
        this.context=context;
        sqLiteDatabase=new Database_Helper(context,DB_NAME,null,DB_VERSION).getWritableDatabase();
    }
    public static DatabaseAdapter getDatabaseAdapter(Context context){
        if(databaseAdapter==null){
            databaseAdapter=new DatabaseAdapter(context);
        }
        return databaseAdapter;
    }

    public boolean insert(int data0,String data1, String data2){
        sqLiteDatabase.execSQL("insert into "+TABLE_NAME+"("+COL_1+","+COL_2+","+COL_3+") values('"+data0+"','"+data1+"','"+data2+"');");
        Log.i("Data","Data Inserted");
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(table_1_column_1,data1);
//        contentValues.put(table_1_column_2,data2);
//        return sqLiteDatabase.insert(trainning_table_1,null,contentValues)>0;
        return true;
    }
    public Cursor getTask(){
        Cursor c=sqLiteDatabase.query(TABLE_NAME,new String[]{COL_2,COL_3},null,null,null,null,null);
        return c;
    }

    private static class Database_Helper extends SQLiteOpenHelper {
        public Database_Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_QUERY);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //db.execSQL("drop table if exists"+TABLE_QUERY);
        }
    }
}
