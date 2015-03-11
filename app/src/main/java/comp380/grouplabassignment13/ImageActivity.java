//Group 1: David Kopp, Ibrahim Hayek, Edward Guerrero, Luis Guzman, Gerald Fairclough
//Group Lab Assignment 13

package comp380.grouplabassignment13;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;


public class ImageActivity extends ActionBarActivity {

    // Variable / Object Declarations
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        // Fetching the ImageView from xml and drawing the png to it - hdpi
        imageView = (ImageView) findViewById(R.id.picViewer);
        imageView.setImageResource(R.drawable.android_hawaii_pic);
    }
}
