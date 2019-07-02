package devrari.sandeep.googletraining;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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


/**
 * Created by user on 16/4/18.
 */

class FoldersAdapter extends RecyclerView.Adapter<FoldersAdapter.FolderHolder> {
    private Context context;
    private List<CustomGalleryGETSET>list;
    private FragmentManager fragmentManager;

    FoldersAdapter(Context context, List<CustomGalleryGETSET> list,FragmentManager fragmentManager) {
        this.context = context;
        this.list = list;
        this.fragmentManager=fragmentManager;
    }

    @Override
    public FolderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.layout_folders_images,parent,false);
        return new FolderHolder(view);
    }

    @Override
    public void onBindViewHolder(FolderHolder holder, int position) {
        CustomGalleryGETSET getset=list.get(position);
        holder.folderName.setText(getset.getFolderName());
        final TreeSet<String> treeSet=getset.getFolderImages();
        Glide.with(context).load("file://"+treeSet.first()).placeholder(R.drawable.beauty_icon).crossFade().into(holder.folderImage);
        if(!holder.hasListener){
            View.OnClickListener imageListener=new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    FragmentFolderAllImages folderAllImages=new FragmentFolderAllImages();
                    ArrayList<String> arrayList=new ArrayList<>(treeSet);
                    Bundle bundle=new Bundle();
                    bundle.putStringArrayList("AllImagesAreHere",arrayList);
                    folderAllImages.setArguments(bundle);
                    fragmentTransaction.replace(R.id.open_custom_gallery_here,folderAllImages);
                    fragmentTransaction.commit();
                }
            };
            holder.folderImage.setOnClickListener(imageListener);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FolderHolder extends RecyclerView.ViewHolder {
        ImageView folderImage;
        TextView folderName;
        boolean hasListener;
        public FolderHolder(View itemView) {
            super(itemView);
            folderImage=itemView.findViewById(R.id.folderImages_Image);
            folderName=itemView.findViewById(R.id.folderImages_Name);
            hasListener=false;
        }
    }
}
