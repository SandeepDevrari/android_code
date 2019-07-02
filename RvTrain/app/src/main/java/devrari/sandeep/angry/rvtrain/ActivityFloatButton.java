package devrari.sandeep.angry.rvtrain;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivityFloatButton extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_button);
        floatingActionButton=findViewById(R.id.floatingActionButton1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"abcd",Snackbar.LENGTH_SHORT).setAction("click here", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ActivityFloatButton.this, "You Clicked!!!", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}
