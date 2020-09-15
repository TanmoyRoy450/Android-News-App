package com.example.newsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.newsapplication.R;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class WebActivity extends AppCompatActivity {

    private String postUrl = "https://www.bbc.com/news";
    private WebView webView;
    private ProgressBar progressBar;
    private ImageView imgHeader;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        imgHeader = (ImageView) findViewById(R.id.backdrop);

        // initializing toolbar
        initCollapsingToolbar();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.setHorizontalScrollBarEnabled(false);

        Intent ii = getIntent();
        Bundle b = ii.getExtras();
        if (b != null) {
            a = (int) b.get("id");
            if (a==1){
            webView.loadUrl("https://www.bbc.com/news");
                Glide.with(getApplicationContext()).load("https://m.files.bbci.co.uk/modules/" +
                        "bbc-morph-news-waf-page-meta/2.5.2/bbc_news_logo.png")
                        .thumbnail(0.5f)
                        .transition(withCrossFade())
                        .into(imgHeader);
            }

            if (a==2){
                webView.loadUrl("https://timesofindia.indiatimes.com");

                Glide.with(getApplicationContext()).load("https://static.toiimg.com/photo/47529300.cms")
                        .thumbnail(0.5f)
                        .transition(withCrossFade())
                        .into(imgHeader);

            }
            if (a==3){
                webView.loadUrl("https://aajtak.intoday.in");

                Glide.with(getApplicationContext()).load("https://smedia2.intoday.in/aajtak/images/" +
                        "stories/102018/aaj_tak2_1538466852_618x347.png")
                        .thumbnail(0.5f)
                        .transition(withCrossFade())
                        .into(imgHeader);
            }
            if (a==4){
                webView.loadUrl("https://www.cnbc.com");

                Glide.with(getApplicationContext()).load("http://www.kasparov.com/wp-content/uploads/2017/02/cnbccs.jpg")
                        .thumbnail(0.5f)
                        .transition(withCrossFade())
                        .into(imgHeader);
            }
            if (a==5){
                webView.loadUrl("https://www.indiatoday.in");

                Glide.with(getApplicationContext()).load("http://edushine.in/wp-content/uploads/" +
                        "2016/11/indiatoday-e1509972486670-760x550.jpg")
                        .thumbnail(0.5f)
                        .transition(withCrossFade())
                        .into(imgHeader);

            }
            }
            if (a==6){
                webView.loadUrl("https://www.ndtv.com");

                Glide.with(getApplicationContext()).load("https://spiderimg.amarujala.com/assets/images/" +
                        "2018/03/17/750x506/ndtv_1521299352.jpeg")
                        .thumbnail(0.5f)
                        .transition(withCrossFade())
                        .into(imgHeader);
            }
            if (a==7){
                webView.loadUrl("https://www.indiatimes.com");

                Glide.with(getApplicationContext()).load("https://staticresources.indiatimes.in/resources/themes/" +
                        "indiatimes_desktop_default/images/fbimage.png")
                        .thumbnail(0.5f)
                        .transition(withCrossFade())
                        .into(imgHeader);
            }

        if (a==8){
            webView.loadUrl("https://www.hindustantimes.com");

            Glide.with(getApplicationContext()).load("https://encrypted-tbn0.gstatic.com/" +
                    "images?q=tbn:ANd9GcQQr-ZJmPXPXITyuNDPNtcc2lrDFRiIBdrLUj_4_5ReoOmKUu8q")
                    .thumbnail(0.5f)
                    .transition(withCrossFade())
                    .into(imgHeader);
        }
        }


    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar txtPostTitle on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the txtPostTitle when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Univer");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }


}