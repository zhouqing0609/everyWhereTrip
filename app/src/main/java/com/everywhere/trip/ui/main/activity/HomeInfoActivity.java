package com.everywhere.trip.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.everywhere.trip.R;
import com.everywhere.trip.bean.MainDataInfo;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.ui.main.adapter.RecMainInfoAdapter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeInfoActivity extends AppCompatActivity {


    private static final String TAG = "HomeInfoActivity";
    private MainDataInfo.ResultEntity resultEntity;
    private RecMainInfoAdapter adapter;
    private ImageView mHomeBack;
    private ImageView mHomeShare;
    private Toolbar mHomeToobar;
    private RecyclerView mHoneRlv;
    private String token = "mKVoQRrXlMvmfWbgWzyDYHF1KOUN5e4bwWrOiab9tZ8sWIQAZmg48lSa2NOORqpko6V0l4cYCs1Uip23M6MglE6Xp6LvHKO9RUNP4m8pHjp1zHb8nmK1bU1pvRp2LFkwA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_info);
        initView();


    }


    private void initView() {

        mHomeBack = (ImageView) findViewById(R.id.home_back);
        mHomeShare = (ImageView) findViewById(R.id.home_share);
        mHomeToobar = (Toolbar) findViewById(R.id.home_toobar);
        mHoneRlv = (RecyclerView) findViewById(R.id.hone_Rlv);


        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 1);
        initData(token,id);
    }

    private void initData(String token,int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EveryWhereService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EveryWhereService everyWhereService = retrofit.create(EveryWhereService.class);
        Observable<MainDataInfo> road = everyWhereService.getRoad(token, id);
        road.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<MainDataInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainDataInfo mainDataInfo) {
                        resultEntity = mainDataInfo.getResult();
                        adapter = new RecMainInfoAdapter(HomeInfoActivity.this,resultEntity);
                        mHoneRlv.setAdapter(adapter);
                        mHoneRlv.setLayoutManager(new LinearLayoutManager(HomeInfoActivity.this));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getMessage() );
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
