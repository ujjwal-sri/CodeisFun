package com.example.hp.releaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webview;

    public class GeoWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public class GeoWebChromeClient extends WebChromeClient {
        @Override
        public void onGeolocationPermissionsShowPrompt(String origin,
                                                       GeolocationPermissions.Callback callback) {
            // Always grant permission since the app itself requires location
            // permission and the user has therefore already granted it
            callback.invoke(origin, true, false);
        }
    }

    public String fileName = "MapSearch.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init webView
        webview =(WebView)findViewById(R.id.simpleWebView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setDomStorageEnabled(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.setWebViewClient(new GeoWebViewClient());
        // Below required for geolocation
        webview.getSettings().setJavaScriptEnabled(true);
        // webview.getSettings().setJavaScriptEnabled(false);
        webview.getSettings().setGeolocationEnabled(true);
        webview.setWebChromeClient(new GeoWebChromeClient());
        webview.loadUrl("file:///android_asset/MapSearch.html");
    }
    @Override
    public void onBackPressed() {
        // Pop the browser back stack or exit the activity
        if (webview.canGoBack()) {
            webview.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
