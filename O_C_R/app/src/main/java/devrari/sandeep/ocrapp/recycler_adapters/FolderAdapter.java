package devrari.sandeep.ocrapp.recycler_adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import devrari.sandeep.ocrapp.ActivityCustomGalleryFolderImages;
import devrari.sandeep.ocrapp.R;
import devrari.sandeep.ocrapp.pojo_classes.FoldersWithImagesGETSET;

/**
 * Created by Angry on 4/16/2018.
 */


public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.FolderHolder> {
    private Context context;
    private List<FoldersWithImagesGETSET>list;
    private FolderViewCallback folderViewCallback;

    public FolderAdapter(Context context, List<FoldersWithImagesGETSET> list, FolderViewCallback folderViewCallback) {
        this.context = context;
        this.list = list;
        this.folderViewCallback=folderViewCallback;
    }

    @Override
    public FolderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.layout_folder_images,parent,false);
        return new FolderHolder(view,folderViewCallback);
    }

    @Override
    public void onBindViewHolder(FolderHolder holder, int position) {
        FoldersWithImagesGETSET getset=list.get(position);
        holder.folderName.setText(getset.getFolderName());
        final TreeSet<String> treeSet=getset.getFolderImages();
        Glide.with(context).load("file://"+treeSet.first()).placeholder(R.drawable.text).centerCrop().crossFade().into(holder.folderImage);

// if(!holder.hasListener){
//            View.OnClickListener imageListener=new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    ArrayList<String> arrayList=new ArrayList<>(treeSet);
//                    Bundle bundle=new Bundle();
//                    bundle.putStringArrayList("AllImagesAreHere",arrayList);
//                    Intent intent=new Intent(context,ActivityCustomGalleryFolderImages.class);
//                    intent.putExtras(bundle);
//                    context.startActivity(intent);
//                }
//            };
//            holder.folderImage.setOnClickListener(imageListener);
        //}
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class FolderHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView folderImage;
        TextView folderName;
        //boolean hasListener;
        FolderViewCallback folderViewCallback;
        public FolderHolder(View itemView,FolderViewCallback folderViewCallback) {
            super(itemView);
            folderImage=itemView.findViewById(R.id.folderImageHere);
            folderName=itemView.findViewById(R.id.folderName);
            this.folderViewCallback=folderViewCallback;
            //hasListener=false;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
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

//        public interface FolderViewCallback{
//            void onViewImageClick(View v,int position);
//            void onViewImageLongClick(View v,int position);
//        }
    }
}