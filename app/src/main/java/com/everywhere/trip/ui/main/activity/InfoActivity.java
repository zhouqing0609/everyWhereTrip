package com.everywhere.trip.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.ui.main.adapter.MyViewPagerAdapter;
import com.everywhere.trip.ui.main.fragment.MoveFragment;
import com.everywhere.trip.ui.main.fragment.RoadFragment;
import com.everywhere.trip.util.GlideUtil;
import com.everywhere.trip.widget.NoScrollViewPager;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    private ImageView mMyBack;
    private ImageView mInfoShare;
    private RelativeLayout mInfoItem;
    private Toolbar mInfoToobar;
    private ImageView mInfoHead;
    private TextView mInfoName;
    private ImageView mInfoHeart;
    private ImageView mInfoLocationiv;
    private TextView mInfoLocation;
    private TextView mInfoAuthor;
    private TextView mInfoInfo;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private ArrayList<String> title;
    private MyViewPagerAdapter adapter;

    private NoScrollViewPager mInfoVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();
    }

    private void initView() {
        mMyBack = (ImageView) findViewById(R.id.info_back);
        mInfoShare = (ImageView) findViewById(R.id.info_share);
        mInfoToobar = (Toolbar) findViewById(R.id.info_toobar);
        mInfoHead = (ImageView) findViewById(R.id.info_head);
        mInfoName = (TextView) findViewById(R.id.info_name);
        mInfoHeart = (ImageView) findViewById(R.id.info_heart);
        mInfoLocationiv = (ImageView) findViewById(R.id.info_locationiv);
        mInfoLocation = (TextView) findViewById(R.id.info_location);
        mInfoAuthor = (TextView) findViewById(R.id.info_author);
        mInfoInfo = (TextView) findViewById(R.id.info_info);
        mTab = (TabLayout) findViewById(R.id.info_tab);

        mInfoVp = (NoScrollViewPager) findViewById(R.id.info_vp);

        initListener();
        list = new ArrayList<>();
        list.add(new MoveFragment());
        list.add(new RoadFragment());

        title = new ArrayList<>();
        title.add("动态");
        title.add("路线");

        adapter = new MyViewPagerAdapter(getSupportFragmentManager(),list,title);
        mInfoVp.setAdapter(adapter);
        mTab.setupWithViewPager(mInfoVp);


    }


    private void initListener() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String auther = intent.getStringExtra("auther");
        String info = intent.getStringExtra("info");
        String location = intent.getStringExtra("location");
        String img = intent.getStringExtra("img");

        GlideUtil.loadUrlRoundImg(10, R.mipmap.zhanweitu_home_kapian, img, mInfoHead, this);
        mInfoName.setText(name);
        mInfoAuthor.setText(auther);
        mInfoInfo.setText(info);
        mInfoLocation.setText(location);

        mMyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
