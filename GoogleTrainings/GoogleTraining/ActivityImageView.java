package devrari.sandeep.googletraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityImageView extends AppCompatActivity {

    ImageView donut,ice,froyo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent=new Intent(getApplicationContext(),ActivityImageView2.class);
                startActivity(intent);
            }
        });
        donut=findViewById(R.id.donut);
        ice=findViewById(R.id.ice_cream_sendwiches);
        froyo=findViewById(R.id.froyo);
        donut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityImageView.this, "you ordered Donut", Toast.LENGTH_SHORT).show();
            }
        });
        ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityImageView.this, "You ordered Ice Cream Sandwich", Toast.LENGTH_SHORT).show();
            }
        });
        froyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityImageView.this, "you ordered Froyo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.image_view_bar_action,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_contact:
                Toast.makeText(this, "Action Contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_favorites:
                Toast.makeText(this, "Action Favorites", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_order:
                Toast.makeText(this, "Action Order", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_status:
                Toast.makeText(this, "Action Status", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
