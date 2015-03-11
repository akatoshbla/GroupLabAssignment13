package comp380.grouplabassignment13;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;


public class ImageActivity extends ActionBarActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = (ImageView) findViewById(R.id.picViewer);
        imageView.setImageResource(R.drawable.android_hawaii_pic);
    }
}
