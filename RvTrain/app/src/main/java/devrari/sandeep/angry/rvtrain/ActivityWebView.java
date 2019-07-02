package devrari.sandeep.angry.rvtrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;

public class ActivityWebView extends AppCompatActivity {

    HashMap<String,String>map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        final WebView web=findViewById(R.id.web_view_web);
        web.loadUrl("http://www.google.co.in");
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        Spinner spin=findViewById(R.id.webViewSpinner1);
        map=new HashMap<>();
        map.put("Google","http://www.google.co.in");
        map.put("facebook","http://www.instagram.com");
        map.put("youtube","http://www.youtube.com");
        ArrayList<String> list=new ArrayList<>(map.keySet());
        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                web.loadUrl(map.get(parent.getItemAtPosition(position).toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                web.loadUrl("http://www.instagram.com");
            }
        });
    }
}
