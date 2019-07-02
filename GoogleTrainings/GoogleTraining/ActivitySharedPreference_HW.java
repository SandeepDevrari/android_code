package devrari.sandeep.googletraining;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivitySharedPreference_HW extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView1,imageView2,imageView3,imageView4,reset;
    private int i1,i2,i3,i4;
    private SharedPreferences sharedPreferences;
    private String one="1",two="2",three="3",four="4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference__hw);

        textView=findViewById(R.id.SP_HW_Text);
        imageView1=findViewById(R.id.SP_HW_imageButton);
        imageView2=findViewById(R.id.SP_HW_imageButton2);
        imageView3=findViewById(R.id.SP_HW_imageButton3);
        imageView4=findViewById(R.id.SP_HW_imageButton4);
        reset=findViewById(R.id.SP_HW_reset);
        sharedPreferences=getSharedPreferences("HELLO",MODE_PRIVATE);

        i1=sharedPreferences.getInt(one,0);
        i2=sharedPreferences.getInt(two,0);
        i3=sharedPreferences.getInt(three,0);
        i4=sharedPreferences.getInt(four,0);
        textView.setText(sharedPreferences.getString("TEXT"," 0"));

        View.OnClickListener resetListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesIsHere();
            }
        };
        View.OnClickListener im1=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(""+(++i1));
            }
        };
        View.OnClickListener im2=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(""+(++i2));
            }
        };
        View.OnClickListener im3=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(""+(++i3));
            }
        };
        View.OnClickListener im4=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(""+(++i4));
            }
        };

        imageView1.setOnClickListener(im1);
        imageView2.setOnClickListener(im2);
        imageView3.setOnClickListener(im3);
        imageView4.setOnClickListener(im4);
        reset.setOnClickListener(resetListener);


    }

    private void valuesIsHere() {
        i1=0;i2=0;i3=0;i4=0;
        textView.setText("0");
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(one,i1);
        editor.putInt(two,i2);
        editor.putInt(three,i3);
        editor.putInt(four,i4);
        editor.putString("TEXT",textView.getText().toString());
        editor.apply();
    }
}
