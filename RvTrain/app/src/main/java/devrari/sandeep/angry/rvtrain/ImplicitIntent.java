package devrari.sandeep.angry.rvtrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ImplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        Intent intent=getIntent();
        TextView show=findViewById(R.id.showhere);
        show.setText(show.getText().toString()+intent.getStringExtra("emailIsHere"));
    }
}
