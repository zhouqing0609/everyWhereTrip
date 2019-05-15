package com.everywhere.trip.ui.main.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.model.MainDataBean;
import com.everywhere.trip.presenter.MainPresenter;
import com.everywhere.trip.ui.main.adapter.MyViewPagerAdapter;
import com.everywhere.trip.ui.main.fragment.FirstFragment;
import com.everywhere.trip.ui.main.fragment.SecondFragment;
import com.everywhere.trip.util.SPutils;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.MainView;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {


    @BindView(R.id.main_vp)
    ViewPager mainVp;
    @BindView(R.id.main_tab)
    TabLayout mainTab;
    @BindView(R.id.main_item)
    RelativeLayout mainItem;
    @BindView(R.id.na)
    NavigationView na;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.main_head)
    ImageView mainHead;


    private ArrayList<Fragment> list;
    private ArrayList<String> title;
    private MyViewPagerAdapter adapter;
    private TextView tvMain;
    private TextView tvBanmi;
    private String uid;
    private TextView myName;
    private TextView mySign;
    private DrawerLayout drawerLayout;
    private LinearLayout guanzhu;
    private int th = 0;


    public static void startAct(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        super.initView();
        StatusBarUtil.setLightMode(this);
    }

    @Override
    protected void initListener() {
        super.initListener();

        list = new ArrayList<>();
        list.add(new FirstFragment());
        list.add(new SecondFragment());

        title = new ArrayList<>();
        title.add("半米");
        title.add("旅行");
        drawerLayout = this.findViewById(R.id.dl);
        View headerView = na.getHeaderView(0);
        View tv = headerView.findViewById(R.id.main_write);
        guanzhu = headerView.findViewById(R.id.main_guanzhu);
        guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GuanzhuActivity.class);
                startActivity(intent);
            }
        });


        myName = headerView.findViewById(R.id.name_my);
        mySign = headerView.findViewById(R.id.sign_my);


        myName.setText("林小姐");
        mySign.setText("四肢不劳五题不勤");




        if (th==1){
            SPutils.put(this, "name1", myName.getText());
            SPutils.put(this, "sign1", mySign.getText());

        }
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyActivity.class);
                intent.putExtra("name1",myName.getText());
                intent.putExtra("sign1",mySign.getText());
                Log.e("sssssssssssss", "onClick: "+myName.getText()+mySign.getText());
                startActivityForResult(intent, 190);
            }
        });


        adapter = new MyViewPagerAdapter(getSupportFragmentManager(), list, title);
        mainVp.setAdapter(adapter);
        mainTab.setupWithViewPager(mainVp);

        mainTab.getTabAt(0).setCustomView(R.layout.layout_home);
        mainTab.getTabAt(1).setCustomView(R.layout.layout_banmi);

        tvMain = (TextView) mainTab.getTabAt(0).getCustomView().findViewById(R.id.tv_home);
        tvBanmi = (TextView) mainTab.getTabAt(1).getCustomView().findViewById(R.id.tv_banmi);

        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tvMain.setTextColor(getResources().getColor(R.color.c_fa6a13));
                        if (tvBanmi != null) {
                            tvBanmi.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        break;
                    case 1:
                        if (tvBanmi == null) {
                            tvBanmi = (TextView) tab.getCustomView().findViewById(R.id.tv_banmi);
                        }
                        if (tvMain != null) {
                            tvMain.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        tvBanmi.setTextColor(getResources().getColor(R.color.c_fa6a13));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected void initData() {
        super.initData();

    }


    @Override
    public void toastShort(String msg) {

    }


    @Override
    public void getSuccess(MainDataBean mainDataBean) {

    }

    @Override
    public void getFailed(String info) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 190 && resultCode == 201) {
            String name = data.getStringExtra("name");
            String sign = data.getStringExtra("sign");
            Log.e("====================", "onActivityResult: "+name );
            Log.e("====================", "onActivityResult: "+sign );

            SPutils.put(this, "name", name);
            SPutils.put(this, "sign",sign);

            myName.setText(name);
            mySign.setText(sign);
        }
    }

    @OnClick(R.id.main_head)
    public void onViewClicked() {
        drawerLayout.openDrawer(Gravity.LEFT);

    }




    @Override
    protected void onStart() {
        super.onStart();
        th = th+1;
        if (th==1){


            myName.setText((String) SPutils.get(this, "name1",""));
            mySign.setText(SPutils.get(this, "sign1", "").toString());
        }
        String name = SPutils.get(this, "name", "").toString();
        String sign = SPutils.get(this, "sign", "").toString();
        myName.setText(name);
        mySign.setText(sign);
        Log.e("hsiuhsiu", "onStart: "+ name+sign+th);

    }
}
