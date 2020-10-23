package com.example.buildbody;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;

public class MainActivity extends AppCompatActivity {

    TextView signlink,forgot;
    EditText useredit,passedit;
    Button login;
    ImageView imageView;
    private FirebaseAuth mAuth;
    int counter =0 ;
    Handler handler = new Handler();
    int[] imageArray={R.drawable.home1,R.drawable.home2,R.drawable.home3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                imageView.setImageResource(imageArray[i]);
                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);

        initialise();
        setListener();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

    }



    public void initialise(){
        signlink=findViewById(R.id.signlink);
        forgot=findViewById(R.id.forgot);
        useredit=findViewById(R.id.useredit);
        passedit=findViewById(R.id.passedit);
        login=findViewById(R.id.login);
        imageView=findViewById(R.id.imageView);

        mAuth = FirebaseAuth.getInstance();
    }
    public void setListener(){
        signlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= useredit.getText().toString();
                String password= passedit.getText().toString();


                if((!email.equals("")) || (!password.equals(""))) {

                    signIn(email, password);
                }
                else{
                    Toast.makeText(MainActivity.this, "Field cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Forgot.class);
                startActivity(intent);
            }
        });





    }

    public void signIn(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(getApplicationContext(),Home.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(),"Authentication Failed",Toast.LENGTH_LONG).show();

                        }
                    }
                });



    }
}
