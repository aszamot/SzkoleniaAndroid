package com.example.tomasz.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private int poosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoView = (VideoView) findViewById(R.id.video_view);

        if (mediaController == null) {
            mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);

            videoView.setMediaController(mediaController);
        }

        Intent inent = getIntent();
        if (inent != null) {
            String path = inent.getStringExtra("video_to_play");
            videoView.setVideoURI(Uri.parse(path));
            videoView.start();
        }

        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(poosition);
                if (poosition == 0) {
                    videoView.start();
                }

                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int pos = videoView.getCurrentPosition();
        outState.putInt("current_position", videoView.getCurrentPosition());
        if(videoView.isPlaying()){
            outState.putBoolean("playing", true);
        }else{
            outState.putBoolean("playing", false);
        }
        videoView.pause();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        poosition = savedInstanceState.getInt("current_position", 0);
        videoView.seekTo(poosition);
    }
}
