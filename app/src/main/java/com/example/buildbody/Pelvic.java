package com.example.buildbody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class Pelvic extends AppCompatActivity{

    ImageView img1,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelvic);

        initialise();
        setListener();




    }

    public void initialise() {
        img1 = findViewById(R.id.imge1);
        img2=findViewById(R.id.imge2);

    }

    public void setListener(){
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LyingTwist.class);
                startActivity(intent);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SideLying.class);
                startActivity(intent);
            }
        });
    }

}
