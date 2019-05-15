package com.example.androidjs;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button Btn1;
    private Button Btn2;
    private WebView web;
    private String mMsg = "来了老弟";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Btn1 = (Button) findViewById(R.id.Btn1);
        Btn2 = (Button) findViewById(R.id.Btn2);
        web = (WebView) findViewById(R.id.web);

        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);


        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl("file:///android_asset/test.html");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Btn1:
                //调用JS方法 调用方是固定的
                web.loadUrl("javascript:callJs('" + mMsg + "')");
                break;
            case R.id.Btn2:
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
                    web.evaluateJavascript("javascript:callJs('" + mMsg + "')", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                break;
        }
    }
}
