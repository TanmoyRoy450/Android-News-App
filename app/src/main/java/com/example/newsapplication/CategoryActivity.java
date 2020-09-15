package com.example.newsapplication;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class CategoryActivity extends AppCompatActivity {

    CardView mbbc, mtoi, maaj_tak, mcnbc, mindia_today, mndtv, mindia_times, mhindustan_times;
    private BottomNavigationView mOnNavigationItemSelectedListener;
    //private String ubbc="https://www.bbc.com/news";

    private BottomNavigationView.OnNavigationItemSelectedListener OnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.news:
                    Intent i=new Intent(CategoryActivity.this,MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    break;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.darktheme);
        }
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mbbc=(CardView)findViewById(R.id.bbc);
        mtoi=(CardView)findViewById(R.id.toi);
        maaj_tak=(CardView)findViewById(R.id.aaj_tak);
        mcnbc=(CardView)findViewById(R.id.cnbc);
        mindia_today=(CardView)findViewById(R.id.india_today);
        mndtv=(CardView)findViewById(R.id.ndtv);
        mindia_times=(CardView)findViewById(R.id.india_times);
        mhindustan_times=(CardView)findViewById(R.id.hindustan_times);

        mOnNavigationItemSelectedListener=(BottomNavigationView)findViewById(R.id.navigation);
        mOnNavigationItemSelectedListener.setSelectedItemId(R.id.category);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener);

        mbbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(CategoryActivity.this,WebActivity.class);
                i1.putExtra("id", 1);
                startActivity(i1);
            }
        });

        mtoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(CategoryActivity.this,WebActivity.class);
                i2.putExtra("id",2);
                startActivity(i2);
            }
        });

        maaj_tak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(CategoryActivity.this,WebActivity.class);
                i3.putExtra("id",3);
                startActivity(i3);
            }
        });

        mcnbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(CategoryActivity.this,WebActivity.class);
                i4.putExtra("id",4);
                startActivity(i4);
            }
        });

        mindia_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(CategoryActivity.this,WebActivity.class);
                i5.putExtra("id",5);
                startActivity(i5);
            }
        });

        mndtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(CategoryActivity.this,WebActivity.class);
                i6.putExtra("id",6);
                startActivity(i6);
            }
        });

        mindia_times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7=new Intent(CategoryActivity.this,WebActivity.class);
                i7.putExtra("id",7);
                startActivity(i7);
            }
        });

        mhindustan_times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i8=new Intent(CategoryActivity.this,WebActivity.class);
                i8.putExtra("id",8);
                startActivity(i8);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.action_setting){
            Intent intent=new Intent(CategoryActivity.this,SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
