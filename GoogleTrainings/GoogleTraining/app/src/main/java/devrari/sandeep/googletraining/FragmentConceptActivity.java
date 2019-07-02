package devrari.sandeep.googletraining;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class FragmentConceptActivity extends AppCompatActivity implements FragmentToFragmentInterface {

    private FragmentManager conceptFM;
    private FragmentTransaction conceptFT;
    private boolean isItLandscapeMode;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_concept);
        conceptFM=getSupportFragmentManager();
        if(findViewById(R.id.fragmentConceptPortaite)!=null){
            isItLandscapeMode=false;
            Log.e("Portaite","orientation");
            if(savedInstanceState==null){
                addFragmentHere();
            }else{
                addFragmentHere();
            }
        }
        else if(findViewById(R.id.fragmentConceptLandscape)!=null){
            isItLandscapeMode=true;
            Log.e("Landscape","orientation");
            addFragmentHere();
            if(savedInstanceState==null){
                addFragmentHereLandscape();
            }
            else{
                addFragmentHereLandscape();
            }
        }

    }

    private void addFragmentHere() {
        conceptFT=conceptFM.beginTransaction();
        SelectorFragment fragment=new SelectorFragment();
        //fragment.setFragmentToFragmentInterface(this);
        if(isItLandscapeMode){
            conceptFT.add(R.id.conceptAreaLand,fragment);
        }
        else{
            conceptFT.add(R.id.conceptArea,fragment);
        }
        conceptFT.addToBackStack("Concepts");
        conceptFT.commit();
    }
    private void addFragmentHereLandscape() {
        conceptFT=conceptFM.beginTransaction();
        //fragment.setFragmentToFragmentInterface(this);
        ReceiverFragment Rfragment=new ReceiverFragment();
        conceptFT.add(R.id.conceptAreaLand2,Rfragment);
        conceptFT.addToBackStack("Concepts");
        conceptFT.commit();
    }

    @Override
    public void fragmentToFragmentCall(Bundle bundle) {
        if(isItLandscapeMode){
            replaceReceiver(bundle);
        }
        else {
            Toast.makeText(this, "CalledActivity", Toast.LENGTH_SHORT).show();
            addReceiver(bundle);
        }
    }

    private void addReceiver(Bundle bundle) {
        conceptFT=conceptFM.beginTransaction();
        ReceiverFragment rf=new ReceiverFragment();
        rf.setArguments(bundle);
        conceptFT.add(R.id.conceptArea,rf);
        conceptFT.addToBackStack("Concepts");
        conceptFT.commit();
    }
    private void replaceReceiver(Bundle bundle) {
        conceptFT=conceptFM.beginTransaction();
        ReceiverFragment rf=new ReceiverFragment();
        rf.setArguments(bundle);
        conceptFT.replace(R.id.conceptAreaLand2,rf);
        //conceptFT.addToBackStack("Concepts");
        conceptFT.commit();
    }

}
