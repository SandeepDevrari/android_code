package devrari.sandeep.googletraining.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import devrari.sandeep.googletraining.R;

/**
 * Created by user on 17/4/18.
 */

public class FolderAllImagesAdapter extends RecyclerView.Adapter<FolderAllImagesAdapter.AllImagesHolder> {
    private List<String>list;
    private Context context;
    private boolean isLongPressed=false;
    private Button done;
    //private AllImagesHolder.HolderAllImagesInterface allImagesInterface;

    public FolderAllImagesAdapter(List<String> list, Context context, Button button){//, AllImagesHolder.HolderAllImagesInterface allImagesInterface) {
        this.list = list;
        this.context = context;
        this.done=button;
        //this.allImagesInterface=allImagesInterface;
    }

    @Override
    public AllImagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.layout_folder_all_images_adapter,parent,false);
        return new AllImagesHolder(view);//,allImagesInterface);
    }

    @Override
    public void onBindViewHolder(AllImagesHolder holder, int position) {
        Glide.with(context).load(list.get(position))
                .placeholder(R.drawable.beauty_icon)
                .centerCrop()
                .crossFade()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class AllImagesHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        ImageView imageView;
        ImageView imageView2;
        //HolderAllImagesInterface allImagesInterface;
        public AllImagesHolder(View itemView){//,HolderAllImagesInterface allImagesInterface) {
            super(itemView);
            imageView=itemView.findViewById(R.id.folderAllImages_Image);
            imageView2=itemView.findViewById(R.id.folderAllImages_Image2);
            imageView2.setEnabled(false);
            //this.allImagesInterface=allImagesInterface;
            imageView.setOnClickListener(this);
            imageView.setOnLongClickListener(this);
//            imageView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    isLongPressed=true;
//                    imageView2.setVisibility(View.VISIBLE);
//                    imageView2.setEnabled(true);
//                    return true;
//                }
//            });
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(isLongPressed){
//                        if(!imageView2.isEnabled()) {
//                            imageView2.setVisibility(View.VISIBLE);
//                            imageView2.setEnabled(true);
//                        }
//                        else{
//                            imageView2.setVisibility(View.INVISIBLE);
//                            imageView2.setEnabled(false);
//                        }
//                    }
//                }
//            });
        }

        @Override
        public void onClick(View v) {
            //allImagesInterface.onImageClick(v,getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            //allImagesInterface.onImageLongClick(v,getAdapterPosition());
            return true;
        }

//        public interface HolderAllImagesInterface {
//            void onImageClick(View v ,int position);
//            void onImageLongClick(View v ,int position);
//        }

    }
}
