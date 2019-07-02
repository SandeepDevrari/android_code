package devrari.sandeep.googletraining;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SelectorFragment extends Fragment {

    private View root;
    private ListView flags;
    private ArrayAdapter<String> flagsAdapter;
    private String[] flagsArray;
    private Context selectorContext;
    private FragmentToFragmentInterface fragmentToFragmentInterface;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_selector, container, false);
        addDataToFragment();
        return root;
    }

    private void addDataToFragment() {
        selectorContext=getContext();
        flagsArray=getResources().getStringArray(R.array.selectorArray);
        flags=root.findViewById(R.id.conceptSelectorLisView);
        flagsAdapter=new ArrayAdapter<String>(selectorContext,android.R.layout.simple_list_item_1,flagsArray);
        flags.setAdapter(flagsAdapter);
        flags.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(fragmentToFragmentInterface !=null){
                    Bundle bundle=new Bundle();
                    bundle.putString(FragmentToFragmentInterface.GET_THE_VALUE,flagsArray[position]);
                    fragmentToFragmentInterface.fragmentToFragmentCall(bundle);
                }
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Try on Flags->");
    }

//    public void setFragmentToFragmentInterface(FragmentToFragmentInterface fragmentToFragmentInterface){
//        this.fragmentToFragmentInterface = fragmentToFragmentInterface;
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentToFragmentInterface=(FragmentConceptActivity)getActivity();
    }
}
