package devrari.sandeep.googletraining;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 4/4/18.
 */

public class DatabaseAdapter {
    private static final String DB_Name="google_trainning";
    private static final int DB_Version=1;

    private static final String trainning_table_1="table_1";
    private static final String table_1_column_1="column_1";
    private static final String table_1_column_2="column_2";
    private static String table_1_query="create table "+trainning_table_1+"("+table_1_column_1+" integer primary key,"+table_1_column_2+" text not null"+")";
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private static DatabaseAdapter databaseAdapter;

    public DatabaseAdapter(Context context) {
        this.context = context;
        sqLiteDatabase=new DatabaseHelper(context,DB_Name,null,DB_Version).getWritableDatabase();
    }

    public static DatabaseAdapter getDatabaseAdapter(Context context) {
        if(databaseAdapter==null) {
            databaseAdapter = new DatabaseAdapter(context);
        }
        return databaseAdapter;
    }
    public boolean insert(String data1, String data2){
        sqLiteDatabase.execSQL("insert into "+trainning_table_1+"("+table_1_column_1+","+table_1_column_2+") values('"+data1+"','"+data2+"');");
        Log.i("Data","Data Inserted");
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(table_1_column_1,data1);
//        contentValues.put(table_1_column_2,data2);
//        return sqLiteDatabase.insert(trainning_table_1,null,contentValues)>0;
        return true;
    }
    public boolean delete(String data1){
        sqLiteDatabase.execSQL("delete from "+trainning_table_1+" where "+table_1_column_1+"='"+data1+"');");
        Log.i("Data","Data Deleted");
//        return sqLiteDatabase.delete(trainning_table_1,table_1_column_1+"="+data1,null)>0;
        return true;
    }
    public boolean update(String data1, String data2Modify){
        sqLiteDatabase.execSQL("update "+trainning_table_1+" set "+table_1_column_2+"='"+data2Modify+"'where "+table_1_column_1+"='"+data1+"')");
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(table_1_column_2,data2Modify);
//        return sqLiteDatabase.update(trainning_table_1,contentValues,table_1_column_1+"="+data1,null)>0;
        return true;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(table_1_query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table "+trainning_table_1);
        }

        @Override
        public void onConfigure(SQLiteDatabase db) {
            super.onConfigure(db);
            db.setForeignKeyConstraintsEnabled(true);
        }
    }
}
