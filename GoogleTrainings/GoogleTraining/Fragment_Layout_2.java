package devrari.sandeep.googletraining;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 23/3/18.
 */

public class Fragment_Layout_2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_2,container,false);
    }
    @Override
    public String toString() {
        return Fragment_Layout_2.class.getSimpleName();
    }
}