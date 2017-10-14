package pl.tomasz.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Tomasz on 12.10.2017.
 */

public class VideoPlayer extends AppCompatActivity {

    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);

        videoView = (VideoView) findViewById(R.id.video_view);

        if (mediaController == null) {
            mediaController = new MediaController(this);

            mediaController.setAnchorView(videoView);

            videoView.setMediaController(mediaController);
        }

        Intent intent = getIntent();
        if (intent != null) {
            String path = getIntent().getStringExtra("video_to_play");
            videoView.setVideoURI(Uri.parse(path));
            videoView.start();
        }

        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }

                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("CurrentPosition", videoView.getCurrentPosition());
        videoView.pause();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        position = savedInstanceState.getInt("CurrentPosition");
        videoView.seekTo(position);
    }

}
