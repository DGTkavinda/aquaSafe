package com.example.narmal.aquasafe_prototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by narmal on 5/12/2017.
 */
public class WebApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.addJavascriptInterface(new Interface(this), "android");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://app.ubidots.com/ubi/public/getdashboard/2N3RCMfgL_w_6U9GCp2a2lAGhuc");

    }
}
