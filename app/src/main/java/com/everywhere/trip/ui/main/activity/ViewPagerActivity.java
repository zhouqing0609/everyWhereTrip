package com.everywhere.trip.ui.main.activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.everywhere.trip.R;
import com.everywhere.trip.util.PreviewIndicator;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager view_vp;
    private ArrayList<View> list;
    private PreviewIndicator pre;
    private Button _bt;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        StatusBarUtil.setLightMode(this);
        initView();
    }

    private void initView() {
        view_vp = (ViewPager) findViewById(R.id.view_vp);

        _bt = (Button) findViewById(R.id.bt_vp);
        _bt.setOnClickListener(this);
        _bt.setVisibility(View.INVISIBLE);


        sp = getSharedPreferences("123", MODE_PRIVATE);
        boolean aBoolean = sp.getBoolean("123", false);
        if (aBoolean) {
            startActivity(new Intent(ViewPagerActivity.this, LoginActivity.class));
            finish();
        }


        list = new ArrayList<>();
        View vp1 = View.inflate(this, R.layout.layout_vp1, null);
        View vp2 = View.inflate(this, R.layout.layout_vp2, null);
        View vp3 = View.inflate(this, R.layout.layout_vp3, null);


        list.add(vp1);
        list.add(vp2);
        list.add(vp3);

        view_vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {

                View view = list.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

                container.removeView((View) object);
            }


        });

        pre = (PreviewIndicator) findViewById(R.id.pre);
        view_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pre.setSelected(position);
                if (position == 2) {
                    _bt.setVisibility(View.VISIBLE);
                    pre.setVisibility(View.INVISIBLE);
                }else if (position==0  || position==1){
                    _bt.setVisibility(View.GONE);
                    pre.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_vp:
                Intent intent = new Intent(ViewPagerActivity.this, LoginActivity.class);
                startActivity(intent);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("123", true);
                edit.commit();
                finish();
                break;
        }
    }
}
