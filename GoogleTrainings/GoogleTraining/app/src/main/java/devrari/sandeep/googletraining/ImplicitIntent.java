package devrari.sandeep.googletraining;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ImplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_intent);
    }

    public void callActivity(View view) {
        switch(view.getId()){
            case R.id.openWeb:
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(intent);
                break;
            case R.id.openCall:
                Intent intent2=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8979221199"));
                startActivity(intent2);
                break;
            case R.id.openMap:
                Intent intent3=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:20.5937,78.9629"));
                startActivity(intent3);
                break;
            default:
                Toast.makeText(getApplicationContext(),"hell",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
