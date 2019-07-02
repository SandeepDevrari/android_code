package devrari.sandeep.googletraining;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityCustomGallery extends AppCompatActivity {

    private Button gallery;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gallery);
        fragmentManager=getSupportFragmentManager();
        gallery=findViewById(R.id.open_custom_gallery_button);
        View.OnClickListener galleryListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction=fragmentManager.beginTransaction();
                FragmentCustomGalleryLayoutClass galleryLayoutClass=new FragmentCustomGalleryLayoutClass();
                fragmentTransaction.add(R.id.open_custom_gallery_here,galleryLayoutClass);
                fragmentTransaction.addToBackStack("gallery");
                int b=fragmentTransaction.commit();
                Log.w("attach Fragment value-",""+b);
                gallery.setVisibility(View.INVISIBLE);
                gallery.setEnabled(false);
            }
        };
        gallery.setOnClickListener(galleryListener);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment=fragmentManager.findFragmentById(R.id.open_custom_gallery_here);
        if(fragment!=null){
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
            gallery.setEnabled(true);
            gallery.setVisibility(View.VISIBLE);
        }
        super.onBackPressed();
    }
}
