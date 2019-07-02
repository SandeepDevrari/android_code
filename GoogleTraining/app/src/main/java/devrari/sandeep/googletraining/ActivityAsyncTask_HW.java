package devrari.sandeep.googletraining;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class ActivityAsyncTask_HW extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task__hw);

        final TextView textView=findViewById(R.id.asyncTask_HW_Text);
        button=findViewById(R.id.asyncTask_HW_Button);
        View.OnClickListener buttonListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ClassAsyncTask(textView).execute();
            }
        };
        button.setOnClickListener(buttonListener);
    }
    class ClassAsyncTask extends AsyncTask<Void,Void,String>{
        private TextView textView;
        ClassAsyncTask(TextView textView){
            this.textView=textView;
        }
        @Override
        protected String doInBackground(Void... voids) {
            Random random=new Random();
            int i=random.nextInt(11)*200;
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Awake at last after sleeping for " +i+ " milliseconds!";
        }

        @Override
        protected void onPostExecute(String s) {
            textView.setText(s);
        }
    }
}
