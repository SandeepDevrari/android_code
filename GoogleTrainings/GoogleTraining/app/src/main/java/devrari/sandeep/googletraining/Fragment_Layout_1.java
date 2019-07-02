package devrari.sandeep.googletraining;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import devrari.sandeep.googletraining.R;

/**
 * Created by user on 22/3/18.
 */

public class Fragment_Layout_1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Fragment","Create view");
        return inflater.inflate(R.layout.layout_fragment_1,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment","Start");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment","Resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment","Pause");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Fragment","Attach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment","Activity Created");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment","Destroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Fragment","Detach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment","Destroy View");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment","Create");
    }

    @Override
    public String toString() {
        return Fragment_Layout_1.class.getSimpleName();
    }
}
