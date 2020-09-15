package com.example.newsapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;


public class splashfile extends Activity {
    ProgressBar progressBar;
    Handler handler;
    private FirebaseAuth auth;
    private final int Splash_Length = 3000;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashfile);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            /*startActivity(new Intent(SpalshActivity.this, Content.class));
            finish();*/
            progressBar.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(splashfile.this,MainActivity.class);
                    splashfile.this.startActivity(mainIntent);
                   // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }, Splash_Length);
        }
        else {
            progressBar.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(splashfile.this,LoginActivity.class);
                    splashfile.this.startActivity(mainIntent);
                   // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    splashfile.this.finish();
                }
            }, Splash_Length);

        }

    }
}
