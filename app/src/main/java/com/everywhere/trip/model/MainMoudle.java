package com.everywhere.trip.model;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;

import io.reactivex.disposables.Disposable;

public class MainMoudle extends BaseModel{

    public void getData(int page,String token, final ResultCallBack<MainDataBean> callBack) {
        EveryWhereService apiserver = HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL, EveryWhereService.class);
        apiserver.getMainData(page,token)
                .compose(RxUtils.<MainDataBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<MainDataBean>() {
                    @Override
                    public void onNext(MainDataBean mainDataBean) {
                        callBack.onSuccess(mainDataBean);
                    }

                    @Override
                    public void error(String msg) {

                    }

                    @Override
                    protected void subscribe(Disposable d) {

                    }
                });
    }
}
