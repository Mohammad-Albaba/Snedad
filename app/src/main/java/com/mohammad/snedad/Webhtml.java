package com.mohammad.snedad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class Webhtml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webhtml);
        WebView webView=(WebView)findViewById(R.id.webview);
        Intent data=getIntent();
        int page=data.getExtras().getInt("page");
        page++;
        webView.loadUrl("file:///android_asset/html/"+ page +".html");
    }
}
