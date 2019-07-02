package com.example.angry.testreminder.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.angry.testreminder.PojoClassTask;
import com.example.angry.testreminder.R;
import com.example.angry.testreminder.database.DatabaseAdapter;

import java.util.ArrayList;

/**
 * Created by Angry on 6/5/2018.
 */

public class RecyclerAdapterHere extends RecyclerView.Adapter<RecyclerAdapterHere.HolderClass>{

    private ArrayList<PojoClassTask>arrayList;
    private Context context;
    public RecyclerAdapterHere(Context context){
        this.context=context;
        DatabaseAdapter databaseAdapter=DatabaseAdapter.getDatabaseAdapter(context);
        arrayList=new ArrayList<>();
        Cursor c=databaseAdapter.getTask();
        while(c.moveToNext()){
            String msg=c.getString(0);
            PojoClassTask pojoClassTask=new PojoClassTask(msg,"");
            arrayList.add(pojoClassTask);
        }
    }
    @Override
    public HolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.layout_remindertask,parent,false);
        return new HolderClass(view);
    }

    @Override
    public void onBindViewHolder(HolderClass holder, int position) {
        PojoClassTask pojoClassTask=arrayList.get(position);
        holder.textView.setText(pojoClassTask.getMsg());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HolderClass extends RecyclerView.ViewHolder {
        TextView textView;
        public HolderClass(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.taskMsg);
        }
    }
}
