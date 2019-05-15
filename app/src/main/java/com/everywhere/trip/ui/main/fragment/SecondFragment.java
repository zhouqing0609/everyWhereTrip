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
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.Banmi;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.RxUtils;
import com.everywhere.trip.presenter.SecondPresenter;
import com.everywhere.trip.ui.main.activity.InfoActivity;
import com.everywhere.trip.ui.main.adapter.BanmiAdapter;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.SecondView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends BaseFragment<SecondView, SecondPresenter> implements SecondView {


    private static final String TAG = "SecondFragment";
    @BindView(R.id.second_rLv)
    RecyclerView mRlv;

    Unbinder unbinder;
    private ArrayList<Banmi.ResultBean.BanmiBean> list = new ArrayList<>();
    private int page = 1;
    private BanmiAdapter adapter;


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    protected SecondPresenter initPresenter() {
        return new SecondPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
    }


    @Override
    protected void initView() {
        super.initView();
        adapter = new BanmiAdapter(getActivity());
    }

    @Override
    protected void initData() {
        super.initData();

        String param = (String) SpUtil.getParam(Constants.TOKEN, "");
        String token = "mKVoQRrXlMvmfWbgWzyDYHF1KOUN5e4bwWrOiab9tZ8sWIQAZmg48lSa2NOORqpko6V0l4cYCs1Uip23M6MglE6Xp6LvHKO9RUNP4m8pHjp1zHb8nmK1bU1pvRp2LFkwA";
        mPresenter.getBanmiData(page,token);
    }

    @Override
    public void getSuccess(Banmi banmi) {
        List<Banmi.ResultBean.BanmiBean> banmi1 = banmi.getResult().getBanmi();
        list.addAll(banmi1);

        adapter.setList(list);
        mRlv.setAdapter(adapter);
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void getFailed(String info) {
        Log.d("SecondFragment", "getFailed: "+info);
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setLike(new BanmiAdapter.setClickLike() {
            @Override
            public void setLike(int position) {
                mPresenter.addLike("mKVoQRrXlMvmfWbgWzyDYHF1KOUN5e4bwWrOiab9tZ8sWIQAZmg48lSa2NOORqpko6V0l4cYCs1Uip23M6MglE6Xp6LvHKO9RUNP4m8pHjp1zHb8nmK1bU1pvRp2LFkwA",position);
            }

            @Override
            public void remove(int id) {
                mPresenter.disLike("mKVoQRrXlMvmfWbgWzyDYHF1KOUN5e4bwWrOiab9tZ8sWIQAZmg48lSa2NOORqpko6V0l4cYCs1Uip23M6MglE6Xp6LvHKO9RUNP4m8pHjp1zHb8nmK1bU1pvRp2LFkwA",id);
            }
        });

        adapter.setClick(new BanmiAdapter.setOnClick() {
            @Override
            public void setClick(View v, int position) {
                Intent intent = new Intent(getActivity(), InfoActivity.class);
                Banmi.ResultBean.BanmiBean banmiBean = list.get(position);
                intent.putExtra("name",banmiBean.getName());
                intent.putExtra("location",banmiBean.getLocation());
                intent.putExtra("auther",banmiBean.getOccupation());
                intent.putExtra("info",banmiBean.getIntroduction());
                intent.putExtra("img",banmiBean.getPhoto());
                intent.putExtra("id",banmiBean.getId());
                startActivity(intent);
            }
        });
    }
}
