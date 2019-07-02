package devrari.sandeep.angry.rvtrain;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Angry on 4/3/2018.
 */

public class CustomGridViewBase extends BaseAdapter {
    Context context;
    int[] images;
    CustomGridViewBase(Context context,int[] images){
        this.context=context;
        this.images=images;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView==null){
            imageView=new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(85,80));
            imageView.setPadding(5,5,5,5);
        }
        else{
            imageView=(ImageView) convertView;
        }
        imageView.setImageResource(images[position]);
        return imageView;
    }
}
