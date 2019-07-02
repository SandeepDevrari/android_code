package devrari.sandeep.angry.rvtrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HR_Register extends AppCompatActivity {

    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr__register);
        Button press=findViewById(R.id.submitButton);
        email=findViewById(R.id.editText1);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ImplicitIntent.class);
                intent.putExtra("emailIsHere",email.getText().toString());
                startActivity(intent);
            }
        });
    }
}
