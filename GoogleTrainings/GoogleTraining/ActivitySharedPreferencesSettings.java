package devrari.sandeep.googletraining;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySharedPreferencesSettings extends AppCompatActivity {

    private EditText editText;
    private PreferenceSettingListner listner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_settings);
        editText=findViewById(R.id.preferencesSettingEditText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.preference_setting_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        listner=new PreferenceSettingListner(this);
        if(item.getItemId()==R.id.preference_setting_menu_text){
            Intent intent=new Intent(getApplicationContext(),PreferenceSettingActivity.class);
            startActivity(intent);
            PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(listner);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(""+editText.getId(),editText.getText().toString());
        editor.apply();
        Toast.makeText(this, "Number Saved!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editText.setText(sharedPreferences.getString(""+editText.getId(),""));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(listner);
    }
}
