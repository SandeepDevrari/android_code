package devrari.sandeep.googletraining;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 27/3/18.
 */

class CustomRecyclerClass extends RecyclerView.Adapter<CustomRecyclerClass.CustomHolderClass> {
    private ArrayList<EmployeeOfRV> allEmpDataOfRv;
    private EmployeeOfRV ofRV;
    private Context contex;

    CustomRecyclerClass(ArrayList<EmployeeOfRV> allEmpDataOfRv, Context contex) {
        this.allEmpDataOfRv = allEmpDataOfRv;
        this.contex = contex;
    }

    @Override
    public CustomHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(contex);
        View view=layoutInflater.inflate(R.layout.layout_base_adapter_custom,parent,false);
        return new CustomHolderClass(view);
    }

    @Override
    public void onBindViewHolder(CustomHolderClass holder, int position) {
        ofRV=allEmpDataOfRv.get(position);
        holder.name.setText(ofRV.getFirstName());
        holder.experience.setText(ofRV.getExperience());
        holder.jobTitle.setText(ofRV.getJobTitle());
    }

    @Override
    public int getItemCount() {
        return allEmpDataOfRv.size();
    }

    public class CustomHolderClass extends RecyclerView.ViewHolder {
        TextView name,experience,jobTitle;
        public CustomHolderClass(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.baseTextName);
            experience=itemView.findViewById(R.id.baseTextExperience);
            jobTitle=itemView.findViewById(R.id.baseTextJob);
        }
    }
}
