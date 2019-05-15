package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.MainDataBean;

public interface MainView extends BaseMvpView {
    void getSuccess(MainDataBean mainDataBean);
    void getFailed(String info);
}
