package devrari.sandeep.googletraining;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user on 24/3/18.
 */

public class ReceiverFragment extends Fragment {
    private View root;
    private TextView tv;
    private String flagName,flagDescreption;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_receiver_layout,container,false);
        addTextView();
        return root;
    }

    private void addTextView() {
        tv=root.findViewById(R.id.recieverScrollText);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Flag Description ->");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null){
            flagName=bundle.getString(FragmentToFragmentInterface.GET_THE_VALUE);
        //String tt="R.string."+flagName;
            flagDescreption=getResources().getString(getStringId());
            tv.setText(flagDescreption);
        }
    }

    public int getStringId() {
        if(flagName.equals("United_Kingdom")){
            return R.string.United_Kingdom;
        }else if(flagName.equals("Austria")){
            return R.string.Austria;
        }
        else if(flagName.equals("Bangladesh")){
            return R.string.Bangladesh;
        }
        return R.string.Bangladesh;
    }
}
