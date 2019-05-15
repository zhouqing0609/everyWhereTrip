package com.everywhere.trip.ui.main.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.everywhere.trip.R;
import com.everywhere.trip.bean.Banmi;
import com.everywhere.trip.bean.FollowedBanmi;
import com.everywhere.trip.bean.LikeBean;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.ui.main.adapter.GuanzhuAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuanzhuActivity extends AppCompatActivity {

    private RecyclerView guanzhu_rlv;
    private ArrayList<FollowedBanmi.ResultBean.BanmiBean> list;
    private GuanzhuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guanzhu);
        initView();

    }

    private void initView() {
        guanzhu_rlv = (RecyclerView) findViewById(R.id.guanzhu_rlv);


        initData("mKVoQRrXlMvmfWbgWzyDYHF1KOUN5e4bwWrOiab9tZ8sWIQAZmg48lSa2NOORqpko6V0l4cYCs1Uip23M6MglE6Xp6LvHKO9RUNP4m8pHjp1zHb8nmK1bU1pvRp2LFkwA",1);

    }


    private void initData(String token,int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EveryWhereService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EveryWhereService home = retrofit.create(EveryWhereService.class);
        Observable<FollowedBanmi> followedBanmiData = home.getCollectData(token,page);
        followedBanmiData.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<FollowedBanmi>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FollowedBanmi banmi) {
                        List<FollowedBanmi.ResultBean.BanmiBean> banmi1 = banmi.getResult().getBanmi();
                        list = new ArrayList<>();
                        adapter = new GuanzhuAdapter(GuanzhuActivity.this);
                        guanzhu_rlv.setAdapter(adapter);
                        guanzhu_rlv.setLayoutManager(new LinearLayoutManager(GuanzhuActivity.this));

                        list.addAll(banmi1);
                        Log.e("onNext", "onNext: "+banmi1.size() );
                        adapter.setList(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("===========", "onError: "+e.getMessage() );
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
