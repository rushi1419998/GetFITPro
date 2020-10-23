package com.example.buildbody;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;


public class Home extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    YouTubePlayerView youTubeView ;
    public static final String API_KEY = "AIzaSyBkzvTpG4fnjV9ZPRgvHywtdelH8r5eZnY";

    Button trainer,bmi,profile,signout;
    ImageView deskjob,warm,posture,bodyweight;


    private TextView mTextMessage;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {

                case R.id.trainer:
                    mTextMessage.setText("Trainer");
                    Intent intent = new Intent(getApplicationContext(),Trainer.class);
                    startActivity(intent);
                    return true;

                case R.id.bmi:
                    mTextMessage.setText("BMI");
                    Intent intent1 = new Intent(getApplicationContext(),BMI.class);
                    startActivity(intent1);
                    return true;

                case R.id.profile:
                    mTextMessage.setText("Profile");
                    Intent intent2 = new Intent(getApplicationContext(),Profile.class);
                    startActivity(intent2);
                    return true;

                case R.id.signout:
                    mTextMessage.setText("Sign Out");
                    Intent intent3 = new Intent(getApplicationContext(),SignUp.class);
                    startActivity(intent3);
                    return true;
            }
            return false;
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initialise();
        setListener();


        youTubeView.initialize(API_KEY, (YouTubePlayer.OnInitializedListener) this);



    }




    public void initialise(){
        youTubeView= findViewById(R.id.youtubePlayerView);
        trainer=findViewById(R.id.trainer);
        warm=findViewById(R.id.warm);
        bmi=findViewById(R.id.bmi);
        profile=findViewById(R.id.profile);
        signout=findViewById(R.id.signout);
        bodyweight=findViewById(R.id.weight);
        posture=findViewById(R.id.posture);
        deskjob=findViewById(R.id.deskjob);
        BottomNavigationView navView=findViewById(R.id.navigation);
        mTextMessage = (TextView) findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean b) {


                player.setPlayerStateChangeListener(playerStateChangeListener);
                player.setPlaybackEventListener(playbackEventListener);

                /** Start buffering **/
                if (!b) {
                    player.cueVideo("GS_z6FG_jqE");
                }
            };

                 PlaybackEventListener playbackEventListener = new PlaybackEventListener() {

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

                PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {

                    @Override
                    public void onAdStarted() {
                    }

                    @Override
                    public void onError(ErrorReason arg0) {
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
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Toast.makeText(getApplicationContext(), "Fail to Initialize!", Toast.LENGTH_LONG).show();
            }









    public void setListener(){


                bodyweight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),Bodyweight.class);
                        startActivity(intent);
                    }
                });

                warm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),Warm.class);
                        startActivity(intent);
                    }
                });

                posture.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),Posture.class);
                        startActivity(intent);
                    }
                });

                deskjob.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),DeskJob.class);
                        startActivity(intent);
                    }
                });
                trainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),Trainer.class);
                        startActivity(intent);
                    }
                });
                bmi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),BMI.class);
                        startActivity(intent);
                    }
                });

                profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),Profile.class);
                        startActivity(intent);
                    }
                });
                signout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                });



    }



}
