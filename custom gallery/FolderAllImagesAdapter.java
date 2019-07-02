package devrari.sandeep.googletraining;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by user on 17/4/18.
 */

class FolderAllImagesAdapter extends RecyclerView.Adapter<FolderAllImagesAdapter.AllImagesHolder> {
    private List<String>list;
    private Context context;

    FolderAllImagesAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public AllImagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.layout_folder_all_images_adapter,parent,false);
        return new AllImagesHolder(view);
    }

    @Override
    public void onBindViewHolder(AllImagesHolder holder, int position) {
        Glide.with(context).load(list.get(position))
                .placeholder(R.drawable.beauty_icon)
                .crossFade()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AllImagesHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public AllImagesHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.folderAllImages_Image);
        }
    }
}
