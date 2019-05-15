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
import com.everywhere.trip.bean.MoveBean;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.ui.main.adapter.MoveAdapter;

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
 * caused by zq
 * @author  zq
 * A simple {@link Fragment} subclass.
 */
public class MoveFragment extends Fragment {
    private RecyclerView move_rlv;
    public MoveFragment() {
        // Required empty public constructor
    }

    private String toktn = "mKVoQRrXlMvmfWbgWzyDYHF1KOUN5e4bwWrOiab9tZ8sWIQAZmg48lSa2NOORqpko6V0l4cYCs1Uip23M6MglE6Xp6LvHKO9RUNP4m8pHjp1zHb8nmK1bU1pvRp2LFkwA";

    private ArrayList<MoveBean.ResultBean.ActivitiesBean> list;
    private MoveAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_move, container, false);
        initView(inflate);
        return inflate;
    }


    private void initView(View inflate) {
        move_rlv = (RecyclerView) inflate.findViewById(R.id.move_rlv);

        list = new ArrayList<>();
        adapter = new MoveAdapter(getActivity());

        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("id", 1);
        Log.e("MoveFragment", "initView: "+id );
        initData(toktn,id);
    }

    private void initData(String token,int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EveryWhereService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        EveryWhereService everyWhereService = retrofit.create(EveryWhereService.class);
        Observable<MoveBean> moveInfo = everyWhereService.getMoveInfo(toktn,id,1);
        moveInfo.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<MoveBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MoveBean mainDataBean) {
                        List<MoveBean.ResultBean.ActivitiesBean> activities = mainDataBean.getResult().getActivities();
                        Log.e("MoveFragment", "onNext: "+activities.size() );
                        list.addAll(activities);
                        adapter.setList(list);
                        move_rlv.setAdapter(adapter);
                        LinearLayoutManager manager = new LinearLayoutManager(getActivity()){
                            @Override
                            public boolean canScrollVertically() {
                                return false;
                            }
                        };
                        move_rlv.setLayoutManager(manager);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("----------------", "onError: "+e.getMessage() );
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
