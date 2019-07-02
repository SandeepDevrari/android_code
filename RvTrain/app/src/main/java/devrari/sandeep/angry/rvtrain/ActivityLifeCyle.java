package devrari.sandeep.angry.rvtrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ActivityLifeCyle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_life_cyle);
        Toast.makeText(this,"Created",Toast.LENGTH_SHORT).show();
        Log.d("created","ho gya bhai");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this,"Created",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this,"Created",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this,"Created",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this,"Created",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Created",Toast.LENGTH_SHORT).show();
    }
}


