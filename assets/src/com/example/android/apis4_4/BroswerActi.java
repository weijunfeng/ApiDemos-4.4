package com.example.android.apis4_4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by hexin on 2017/2/26.
 */
public class BroswerActi extends Activity {

    private WebView webView;

    public static Intent getJumpIntent(Context context, String url) {
        Intent intent = new Intent(context, BroswerActi.class);
        intent.putExtra("url", url);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this.getApplicationContext());
        setContentView(webView);
        webView.loadUrl(getIntent().getStringExtra("url"));
//        webView.loadDataWithBaseURL(null, content,"text/html","utf-8",null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.stopLoading();
        webView.removeAllViews();
        webView.destroy();
        webView = null;
    }
}
