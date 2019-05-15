package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.LoginInfo;
import com.everywhere.trip.model.MainDataBean;
import com.everywhere.trip.model.MainMoudle;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.MainView;

public class MainPresenter extends BasePresenter<MainView> {
    private MainMoudle mainMoudle;

    @Override
    protected void initModel() {
        mainMoudle = new MainMoudle();
        mModels.add(mainMoudle);
    }

    public void getData(String token,int page) {
        mainMoudle.getData(page,token,new ResultCallBack<MainDataBean>() {
            @Override
            public void onSuccess(MainDataBean bean) {
                mMvpView.getSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.getFailed(msg);
            }
        });
    }
}
