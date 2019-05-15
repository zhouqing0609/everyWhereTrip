package com.everywhere.trip.presenter;

import android.util.Log;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.Banmi;
import com.everywhere.trip.model.SecondMoudle;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;
import com.everywhere.trip.view.main.SecondView;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.disposables.Disposable;


public class SecondPresenter extends BasePresenter<SecondView> {
    private SecondMoudle mSecondMoudle;

    @Override
    protected void initModel() {
        mSecondMoudle = new SecondMoudle();
        mModels.add(mSecondMoudle);
    }


    public void getBanmiData(int page,String token) {
        mSecondMoudle.getBanmiDate(page, token, new ResultCallBack<Banmi>() {
            @Override
            public void onSuccess(Banmi bean) {
                mMvpView.getSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.getFailed(msg);
            }
        });
    }

    public void addLike(String token,int id){
        mSecondMoudle.addLike(token, id, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                mMvpView.toastShort(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.toastShort(msg);
            }
        });
    }

    public void disLike(String token,int id){
        mSecondMoudle.disLike(token, id, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                mMvpView.toastShort(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.toastShort(msg);
            }
        });
    }
}
