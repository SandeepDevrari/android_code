package devrari.sandeep.googletraining;

import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySimpleInternetConnect extends AppCompatActivity {

    private TextView textView;
    private SimpleInternetConnectAsyncTask task;
    private SimpleInternetDownloadImageAsync internetDownloadImageAsync;
    private ImageView imageView;
    private ConnectivityManager connectivityManager;
    private NetworkInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_internet_connect);
        textView=findViewById(R.id.internetTextHere);
        imageView=findViewById(R.id.simpleInternetImageFromNet);
        connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        info=connectivityManager.getActiveNetworkInfo();
    }

    public void internetCallMethod(View view) {
        task=new SimpleInternetConnectAsyncTask(this,textView);
        task.execute("http://google.co.in");
    }

    public void downloadThatImage(View view) {
        if(info!=null & info.isConnected()){
            internetDownloadImageAsync=new SimpleInternetDownloadImageAsync(imageView);
            internetDownloadImageAsync.execute("https://www.elastic.co/assets/bltada7771f270d08f6/enhanced-buzz-1492-1379411828-15.jpg");
        }else{
            Toast.makeText(this, "No Internet Connection!!", Toast.LENGTH_SHORT).show();
        }
    }
}
