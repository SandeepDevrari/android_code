package devrari.sandeep.angry.rvtrain;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Angry on 3/28/2018.
 */

class AdapterForSimpleList extends BaseAdapter {
    ArrayList<GetterSetterClass>listOf;
    Context context;
    LayoutInflater lay;
    AdapterForSimpleList(Context context, ArrayList<GetterSetterClass> listOf){
        this.context=context;
        this.listOf=listOf;
        Log.i("*****#################",""+listOf.get(2).getName());
    }

    @Override
    public int getCount() {
        return listOf.size();
    }

    @Override
    public Object getItem(int position) {
        return listOf.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        lay=LayoutInflater.from(this.context);
        Log.i("$$$$$$$$$$$$$$$4","HELL");
        GetterSetterClass temp=listOf.get(position);
        //Log.i("@@@@@@@@@@@@@@@@@2",""+temp.getName());
        convertView=lay.inflate(R.layout.custom_layout_simple_listview,null);
        ((ImageView)convertView.findViewById(R.id.customListImageView)).setImageResource(temp.getImage());
        ((TextView)convertView.findViewById(R.id.customListViewTextView)).setText(temp.getName());
        Log.w("%%%%%%%%%%%%%%%%%%%%%","View "+position);
        return convertView;
    }
}
