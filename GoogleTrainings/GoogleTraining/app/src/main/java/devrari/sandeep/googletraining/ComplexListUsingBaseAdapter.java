package devrari.sandeep.googletraining;

import android.content.Context;
import android.support.v4.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;


/**
 * Created by user on 27/3/18.
 */

class ComplexListUsingBaseAdapter extends BaseAdapter {

    private ArrayList<EmployeeOfRV> employeeOfRVS;
    private Context context;
    private Set<View> setView_Object;
    private EmployeeHolder holderClass;

    ComplexListUsingBaseAdapter(ArrayList<EmployeeOfRV> employeeOfRVS, Context context) {
        this.employeeOfRVS = employeeOfRVS;
        this.context = context;
        setView_Object=new ArraySet<>();
    }

    @Override
    public int getCount() {
        return employeeOfRVS.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeOfRVS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){//only create once inflator
            LayoutInflater inflaterLayout=LayoutInflater.from(context);
            convertView=inflaterLayout.inflate(R.layout.layout_base_adapter_custom,parent,false);
            holderClass=new EmployeeHolder();
            holderClass.Name=(TextView)convertView.findViewById(R.id.baseTextName);
            holderClass.Experience=(TextView)convertView.findViewById(R.id.baseTextExperience);
            holderClass.Job=(TextView)convertView.findViewById(R.id.baseTextJob);
            convertView.setTag(holderClass);
        }
        else{
            //only once the holder class will created
            holderClass=(EmployeeHolder) convertView.getTag();
        }
//        LayoutInflater inflaterLayout=LayoutInflater.from(context);//creating each time a new inflator
//        convertView=inflaterLayout.inflate(R.layout.layout_base_adapter_custom,parent,false);
        EmployeeOfRV employeeRv=employeeOfRVS.get(position);


        //Binding(Linking ) the data to view only once
        holderClass.Name.setText(employeeRv.getFirstName());
        holderClass.Experience.setText(employeeRv.getExperience());
        holderClass.Job.setText(employeeRv.getJobTitle());
//        ((TextView)convertView.findViewById(R.id.baseTextName)).setText(employeeRv.getFirstName());//bindling view with data every time
//        ((TextView)convertView.findViewById(R.id.baseTextExperience)).setText(employeeRv.getExperience());
//        ((TextView)convertView.findViewById(R.id.baseTextJob)).setText(employeeRv.getJobTitle());

        setView_Object.add(convertView);
        Log.e("****BaseAdapterView*****index: "+position,"size: "+setView_Object.size());
        return convertView;
    }


    //to hold the view
    private static class EmployeeHolder{
        TextView Name,Experience,Job;
    }
}
