package devrari.sandeep.ocrapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import devrari.sandeep.ocrapp.loader_cursor.AllImagesLoader;
import devrari.sandeep.ocrapp.pojo_classes.FoldersWithImagesGETSET;

public class ActivityCustomGallery extends AppCompatActivity{//FragmentActivity implements Loadef rManager.LoaderCallbacks<Cursor> {

    private TextView noImages;
    private RecyclerView recyclerView;
    private Context context;
    private List<FoldersWithImagesGETSET> list;
    public static final int LOAD_IMAGES_ID=1;
    private static final String KEY_MEDIA_BUNDLE="images_media_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gallery);
        //getActionBar().setTitle("Gallery");
       // toolbar=findViewById(R.id.actionToolbarGalleryFolders);
        linkUI();
        logicsHere();
    }

    private void logicsHere() {
        AllImagesLoader allImagesLoader=new AllImagesLoader(recyclerView, this,getSupportLoaderManager());
        //getSupportLoaderManager().initLoader(LOAD_IMAGES_ID,null,allImagesLoader);
    }

    private void linkUI() {
        noImages=findViewById(R.id.custom_gallery_grid_no_images_found);
        recyclerView=findViewById(R.id.custom_gallery_recyclerview_folders);
        noImages.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));
    }

//    private boolean isImage(String imagePath){
//        String extentionImage=imagePath.substring(imagePath.lastIndexOf("."));
//        if(extentionImage.equalsIgnoreCase(".jpeg")||extentionImage.equalsIgnoreCase(".jpg")||extentionImage.equalsIgnoreCase(".png")||extentionImage.equalsIgnoreCase(".bmp")){
//            return true;
//        }
//        return false;
//    }
//    private Map<String,FoldersWithImagesGETSET> getEverytingsFromCursor(Cursor image_Cursor){
//        Map<String,FoldersWithImagesGETSET>everythings=new HashMap<>();
//        //list=new LinkedList<>();
//        String imagesAddress,folderName,tempAddress;
//        while(image_Cursor.moveToNext()){
//            Log.w("cursor:"," "+image_Cursor.getString(5image_Cursor.getColumnIndex(MediaStore.Images.Media.DATA)));
//            imagesAddress=image_Cursor.getString(image_Cursor.getColumnIndex(MediaStore.Images.Media.DATA)).trim();
//            if(isImage(imagesAddress)) {
//                tempAddress = imagesAddress.substring(0, imagesAddress.lastIndexOf("/"));
//                folderName = tempAddress.substring(tempAddress.lastIndexOf("/") + 1);
//                if (everythings.containsKey(folderName)) {
//                    //List<String> stringList = everythings.get(folderName);
//                    //opening
//                    FoldersWithImagesGETSET getset=everythings.get(folderName);
//                    TreeSet<String> stringTreeSet=getset.getFolderImages();
//                    //updating
//                    stringTreeSet.add(imagesAddress);
//                    //closing
//                    getset.setFolderImages(stringTreeSet);
//                    everythings.put(folderName, getset);
//                    //stringList.add(imagesAddress);
//                    //everythings.put(folderName, stringList);
//                } else {
//                    //List<String> allFolderImages = new LinkedList<>();
//                    //creating new
//                    FoldersWithImagesGETSET getset=new FoldersWithImagesGETSET();
//                    TreeSet<String> treeSet=new TreeSet<>();
//                    treeSet.add(imagesAddress);
//                    getset.setFolderImages(treeSet);
//                    getset.setFolderName(folderName);
//                    //allFolderImages.add(imagesAddress);
//                    //adding new to map
//                    //list.add(getset);
//                    everythings.put(folderName, getset);
//                    //everythings.put(folderName, allFolderImages);
//                }
//            }
//        }
//        return everythings;
//    }
//
//    @Override
//    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
//        if(id==LOAD_IMAGES_ID){
//            String[] columns={MediaStore.Images.Media.DATA};//,MediaStore.Images.Media._ID};
//            String order= MediaStore.Images.Media.DATE_TAKEN;
//            return new CursorLoader(this,MediaStore.Images.Media.EXTERNAL_CONTENT_URI,columns,null,null,order);
//        }
//        return null;
//    }
//    @Override
//    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
//        Map<String,FoldersWithImagesGETSET> mapImagesByFolders=getEverytingsFromCursor(data);
//        list=new ArrayList<>();
//        for(Map.Entry<String,FoldersWithImagesGETSET> entry:mapImagesByFolders.entrySet()) {
//            Log.w("Folder Name- ", "" + entry.getKey());
//            FoldersWithImagesGETSET getset = entry.getValue();
//            list.add(getset);
//        }
//
//        FolderAdapter foldersAdapter=new FolderAdapter(this, list, new FolderAdapter.FolderHolder.FolderViewCallback() {
//            @Override
//            public void onViewImageClick(View v, int position) {
//                FoldersWithImagesGETSET getset=list.get(position);
//                TreeSet<String> treeSet=getset.getFolderImages();
//                ArrayList<String> arrayList=new ArrayList<>(treeSet);
//                Bundle bundle=new Bundle();
//                bundle.putStringArrayList("AllImagesAreHere",arrayList);
//                Intent intent=new Intent(getApplicationContext(),ActivityCustomGalleryFolderImages.class);
//                intent.putExtras(bundle);
//                getApplicationContext().startActivity(intent);
//            }
//
//            @Override
//            public void onViewImageLongClick(View v, int position) {
//                //
//            }
//        });
//        recyclerView.setAdapter(foldersAdapter);
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Cursor> loader) {
//        //NO now
//    }

    @Override
    protected void onDestroy() {
        //releaseAllHere();
        super.onDestroy();
    }

    private void releaseAllHere() {
        finish();
        if(recyclerView!=null){
            recyclerView.removeAllViews();
            recyclerView=null;
        }
        if(list!=null){
            list.clear();
            list=null;
        }
    }
}
