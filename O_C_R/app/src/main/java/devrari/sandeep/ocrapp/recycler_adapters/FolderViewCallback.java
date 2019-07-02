package devrari.sandeep.ocrapp.recycler_adapters;

import android.view.View;

/**
 * Created by Angry on 5/1/2018.
 */

public interface FolderViewCallback {
    void onViewImageClick(View v, int position);
    void onViewImageLongClick(View v,int position);
}
