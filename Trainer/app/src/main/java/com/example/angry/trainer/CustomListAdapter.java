package com.example.angry.trainer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Angry on 6/13/2018.
 */

public class CustomListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<PojoClassForCustomListView> arrayList;

    public CustomListAdapter(Context context, ArrayList<PojoClassForCustomListView> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderClassForList holderClassForList;
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.layout_cutom_view_list, parent, false);
            holderClassForList=new HolderClassForList(convertView);
            convertView.setTag(holderClassForList);
        }else{
            holderClassForList= (HolderClassForList) convertView.getTag();
        }
        PojoClassForCustomListView pojoClassForCustomListView=arrayList.get(position);
        holderClassForList.textView.setText(pojoClassForCustomListView.getTextView());
        holderClassForList.button.setText(pojoClassForCustomListView.getButton());
        return convertView;
    }
    private class HolderClassForList{
        TextView textView;
        Button button;
        HolderClassForList(View view){
            textView=view.findViewById(R.id.custom_text);
            button=view.findViewById(R.id.custombutton);
        }
    }
}
