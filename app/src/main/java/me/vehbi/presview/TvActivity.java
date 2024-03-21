package me.vehbi.presview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class TvActivity extends Activity {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /* Make the activity full screen */
        setContentView(R.layout.activity_tv);

        if (getActionBar() != null) {
            /* Hide the action bar if it exists */
            getActionBar().hide();
        }
        /* Get the WebView from the layout */
        WebView webView = findViewById(R.id.webview);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if (Constants.REFRESH_INTERVAL <= 0) return;
                view.postDelayed(webView::reload, Constants.REFRESH_INTERVAL * 1000);
            }
        });

        /* Set the WebView settings */
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.setKeepScreenOn(true);

        /* Finally, load the URL */
        webView.loadUrl(Constants.URL);
    }
}
