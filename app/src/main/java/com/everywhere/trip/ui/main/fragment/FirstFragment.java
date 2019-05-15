package com.everywhere.trip.ui.main.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.model.MainDataBean;
import com.everywhere.trip.presenter.MainPresenter;
import com.everywhere.trip.ui.main.activity.HomeInfoActivity;
import com.everywhere.trip.ui.main.activity.WebViewJs;
import com.everywhere.trip.ui.main.adapter.RecMainAdapter;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseFragment<MainView, MainPresenter> implements MainView {



    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private RecMainAdapter adapter;
    private ArrayList<MainDataBean.ResultEntity.BannersEntity> mBannerlist;
    private ArrayList<MainDataBean.ResultEntity.RoutesEntity> mRouteslist;
    private int page =1;


    public FirstFragment() {
        // Required empty public constructor
    }



    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_first;
    }


    @Override
    protected void initData() {
        super.initData();
        String param = (String) SpUtil.getParam(Constants.TOKEN, "");
        String token = "mKVoQRrXlMvmfWbgWzyDYHF1KOUN5e4bwWrOiab9tZ8sWIQAZmg48lSa2NOORqpko6V0l4cYCs1Uip23M6MglE6Xp6LvHKO9RUNP4m8pHjp1zHb8nmK1bU1pvRp2LFkwA";
        mPresenter.getData( token, page);
    }

    @Override
    public void getSuccess(MainDataBean mainDataBean) {
        mBannerlist = new ArrayList<>();
        mRouteslist = new ArrayList<>();
        adapter = new RecMainAdapter(getActivity());

        List<MainDataBean.ResultEntity.BannersEntity> banners = mainDataBean.getResult().getBanners();
        final List<MainDataBean.ResultEntity.RoutesEntity> routes = mainDataBean.getResult().getRoutes();

        mBannerlist.addAll(banners);
        mRouteslist.addAll(routes);

        adapter.setBanners(mBannerlist);
        adapter.setRoutes(mRouteslist);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));


        adapter.setClik(new RecMainAdapter.setClick() {
            @Override
            public void setClick(View v, int position) {
                MainDataBean.ResultEntity.RoutesEntity routesEntity = mRouteslist.get(position);
                int id = routesEntity.getId();
                Intent intent = new Intent(getActivity(), HomeInfoActivity.class);

                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        adapter.setSetUrl(new RecMainAdapter.seturl() {
            @Override
            public void seturl(String url,int id) {

                MainDataBean.ResultEntity.RoutesEntity routesEntity = mRouteslist.get(id);
                String contentURL = routesEntity.getContentURL();
                String title = routesEntity.getTitle();
                Intent intent = new Intent(getActivity(), WebViewJs.class);


                intent.putExtra("title",title);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });


    }

    @Override
    public void getFailed(String info) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){
            unbinder.unbind();
        }

    }
}
