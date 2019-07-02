package devrari.sandeep.ocrapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devrari.sandeep.ocrapp.recycler_adapters.FolderAllImagesAdapter;
import devrari.sandeep.ocrapp.recycler_adapters.FolderViewCallback;

public class ActivityCustomGalleryFolderImages extends AppCompatActivity implements ActionMode.Callback{
    private RecyclerView recyclerView;
    private int totalImageSelected=0;
    private ActionMode actionMode;
    private MenuItem totalSelectedImagesMenu;
    private ArrayList<String>sendTo;
    private ArrayList<ImageView>selectedImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gallery_folder_images);
        linkUI();
        logicsHere();
    }

    private void logicsHere() {
        final Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        final List<String> list=bundle.getStringArrayList("AllImagesAreHere");
        sendTo=new ArrayList<>();
        selectedImageList=new ArrayList<>();
        FolderAllImagesAdapter folderAllImagesAdapter=new FolderAllImagesAdapter(list, this, new FolderViewCallback() {
            @Override
            public void onViewImageClick(View v, int position) {
                ImageView imageViewOther=v.findViewById(R.id.folderAllImageHereOther);
                if((totalImageSelected>0) && (imageViewOther.getVisibility()==View.INVISIBLE)){
                    imageViewOther.setVisibility(View.VISIBLE);
                    Log.w("Increment",""+(++totalImageSelected));
                    sendTo.add(list.get(position));
                    selectedImageList.add(imageViewOther);
                }else if(imageViewOther.getVisibility()==View.VISIBLE){
                  //  multiImageSelected=false;
                    imageViewOther.setVisibility(View.INVISIBLE);
                    if(totalImageSelected>0){
                        Log.w("Decrement",""+(--totalImageSelected));
                    }
                    sendTo.remove(list.get(position));
                    selectedImageList.remove(imageViewOther);
                }
                else{
                    //Toast.makeText(ActivityCustomGalleryFolderImages.this, "Image selected", Toast.LENGTH_SHORT).show();
                    sendTo.add(list.get(position));
                    callSendTo();
                }
                if(actionMode!=null) {
                    totalSelectedImagesMenu.setTitle(totalImageSelected + " selected");
                }
                if(totalImageSelected==0 && actionMode!=null){
                    actionMode.finish();
                    actionMode=null;
                }

            }

            @Override
            public void onViewImageLongClick(View v, int position) {
                ImageView imageViewOther=v.findViewById(R.id.folderAllImageHereOther);

                //ImageView imageView=v.findViewById(R.id.folderAllImageHere);
                if((imageViewOther.getVisibility())==View.VISIBLE){
                    imageViewOther.setVisibility(View.INVISIBLE);
                    if(totalImageSelected>0){
                        Log.w("Decrement",""+(--totalImageSelected));
                    }
                    sendTo.remove(list.get(position));
                    selectedImageList.remove(imageViewOther);
                }
                else{
                    imageViewOther.setVisibility(View.VISIBLE);
                    Log.w("Increment",""+(++totalImageSelected));
                    sendTo.add(list.get(position));
                    selectedImageList.add(imageViewOther);
                    //imageViewOther.setEnabled(true);
                }
                if(actionMode==null){
                    actionMode=startSupportActionMode(ActivityCustomGalleryFolderImages.this);
                }
                if(actionMode!=null) {
                    totalSelectedImagesMenu.setTitle(totalImageSelected + " selected");
                }
                if(totalImageSelected==0 && actionMode!=null){
                    actionMode.finish();
                    actionMode=null;
                }
            }
        });
        recyclerView.setAdapter(folderAllImagesAdapter);
    }

    private void linkUI() {
        recyclerView=findViewById(R.id.custom_gallery_recyclerview_folder_images);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.select_and_clear,menu);
        setTitle("ABCD");
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        totalSelectedImagesMenu=menu.findItem(R.id.selectedCount);
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()){
            case R.id.doneMenu:{
                callSendTo();
            }
        }
        return true;
    }

    private void callSendTo() {
        Intent intent=new Intent(ActivityCustomGalleryFolderImages.this,ActivitySendTo.class);
        Bundle bundle=new Bundle();
        bundle.putStringArrayList("SEND_TO",sendTo);
        intent.putExtras(bundle);
        startActivity(intent);
        clearData();
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        actionMode=null;
    }
    private void clearData(){
        if(actionMode!=null){
            actionMode.finish();
            actionMode=null;
        }
        if(!sendTo.isEmpty()){
            sendTo.clear();
        }
        totalImageSelected=0;
        if(!selectedImageList.isEmpty()){
            for(ImageView im:selectedImageList){
                im.setVisibility(View.INVISIBLE);
            }
            selectedImageList.clear();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        clearData();
    }

    @Override
    public void onBackPressed() {
        if(actionMode!=null){
            clearData();
        }else{
            super.onBackPressed();
        }
    }
}
