package devrari.sandeep.googletraining;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFolderAllImages extends Fragment {
    private RecyclerView recyclerView;

    public FragmentFolderAllImages() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_folder_all_images, container, false);
        linkTheItems(view);
        return view;
    }

    private void linkTheItems(View view) {
        recyclerView=view.findViewById(R.id.folderAllImagesRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle=getArguments();
        List<String>list=bundle.getStringArrayList("AllImagesAreHere");
        FolderAllImagesAdapter folderAllImagesAdapter=new FolderAllImagesAdapter(list,getContext());
        recyclerView.setAdapter(folderAllImagesAdapter);
    }
}
