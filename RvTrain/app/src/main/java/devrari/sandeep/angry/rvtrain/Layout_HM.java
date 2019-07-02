package devrari.sandeep.angry.rvtrain;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Angry on 4/19/2018.
 */

public class Layout_HM extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hm);
        ImageView imageView=findViewById(R.id.productImage);
        Drawable bitmapDrawable=getResources().getDrawable(R.drawable.ic_launcher_background);
        //imageView.setImageDrawable(bitmapDrawable);
        PhotoViewAttacher photoViewAttacher=new PhotoViewAttacher(imageView);
    }
}
