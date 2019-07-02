 package devrari.sandeep.ocrapp.recycler_adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;
import java.util.List;

import devrari.sandeep.ocrapp.R;
import devrari.sandeep.ocrapp.pojo_classes.GetndSet;

 /**
 * Created by user on 10/4/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterHolder> {
    private Context context;
    private List<GetndSet>lists;
    public RecyclerAdapter(Context context, List<GetndSet> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdapterHolder(LayoutInflater.from(context).inflate(R.layout.layout_card_view_ocr,parent,false));
    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, final int position) {
        final Uri thisImageURI=(lists.get(position)).getPathUri();
        Glide.with(context).load(thisImageURI).into(holder.imageView);
        if(!holder.isClickableImage){
            View.OnClickListener listener=new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //StringBuilder builder=readerImage(thisImageURI);
                    //Log.w("image clicked",""+builder);
                }
            };
            holder.imageView.setOnClickListener(listener);
//            holder.isClickableImage=true;
//            setViewImageListner(holder.imageView,position);
        }
    }
    private void setViewImageListner(ImageView imageView,final int pos){
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder=readerImage((lists.get(pos).getPathUri()));
                Log.w("image clicked",""+builder);
            }
        };
        imageView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        boolean isClickableImage=false;
        public AdapterHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.cardImage);
            //imageView.setOnClickListener(clickListener);
        }
    }
    public StringBuilder readerImage(Uri uri){
        Log.w("File URI ",""+uri);
        Bitmap bitmapImage= null;
        try {
            bitmapImage = MediaStore.Images.Media.getBitmap(context.getContentResolver(),uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder=new StringBuilder();
        if(bitmapImage!=null){
            TextRecognizer textRecognizer=new TextRecognizer.Builder(context).build();
            if(!textRecognizer.isOperational()){
                Log.w("TextRecognizer","text recognizwer is not operational!!");
            }

            Frame frame=new Frame.Builder().setBitmap(bitmapImage).build();

            SparseArray<TextBlock>textBlockSparseArray=textRecognizer.detect(frame);

            for(int i=0;i<textBlockSparseArray.size();i++){
                TextBlock textBlock=textBlockSparseArray.get(textBlockSparseArray.keyAt(i));
                List<? extends com.google.android.gms.vision.text.Text> listText=textBlock.getComponents();
                for(com.google.android.gms.vision.text.Text text:listText){
                    stringBuilder.append(text.getValue());
                    //textView.setText(textView.getText().toString()+"\n"+text.getValue());
                }
            }
        }
        return stringBuilder;
    }
}
