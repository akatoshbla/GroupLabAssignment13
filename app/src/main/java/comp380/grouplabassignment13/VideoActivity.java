//Group 1: David Kopp, Ibrahim Hayek, Edward Guerrero, Luis Guzman, Gerald Fairclough
//Group Lab Assignment 13

package comp380.grouplabassignment13;


// Taken from a Tutorial at:
// http://www.androidbegin.com/tutorial/android-video-streaming-videoview-tutorial/

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;


public class VideoActivity extends ActionBarActivity {

    // Variable / Object Declarations
    ProgressDialog progressDialog;
    VideoView videoView;

    // URL String the battle of the 5 armies teaser
    private static final String videoURL = "http://koppster.byethost7.com/th5aTrailer.3gp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        // Find VideoView in layout
        videoView= (VideoView) findViewById(R.id.videoView);

        // Create a progressbar, title, message, progress
        progressDialog = new ProgressDialog(VideoActivity.this);
        progressDialog.setTitle("Streaming Video");
        progressDialog.setMessage("Loading...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        progressDialog.show();

        // Can be in Try / Catch (This sets the MediaController to the videoView
        MediaController mediaController = new MediaController(VideoActivity.this);
        mediaController.setAnchorView(videoView);

        // Try and catch to remove crash if site is not found Access website
        try {
            Uri video = Uri.parse(videoURL);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(video);
        } catch (Exception e) {
            Log.e("Error: Can not find URL", e.getMessage());
            e.printStackTrace();
        }

        // Setting the VideoView to start and dismissing the progressDialog
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            // Close the progress bar and start the vid
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressDialog.dismiss();
                videoView.start();
            }
        });
    }


}
