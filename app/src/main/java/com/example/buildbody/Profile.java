package com.example.buildbody;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity {
    TextInputLayout name,age,gender,email,phone,date;
    TextInputEditText nameedit,agedit,emailedit,phonedit,datedit,genderedit;
    Button edit,save;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    String name1="",name2="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initialise();
        setListener();
        fetchdata();

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

    }

    public void initialise(){
        edit=findViewById(R.id.edit);
        save=findViewById(R.id.save);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        gender=findViewById(R.id.gender1);
        nameedit=findViewById(R.id.nameedit);
        agedit=findViewById(R.id.ageedit);
        datedit=findViewById(R.id.dobedit);
        genderedit=findViewById(R.id.genderedit);
        emailedit=findViewById(R.id.emailedit);
        phonedit=findViewById(R.id.phonedit);
        email=findViewById(R.id.email1);
        phone=findViewById(R.id.phone1);
        date=findViewById(R.id.phone1);
        db = FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();
    }

    public void setListener() {






        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameedit.setEnabled(false);
                agedit.setEnabled(false);
                phonedit.setEnabled(false);
                genderedit.setEnabled(false);
                datedit.setEnabled(false);
                phonedit.setEnabled(false);
                emailedit.setEnabled(false);

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameedit.setEnabled(true);
                agedit.setEnabled(true);
                phonedit.setEnabled(true);
                genderedit.setEnabled(true);
                emailedit.setEnabled(true);
                datedit.setEnabled(true);
                phonedit.setEnabled(true);
            }
        });





    }

    public void fetchdata(){


        CollectionReference users = db.collection("users");

        DocumentReference docRef = db.collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        emailedit.setText(document.getString("email"));
                        agedit.setText(document.getString("age"));
                        phonedit.setText(document.getString("contact"));
                        genderedit.setText(document.getString("gender"));
                        datedit.setText(document.getString("birth date"));
                        name1=(document.getString(" first name"));
                        name2 =(document.getString("last name"));
                        String fullname = name1.concat(name2);
                        nameedit.setText(fullname);

                    } else {
                        Toast.makeText(Profile.this, " Record Not Found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d("tag", "Cannot fetch the details ", task.getException());
                }
            }
        });
    }

}
