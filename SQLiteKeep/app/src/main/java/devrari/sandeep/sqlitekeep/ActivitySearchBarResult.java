package devrari.sandeep.sqlitekeep;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivitySearchBarResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar_result);
        resultHandler(getIntent());
    }

    private void resultHandler(Intent intent) {
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query=intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, query, Toast.LENGTH_SHORT).show();
        }
    }
}
