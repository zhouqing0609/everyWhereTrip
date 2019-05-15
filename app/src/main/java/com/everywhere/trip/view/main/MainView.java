package com.everywhere.trip.view.main;

import android.view.View;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.model.MainDataBean;

public interface MainView extends BaseMvpView {
    void getSuccess(MainDataBean mainDataBean);
    void getFailed(String info);
}
