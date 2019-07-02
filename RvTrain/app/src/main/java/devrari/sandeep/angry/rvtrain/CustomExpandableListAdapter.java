package devrari.sandeep.angry.rvtrain;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Angry on 4/6/2018.
 */

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String>header;
    private HashMap<String,List<String>> child;

    public CustomExpandableListAdapter(Context context, List<String> header, HashMap<String, List<String>> child) {
        this.context = context;
        this.header = header;
        this.child = child;
    }

    @Override
    public int getGroupCount() {
        return header.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return (child.get(header.get(groupPosition))).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return child.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return (child.get(header.get(groupPosition))).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.layout_expandable_header,parent,false);
        }
        TextView textView=convertView.findViewById(R.id.expandable_header_text);
        textView.setTypeface(null, Typeface.BOLD_ITALIC);
        textView.setText(header.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.layout_expandable_child,parent,false);
        }
        TextView textView=convertView.findViewById(R.id.expandable_child_text);
        textView.setTypeface(null, Typeface.BOLD_ITALIC);
        textView.setText(child.get(header.get(groupPosition)).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
