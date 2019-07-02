package devrari.sandeep.googletraining;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by user on 11/4/18.
 */

public class FragmentContactName extends Fragment {
    private ListView listView;
    private ArrayList<String> names;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=getLayoutInflater().inflate(R.layout.fragment_contacts_name,container,false);
        addListData(view);
        return view;
    }

    private void addListData(View view) {
        listView=view.findViewById(R.id.contactNameFragmentListView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle=getArguments();
        names=bundle.getStringArrayList("Contacts_Name");
        if(names!=null){
            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,names);
            listView.setAdapter(arrayAdapter);
        }
    }
}
