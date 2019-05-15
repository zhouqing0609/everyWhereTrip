package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

import com.everywhere.trip.base.Constants;
import com.everywhere.trip.ui.main.activity.HomeInfoActivity;
import com.everywhere.trip.ui.main.activity.WebViewJs;
import com.just.agentweb.AgentWeb;

public class AndroidInterface {

    private AgentWeb agentWeb;
    Context context;

    public AndroidInterface(AgentWeb agentWeb, Context context) {
        this.agentWeb = agentWeb;
        this.context = context;
    }

    @JavascriptInterface
    public void callAndroid(String type, int id) {
//        callAndroid('route_details', id)
        Intent intent = new Intent(context, HomeInfoActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    @JavascriptInterface
    public void callAndroid(String type) {
//        callAndroid('route_details', id)
        context.startActivity(new Intent(context, WebViewJs.class));
    }
}
