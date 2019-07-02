package devrari.sandeep.googletraining;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityThreadConcepts extends AppCompatActivity {

    boolean bad=true;
    int i=0;
    TextView t1;
    CustomAsyncTask asyncTask;
    //Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_concepts);
        Button bt1=findViewById(R.id.threadStart);
        Button bt2=findViewById(R.id.threadStop);
        t1=findViewById(R.id.threadText);
        //handler=new Handler(getApplicationContext().getMainLooper());
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*bad=true;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(bad){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {//Looper ,handler and massageQueue
                                @Override
                                public void run() {
                                    t1.setText(""+(i++));
                                }
                            });

                            Log.e("Thread",""+Thread.currentThread().getId());
                        }
                    }
                }).start();*/
                asyncTask=new CustomAsyncTask();
                asyncTask.execute(i);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //bad=false;
                asyncTask.cancel(true);
            }
        });
    }
    class CustomAsyncTask extends AsyncTask<Integer,Integer,Integer>{
        private int count;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            count=0;
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            count=integers[0];
            while(bad){
                try {
                    Thread.sleep(1000);
                    count++;
                    publishProgress(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.e("AsyncTask ",""+Thread.currentThread().getId());
                if(isCancelled()){
                    break;
                }
            }
            return count;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            t1.setText(""+values[0]);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            t1.setText(""+integer);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.e("AsyncTask is cancelled",""+Thread.currentThread().getId());
        }
    }

}
