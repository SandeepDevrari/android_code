package devrari.sandeep.googletraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExplicitCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_call);
        TextView showInput=findViewById(R.id.callBack);
        Intent intent=getIntent();
        showInput.setText(showInput.getText().toString()+" "+intent.getStringExtra("inputDataisHere"));
        Button reply=findViewById(R.id.ExplicitCallReplyToButton);
        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et=findViewById(R.id.ExplicitCallReplyTo);
                Intent intent=new Intent();
                intent.putExtra("replyBack",et.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
