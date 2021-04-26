 package com.example.internalbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton = findViewById(R.id.searchButton);

        TextView tv = findViewById(R.id.mainTextView);

        WebView wv = (WebView) findViewById(R.id.mainWebView);
        wv.setWebViewClient(new internalClient());

        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);

        wv.loadUrl("file:///android_asset/googleMaps.html");


//        wv.loadUrl("https://yandex.ru");
    }


     @Override
     public void onBackPressed()
     {
         WebView wv = findViewById(R.id.mainWebView);
         if(wv.canGoBack())
             wv.goBack();
         else
             super.onBackPressed();
     }

     private class internalClient extends WebViewClient
     {
         @Override
         public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
         {
             view.loadUrl(request.getUrl().toString());
             return true;
         }
     }
}