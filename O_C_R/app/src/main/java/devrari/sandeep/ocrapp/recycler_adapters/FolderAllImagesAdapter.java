package devrari.sandeep.ocrapp.recycler_adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import devrari.sandeep.ocrapp.R;

/**
 * Created by Angry on 4/22/2018.
 */

public class FolderAllImagesAdapter extends RecyclerView.Adapter<FolderAllImagesAdapter.AllImagesHolder> {
    private List<String> list;
    private Context context;
    private FolderViewCallback folderViewCallback;

    public FolderAllImagesAdapter(List<String> list, Context context,FolderViewCallback folderViewCallback) {
        this.list = list;
        this.context = context;
        this.folderViewCallback=folderViewCallback;
    }

    @Override
    public AllImagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.layout_folder_all_images,parent,false);
        return new AllImagesHolder(view,folderViewCallback);
    }

    @Override
    public void onBindViewHolder(AllImagesHolder holder, int position) {
        Glide.with(context).load(list.get(position))
                .placeholder(R.drawable.ic_open_gallery)
                .centerCrop()
                .into(holder.imageView);//.crossFade()
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AllImagesHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        ImageView imageView,imageViewOther;
        FolderViewCallback folderViewCallback;
        public AllImagesHolder(View itemView,FolderViewCallback folderViewCallback) {
            super(itemView);
            imageView=itemView.findViewById(R.id.folderAllImageHere);
            //imageViewOther=itemView.findViewById(R.id.folderAllImageHereOther);
            //imageViewOther.setEnabled(false);
            this.folderViewCallback=folderViewCallback;
            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            folderViewCallback.onViewImageClick(v,getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            folderViewCallback.onViewImageLongClick(v,getAdapterPosition());
            return true;
        }
    }
}

