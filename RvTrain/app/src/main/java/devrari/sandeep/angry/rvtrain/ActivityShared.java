package devrari.sandeep.angry.rvtrain;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityShared extends AppCompatActivity {

    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        name = findViewById(R.id.etName);
        SharedPreferences sharedPreferences =getSharedPreferences("ABCD",MODE_PRIVATE);
        name.setText(sharedPreferences.getString("ABCD"," "));
    }

    public void saveToPer(View view) {
        SharedPreferences sharedPreferences =getSharedPreferences("ABCD",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("VALUES",name.getText().toString());
        editor.apply();
    }
}
