package devrari.sandeep.googletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ActivityLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Toast.makeText(this,"activity created",Toast.LENGTH_SHORT).show();
        Log.i("main activity","created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"activity start",Toast.LENGTH_SHORT).show();
        Log.i("main activity","start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"activity resume",Toast.LENGTH_SHORT).show();
        Log.i("main activity","resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"activity paused",Toast.LENGTH_SHORT).show();
        Log.i("main activity","paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"activity stopped",Toast.LENGTH_SHORT).show();
        Log.i("main activity","stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"activity destroyed",Toast.LENGTH_SHORT).show();
        Log.i("main activity","destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"activity restarted",Toast.LENGTH_SHORT).show();
        Log.i("main activity"," restarted");
    }
}
