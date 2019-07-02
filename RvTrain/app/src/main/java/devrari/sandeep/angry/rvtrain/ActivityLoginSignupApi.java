package devrari.sandeep.angry.rvtrain;

import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import devrari.sandeep.angry.rvtrain.apiTag.SessionUser;

public class ActivityLoginSignupApi extends AppCompatActivity implements View.OnClickListener {
   private SessionUser sessionUser;
   private ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup_api_activity);
        setUpUI();
    }

    private void setUpUI() {
        findViewById(R.id.api_login).setOnClickListener(this);
        findViewById(R.id.api_signup).setOnClickListener(this);
        sessionUser=new SessionUser(getApplicationContext());
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.api_login:{
                checkLogIn();
                break;
            }
            case R.id.api_signup:{
                break;
            }
            default:{
                //do Nothing
            }
        }
    }

    private void checkLogIn() {
        String tempEmail=sessionUser.getLoggedIn();
        if(!tempEmail.equals("NoLoggedIn")){
            Toast.makeText(this, "hello sir your email is "+tempEmail, Toast.LENGTH_SHORT).show();
        }else if(!checkInternet()){
            Toast.makeText(this, "Unable to connect to Internet!!!", Toast.LENGTH_SHORT).show();
        }else{
            final String email=((EditText)findViewById(R.id.api_email)).getText().toString().trim();
            final String password=((EditText)findViewById(R.id.api_password)).getText().toString().trim();
            progressDialog.setMessage("trying to login..");
            progressDialog.show();
            String requestTag="requestLogin";
            StringRequest stringRequest=new StringRequest(Request.Method.POST, getString(R.string.base_url) + "test_api/login.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if (!jsonObject.getBoolean("error")) {
                            Toast.makeText(ActivityLoginSignupApi.this, "Sucessfully loggedin", Toast.LENGTH_SHORT).show();
                            JSONObject object = jsonObject.getJSONObject("user");
                            String emailTemp = object.getString("email");
                            String createdAt = object.getString("created_at");
                            sessionUser.setLoggedIn(emailTemp);
                            Toast.makeText(ActivityLoginSignupApi.this, "Hello " + emailTemp + " created at " + createdAt, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ActivityLoginSignupApi.this, "" + jsonObject.getString("error_msg"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        Toast.makeText(ActivityLoginSignupApi.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(ActivityLoginSignupApi.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String>map=new HashMap<>();
                    map.put("email",email);
                    map.put("password",password);
                    return map;
                }
            };
            ApplicationController.getClassInstance().addToRequestQueue(stringRequest,requestTag);
        }
    }
    private boolean checkInternet(){
        ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isAvailable() && networkInfo.isConnected();
    }
}
