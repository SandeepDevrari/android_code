package devrari.sandeep.angry.rvtrain.apiTag;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionUser {
    private Context context;
    private static String TAG =SessionUser.class.getSimpleName();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String FILENAME="FileOne";
    private static final String EMAIL="email";

    public SessionUser(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences(FILENAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void setLoggedIn(String email){
        editor.putString(EMAIL,email);
        editor.commit();
    }
    public void clearLogIn(){
        editor.clear();
        editor.commit();
    }
    public String getLoggedIn(){
        return sharedPreferences.getString(EMAIL,"NoLoggedIn");
    }
}
