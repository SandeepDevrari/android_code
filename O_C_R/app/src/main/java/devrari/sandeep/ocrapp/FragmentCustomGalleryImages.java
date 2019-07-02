package devrari.sandeep.ocrapp;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import devrari.sandeep.ocrapp.pojo_classes.FoldersWithImagesGETSET;

/**
 * Created by Angry on 4/15/2018.
 */

public class FragmentCustomGalleryImages extends Fragment {
    private TextView noImages;
    private RecyclerView recyclerView;
    private View fragmentRootView;
    private Context context;
    private List<FoldersWithImagesGETSET>list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentRootView=inflater.inflate(R.layout.fragment_layout_custom_gallery_images,container,false);
        return fragmentRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        noImages=fragmentRootView.findViewById(R.id.custom_gallery_grid_no_images_found);
        recyclerView=fragmentRootView.findViewById(R.id.custom_gallery_recyclerview_folders);
        recyclerView.setLayoutManager(new GridLayoutManager(context,4,GridLayoutManager.VERTICAL,false));

    }

    public void setContext(Context context) {
        this.context = context;
    }
    private List<FoldersWithImagesGETSET> galleryImagesWithFolders(){
        final String[] columns={MediaStore.Images.Media.DATA,
                                MediaStore.Images.Media._ID};
        final String order=MediaStore.Images.Media.DATE_TAKEN;

        Cursor imaegsCursor=getActivity().managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,columns,null,null,order+" DESC");
        //list= Utils.getAllDirectoriesWithImages(imaegsCursor);
        return null;
    }
}
