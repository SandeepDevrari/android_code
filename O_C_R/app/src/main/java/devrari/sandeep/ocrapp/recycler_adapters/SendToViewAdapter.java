package devrari.sandeep.ocrapp.recycler_adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;
import java.util.List;

import devrari.sandeep.ocrapp.R;

/**
 * Created by Angry on 5/6/2018.
 */

public class SendToViewAdapter extends RecyclerView.Adapter<SendToViewAdapter.ViewHolderClass> {
    private List<String>list;
    private Context context;

    public SendToViewAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderClass(LayoutInflater.from(context).inflate(R.layout.layout_send_to_view_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolderClass holder, int position) {
        Glide.with(context).load(list.get(position))
                .placeholder(R.drawable.ic_open_gallery)
                .centerCrop()
                .crossFade()
                .into(holder.imageView);
        String s=list.get(position);
        holder.textView.setText(readerImage(s));//s.substring(s.lastIndexOf("/"))
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolderClass(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.sendToCardViewImageName);
            imageView=itemView.findViewById(R.id.sendToCardViewImageView);
        }
    }
    public String readerImage(String path){
        Log.w("File path ",""+path);
        Bitmap bitmapImage= null;
        bitmapImage = BitmapFactory.decodeFile(path);
        StringBuilder stringBuilder=new StringBuilder();
        if(bitmapImage!=null){
            TextRecognizer textRecognizer=new TextRecognizer.Builder(context).build();
            if(!textRecognizer.isOperational()){
                Log.w("TextRecognizer","text recognizwer is not operational!!");
                return "Unable to read image text!!";
            }

            Frame frame=new Frame.Builder().setBitmap(bitmapImage).build();

            SparseArray<TextBlock> textBlockSparseArray=textRecognizer.detect(frame);

            for(int i=0;i<textBlockSparseArray.size();i++){
                TextBlock textBlock=textBlockSparseArray.get(textBlockSparseArray.keyAt(i));
                List<? extends com.google.android.gms.vision.text.Text> listText=textBlock.getComponents();
                for(com.google.android.gms.vision.text.Text text:listText){
                    stringBuilder.append(text.getValue());
                    //textView.setText(textView.getText().toString()+"\n"+text.getValue());
                }
            }
        }
        return stringBuilder.toString();
    }
}
