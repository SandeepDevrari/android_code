package devrari.sandeep.googletraining;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by user on 20/4/18.
 */

public class FetchBookFromHereThread extends AsyncTask<String,Void,String> {
    private TextView textView;

    public FetchBookFromHereThread(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
}
