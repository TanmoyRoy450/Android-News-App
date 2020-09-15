package com.example.newsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import customfonts.EditTextSFProDisplayRegular;

public class ForgotPassActivity extends AppCompatActivity {

    Button mreset, msign;
    EditTextSFProDisplayRegular memail_forgot;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        mreset=(Button) findViewById(R.id.reset);
        msign=(Button) findViewById(R.id.sign);
        memail_forgot=(EditTextSFProDisplayRegular)findViewById(R.id.email_forgot);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        auth=FirebaseAuth.getInstance();

        msign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgotPassActivity.this,LoginThreeActivity.class);
                startActivity(intent);
            }
        });


        mreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = memail_forgot.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgotPassActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ForgotPassActivity.this, "Failed to send email! Please Check the INFORMATION", Toast.LENGTH_LONG).show();
                                }

                                progressBar.setVisibility(View.GONE);
                            }
                        });
            }
        });
    }


}

