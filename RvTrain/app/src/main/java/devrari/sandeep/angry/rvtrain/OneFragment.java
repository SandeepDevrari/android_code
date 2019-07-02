package devrari.sandeep.angry.rvtrain;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    private TextView tv;
    private View root;
    Context context;
    CallToInterface fragment;
    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.fragment_one, container, false);
        addActionHere();
        return root;
    }
    public void setFragment(CallToInterface fragment){
        this.fragment=fragment;
    }

    private void addActionHere() {
        tv=root.findViewById(R.id.One_1);
        context=getContext();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragment!=null){
                    fragment.callToInterface();
                }
            }
        });
    }


}
