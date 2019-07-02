package devrari.sandeep.googletraining;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 30/3/18.
 */

class TempAdapterRecycle extends RecyclerView.Adapter<TempAdapterRecycle.TempHolderRecycler> {
    private ArrayList<GetterSetterTempRecycle>totals;
    private Context context;
    private GetterSetterTempRecycle tempGetter;

    TempAdapterRecycle(Context context,ArrayList<GetterSetterTempRecycle> totals) {
        this.totals = totals;
        this.context=context;
    }

    @Override
    public TempHolderRecycler onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater lay=LayoutInflater.from(context);
        View view=lay.inflate(R.layout.layout_temp_recycler,parent,false);
        return new TempHolderRecycler(view);
    }

    @Override
    public void onBindViewHolder(TempHolderRecycler holder, int position) {
        tempGetter=totals.get(position);
        holder.imageView.setImageResource(tempGetter.getImage());
        holder.textView.setText(tempGetter.getName());
    }

    @Override
    public int getItemCount() {
        return totals.size();
    }

    public class TempHolderRecycler extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public TempHolderRecycler(View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.tempRecycleImage);
            textView=itemView.findViewById(R.id.tempRecycletext);
        }
    }
}
