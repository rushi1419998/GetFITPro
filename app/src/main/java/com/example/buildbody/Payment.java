package com.example.buildbody;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    Button pay;
    TextInputLayout card,cvv,name,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        pay=findViewById(R.id.paybutton);
        name=findViewById(R.id.holdername);
        card=findViewById(R.id.cardNumber);
        date=findViewById(R.id.expirydate);
        cvv=findViewById(R.id.cvv);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String cname= name.getEditText().getText().toString();
                String cardcvv = cvv.getEditText().getText().toString();
                String cno=card.getEditText().getText().toString();
                String cdate= date.getEditText().getText().toString();

                if(cname.isEmpty() || cdate.isEmpty()){
                    name.setError("Field can't be empty");
                }


                if(cardcvv.isEmpty() || cno.isEmpty()){
                    name.setError("Field can't be empty");
                }

               else if((cname.length()!=16 || cardcvv.length()!=3)){
                    Toast.makeText(Payment.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Payment.this, "Congrats!! Trainer is assigned to you", Toast.LENGTH_SHORT).show();
                }

            }


        });
    }
}
