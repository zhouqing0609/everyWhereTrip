package com.everywhere.trip.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.everywhere.trip.R;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.ui.main.adapter.AndroidInterface;
import com.just.agentweb.AgentWeb;

public class WebViewJs extends AppCompatActivity {
    private ImageView mWebShare;
    private Toolbar mWebToobar;
    private TextView mTvTitle;
    private AgentWeb mAgentWeb;
    private LinearLayout mWebLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_js);
        initView();
    }

    private void initView() {
        mWebShare = (ImageView) findViewById(R.id.web_share);
        mWebToobar = (Toolbar) findViewById(R.id.web_toobar);
        mTvTitle = (TextView) findViewById(R.id.tvTitle);
        mWebLl = (LinearLayout) findViewById(R.id.web_ll);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        mWebToobar.setTitle("");
        mTvTitle.setText(title);
        mWebToobar.setNavigationIcon(R.mipmap.back_white);

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) mWebLl, new LinearLayout.LayoutParams(-1, -1))
                .closeIndicator()
                .createAgentWeb()
                .ready()
                .go(url+"?os=android");
        mAgentWeb.getJsInterfaceHolder().addJavaObject("android", new AndroidInterface(mAgentWeb, this));
        initListener();
    }

    private void initListener() {
        mWebToobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WebViewJs.this, MainActivity.class));
                finish();
            }
        });
    }
}
