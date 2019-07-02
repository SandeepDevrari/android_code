package devrari.sandeep.googletraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExplicitIntent extends AppCompatActivity {

    private final int RESPOND_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);
        Button button=findViewById(R.id.explicitCall);
        final EditText inputText=findViewById(R.id.inputTxt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ExplicitIntent.this,ExplicitCall.class);
                intent.putExtra("inputDataisHere",inputText.getText().toString());
                startActivityForResult(intent,RESPOND_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESPOND_CODE){
            if(resultCode==RESULT_OK){
                TextView t=findViewById(R.id.explicitReply);
                t.setText(t.getText().toString()+data.getStringExtra("replyBack"));
                t.setVisibility(View.VISIBLE);
            }
        }
    }
}
