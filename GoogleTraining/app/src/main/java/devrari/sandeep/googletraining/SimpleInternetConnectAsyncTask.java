package devrari.sandeep.googletraining;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 20/4/18.
 */

public class SimpleInternetConnectAsyncTask extends AsyncTask<String,Void,String> {
    private Context context;
    private TextView textView;

    public SimpleInternetConnectAsyncTask(Context context,TextView textView) {
        this.context = context;
        this.textView=textView;
    }

    @Override
    protected String doInBackground(String... strings) {
        String string=strings[0];
        InputStream inputStream;
        StringBuilder builder=new StringBuilder();
        try {
            URL url=new URL(string);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.connect();

            inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while((line=bufferedReader.readLine())!=null){
                builder.append(line+"\n");
            }
            inputStream.close();
            bufferedReader.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ""+builder;
    }

    @Override
    protected void onPostExecute(String s) {
        textView.setText(s);
    }
}
