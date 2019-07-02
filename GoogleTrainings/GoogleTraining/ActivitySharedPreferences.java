package devrari.sandeep.googletraining;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ActivitySharedPreferences extends AppCompatActivity {

    private EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        et1=findViewById(R.id.sharedTextOne);
        et2=findViewById(R.id.sharedTextTwo);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences myShared=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        SharedPreferences.Editor myEditor=myShared.edit();
        myEditor.putString("Name",et1.getText().toString());
        myEditor.putString("Number",et2.getText().toString());
        myEditor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences dusra=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        et1.setText(dusra.getString("Name","No Default"));
        et2.setText(dusra.getString("Number","na"));
    }
}
