package devrari.sandeep.googletraining;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by user on 3/4/18.
 */

class PreferenceSettingListner implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context context;

    PreferenceSettingListner(Context context) {
        this.context = context;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        //String s=sharedPreferences.getString(key,"hell");
        //Log.e("*************",s);
        Toast.makeText(context, "Clicked",Toast.LENGTH_SHORT).show();
    }
}
