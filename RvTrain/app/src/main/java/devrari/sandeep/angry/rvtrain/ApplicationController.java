package devrari.sandeep.angry.rvtrain;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ApplicationController extends Application {

    public static final String TAG=ApplicationController.class.getSimpleName();
    private RequestQueue requestQueue;
    private static ApplicationController applicationController;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationController=this;
    }

    public static synchronized ApplicationController getClassInstance(){
        return applicationController;
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request,String tag){
        request.setTag(TextUtils.isEmpty(tag)?TAG:tag);
        getRequestQueue().add(request);
    }
    public <T> void addToRequestQueue(Request<T>request){
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void canclePendingRequests(Object tag){
        if(requestQueue!=null){
            requestQueue.cancelAll(tag);
        }
    }
}
