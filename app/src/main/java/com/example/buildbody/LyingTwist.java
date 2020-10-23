package com.example.buildbody;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
public class LyingTwist extends  YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
        YouTubePlayerView youTubeView ;
        public static final String API_KEY = "AIzaSyBkzvTpG4fnjV9ZPRgvHywtdelH8r5eZnY";


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lying_twist);

        youTubeView=findViewById(R.id.youtubePlayerView);
        youTubeView.initialize(API_KEY, (YouTubePlayer.OnInitializedListener) this);
    }


@Override
public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean b) {


        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        /** Start buffering **/
        if (!b) {
        player.cueVideo("SO7UnEGI734");

        }
        };

        YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {

@Override
public void onBuffering(boolean arg0) {
        }

@Override
public void onPaused() {
        }

@Override
public void onPlaying() {
        }

@Override
public void onSeekTo(int arg0) {
        }

@Override
public void onStopped() {
        }

        };

        YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {

@Override
public void onAdStarted() {
        }

@Override
public void onError(YouTubePlayer.ErrorReason arg0) {
        }

@Override
public void onLoaded(String arg0) {
        }

@Override
public void onLoading() {
        }

@Override
public void onVideoEnded() {
        }

@Override
public void onVideoStarted() {
        }
        };


@Override
public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Toast.makeText(getApplicationContext(), "Fail to Initialize!", Toast.LENGTH_LONG).show();
        }
}
