package com.everywhere.trip.ui.main.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.everywhere.trip.R;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.ui.main.adapter.RoadAdapter;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class RoadFragment extends Fragment {


    private RecyclerView road_rlv;
    private ArrayList<MainDataBean.ResultEntity.RoutesEntity> list;
    private RoadAdapter adapter;
    private RecyclerView mRoadRlv;
    String token = "mKVoQRrXlMvmfWbgWzyDYHF1KOUN5e4bwWrOiab9tZ8sWIQAZmg48lSa2NOORqpko6V0l4cYCs1Uip23M6MglE6Xp6LvHKO9RUNP4m8pHjp1zHb8nmK1bU1pvRp2LFkwA";
    private int id;

    public RoadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_road, container, false);

        initView(inflate);
        return inflate;
    }


    private void initView(View inflate) {
        mRoadRlv = (RecyclerView) inflate.findViewById(R.id.road_rlv);

        Intent intent = getActivity().getIntent();
        id = intent.getIntExtra("id",1);
        list = new ArrayList<>();
        adapter = new RoadAdapter(getActivity());
        Log.e("RoadFragment", "initView: "+id);

        initData(token,1,id);
    }

    private void initData(String token,int page,int _id){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(EveryWhereService.BASE_URL)
                .build();

        EveryWhereService everyWhereService = retrofit.create(EveryWhereService.class);
        Observable<MainDataBean> roadInfo = everyWhereService.getRoadInfo(token, _id, 1);
        roadInfo.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<MainDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainDataBean mainDataBean) {
                        List<MainDataBean.ResultEntity.RoutesEntity> routes = mainDataBean.getResult().getRoutes();
                        list.addAll(routes);
                        Log.e("RoadFragment", "onNext: "+routes.size()+"=======");

                        adapter.setList(list);
                        mRoadRlv.setAdapter(adapter);
                        LinearLayoutManager manager = new LinearLayoutManager(getActivity()){
                            @Override
                            public boolean canScrollVertically() {
                                return false;
                            }
                        };
                        mRoadRlv.setLayoutManager(manager);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RoadFragment", "onError: "+e.getMessage() );
                    }

                    @Override
                    public void onComplete() {
                        Log.e("RoadFragment", "onComplete: " );
                    }
                });

    }
}
