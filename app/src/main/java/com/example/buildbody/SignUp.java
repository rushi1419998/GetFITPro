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

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    EditText useredit,lastname,birthdate,contact,emailedit,passedit,cpassedit,ageedit,genderedit;
    TextInputLayout contacttext,emailtext,pass,cpass;
    Button signup;
    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    ImageView imageView;
    Handler handler = new Handler();
    Map<String, Object> userdetails = new HashMap<>();
    int[] imageArray={R.drawable.home1,R.drawable.home2,R.drawable.home3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
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
        useredit=findViewById(R.id.username);
        pass=findViewById(R.id.passedit);
        cpass=findViewById(R.id.cpassedit);
        contacttext=findViewById(R.id.contact);
        emailtext=findViewById(R.id.emailedit);
        lastname=findViewById(R.id.lastname);
        birthdate=findViewById(R.id.birth);
        contact=findViewById(R.id.phone);
        emailedit=findViewById(R.id.email);
        passedit=findViewById(R.id.password);
        cpassedit=findViewById(R.id.cpassword);
        signup=findViewById(R.id.signup);
        genderedit=findViewById(R.id.gender);
        ageedit=findViewById(R.id.age);
        imageView=findViewById(R.id.imageView);
        mAuth=FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

    }

    public void setListener(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = useredit.getText().toString();
                String userlastname = lastname.getText().toString();
                String birth = birthdate.getText().toString();
                String contactno =contact.getText().toString().trim();
                String password = passedit.getText().toString();
                String cpassword = cpassedit.getText().toString();
                String email = emailedit.getText().toString();
                String gender= genderedit.getText().toString();
                String age = ageedit.getText().toString();



                if((contactno.length())>10){
                    contacttext.setError("Must have 10 digits");
                }


                if((email.length())>30){
                    emailtext.setError("Must be within 30 characters");
                }

                if(((password.length())<6)) {
                    pass.setError("Minimum length should be 6");
                }
                if(((cpassword.length())<6)) { pass.setError("Minimum length should be 6");
                }



                if((!username.equals("")) || (!password.equals("")) || (!cpassword.equals("")) || (!gender.equals(""))){
                    if((Integer.valueOf(age)>16)){
                        if(password.equals(cpassword)){

                            signUpMethod(email,password);
                        }
                        else{
                            Toast.makeText(SignUp.this, "Sorry password didn't match with confirm password", Toast.LENGTH_SHORT).show();
                        }


                    }
                    else{
                        Toast.makeText(SignUp.this, "Sorry age below 16 cannot register", Toast.LENGTH_SHORT).show();
                    }


                }
                else{
                    Toast.makeText(SignUp.this, "Sorry field cannot be empty", Toast.LENGTH_SHORT).show();
                }


                userdetails.put("first name", username);
                userdetails.put("last name",userlastname);
                userdetails.put("birth date",birth);
                userdetails.put("contact",contactno);
                userdetails.put("password", password);
                userdetails.put("email", email);
                userdetails.put("age",age);
                userdetails.put("gender",gender);



            }
        });

    }

    public void signUpMethod(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);


                            db.collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .set(userdetails)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d("TAG", "Data inserted successfully !");
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w("TAG", "Error writing document", e);
                                        }
                                    });

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUp.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });



    }



}
