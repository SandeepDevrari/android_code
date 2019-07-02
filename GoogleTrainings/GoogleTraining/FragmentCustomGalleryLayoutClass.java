package devrari.sandeep.googletraining;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import devrari.sandeep.googletraining.gallery.CustomGalleryGETSET;
import devrari.sandeep.googletraining.gallery.FoldersAdapter;

/**
 * Created by user on 16/4/18.
 */

public class FragmentCustomGalleryLayoutClass extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{
    private RecyclerView recyclerView;
    private List<CustomGalleryGETSET> list;
    private String[] columns={MediaStore.Images.Media.DATA};//,MediaStore.Images.Media._ID};
    private String order=MediaStore.Images.Media.DATE_TAKEN;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_custom_gallery_layout,container,false);
        fragmentViewsLinker(view);
        return view;
    }

    private void fragmentViewsLinker(View view) {
        recyclerView=view.findViewById(R.id.custom_gallery_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(1,null,this);
        //getAllFoldersWithImages();
//        FoldersAdapter foldersAdapter=new FoldersAdapter(getContext(),list,getFragmentManager());
//        recyclerView.setAdapter(foldersAdapter);
    }

    private void getAllFoldersWithImages() {
        String[] columns={MediaStore.Images.Media.DATA};//,MediaStore.Images.Media._ID};
        String order=MediaStore.Images.Media.DATE_TAKEN;
        Cursor image_Cursor=getActivity().managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,columns,null,null,order);
        Map<String,CustomGalleryGETSET> mapImagesByFolders=getEverytingsFromCursor(image_Cursor);
        list=new ArrayList<>();
        for(Map.Entry<String,CustomGalleryGETSET> entry:mapImagesByFolders.entrySet()){
            Log.w("Folder Name- ",""+entry.getKey());
            CustomGalleryGETSET getset=entry.getValue();
            list.add(getset);
//            Log.w(""+getset.getFolderName(),"---->");
//            for(String t:getset.getFolderImages()){
//                Log.w("\t\t",t);
//            }
        }

    }
    private boolean isImage(String imagePath){
        String extentionImage=imagePath.substring(imagePath.lastIndexOf("."));
        if(extentionImage.equalsIgnoreCase(".jpeg")||extentionImage.equalsIgnoreCase(".jpg")||extentionImage.equalsIgnoreCase(".png")||extentionImage.equalsIgnoreCase(".bmp")){
            return true;
        }
        return false;
    }
    private Map<String,CustomGalleryGETSET> getEverytingsFromCursor(Cursor image_Cursor){
        Map<String,CustomGalleryGETSET>everythings=new HashMap<>();
        //list=new LinkedList<>();
        String imagesAddress,folderName,tempAddress;
        while(image_Cursor.moveToNext()){
            Log.w("cursor:"," "+image_Cursor.getString(image_Cursor.getColumnIndex(MediaStore.Images.Media.DATA)));
            imagesAddress=image_Cursor.getString(image_Cursor.getColumnIndex(MediaStore.Images.Media.DATA)).trim();
            if(isImage(imagesAddress)) {
                tempAddress = imagesAddress.substring(0, imagesAddress.lastIndexOf("/"));
                folderName = tempAddress.substring(tempAddress.lastIndexOf("/") + 1);
                if (everythings.containsKey(folderName)) {
                    //List<String> stringList = everythings.get(folderName);
                    //opening
                    CustomGalleryGETSET getset=everythings.get(folderName);
                    TreeSet<String> stringTreeSet=getset.getFolderImages();
                    //updating
                    stringTreeSet.add(imagesAddress);
                    //closing
                    getset.setFolderImages(stringTreeSet);
                    everythings.put(folderName, getset);
                    //stringList.add(imagesAddress);
                    //everythings.put(folderName, stringList);
                } else {
                    //List<String> allFolderImages = new LinkedList<>();
                    //creating new
                    CustomGalleryGETSET getset=new CustomGalleryGETSET();
                    TreeSet<String> treeSet=new TreeSet<>();
                    treeSet.add(imagesAddress);
                    getset.setFolderImages(treeSet);
                    getset.setFolderName(folderName);
                    //allFolderImages.add(imagesAddress);
                    //adding new to map
                    //list.add(getset);
                    everythings.put(folderName, getset);
                    //everythings.put(folderName, allFolderImages);
                }
            }
        }
        return everythings;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if(id==1) {
            return new CursorLoader(getContext(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null, null, order);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Map<String,CustomGalleryGETSET> mapImagesByFolders=getEverytingsFromCursor(data);
        list=new ArrayList<>();
        for(Map.Entry<String,CustomGalleryGETSET> entry:mapImagesByFolders.entrySet()) {
            Log.w("Folder Name- ", "" + entry.getKey());
            CustomGalleryGETSET getset = entry.getValue();
            list.add(getset);
        }
        FoldersAdapter foldersAdapter=new FoldersAdapter(getContext(),list,getFragmentManager());
        recyclerView.setAdapter(foldersAdapter);
//        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
