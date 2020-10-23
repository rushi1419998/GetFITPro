package com.example.buildbody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Posture extends AppCompatActivity {

    ImageView pelvic,bow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posture);
        initialise();
        setListener();

    }

    public void initialise(){
        pelvic=findViewById(R.id.pelvic);
        bow=findViewById(R.id.bow);

    }

    public void setListener(){
        pelvic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Pelvic.class);
                startActivity(intent);
            }
        });

        bow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Bow.class);
                startActivity(intent);
            }
        });
    }
}
