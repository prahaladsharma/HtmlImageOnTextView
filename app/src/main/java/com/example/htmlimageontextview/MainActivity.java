package com.example.htmlimageontextview;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView webViewText;
    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        webViewText = (TextView) findViewById(R.id.webView);

        /**
         * In this demo we are showing image on textview from html with the help of HtmlFrom.
         */
        callHtmlImagePreview();


    }

    private void callHtmlImagePreview() {
        try{
            UrlImageParser imageGetter = new UrlImageParser(webViewText, context); // Call Image loader class
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //scrollView.scrollTo(0, 100);
                webViewText.setMovementMethod(LinkMovementMethod.getInstance());
                webViewText.setText(Html.fromHtml(Utility.page_body, Html.FROM_HTML_MODE_LEGACY, imageGetter, null));
            } else {
                //scrollView.scrollTo(0, 100);
                webViewText.setMovementMethod(LinkMovementMethod.getInstance());
                webViewText.setText(Html.fromHtml(Utility.page_body, imageGetter, null));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}