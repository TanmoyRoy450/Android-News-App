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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import customfonts.EditTextSFProDisplayRegular;


public class SignUpActivity extends AppCompatActivity {
    Button mlog;
    private EditTextSFProDisplayRegular memail_reg, mpass_reg;
    private Button Msign_up;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        Msign_up = (Button) findViewById(R.id.sign_up);
        mlog = (Button) findViewById(R.id.log);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        memail_reg = (EditTextSFProDisplayRegular) findViewById(R.id.email_reg);
        mpass_reg = (EditTextSFProDisplayRegular) findViewById(R.id.pass_reg);

        Msign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_reg = memail_reg.getText().toString();
                String pass_reg = mpass_reg.getText().toString();

                if (TextUtils.isEmpty(email_reg)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass_reg)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pass_reg.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email_reg, pass_reg)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignUpActivity.this, "You have been successfully registered!" +" "+
                                        "Log In to Continue", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(SignUpActivity.this, LoginThreeActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });

        mlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, LoginThreeActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}