package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.Banmi;
import com.everywhere.trip.model.MainDataBean;

public interface SecondView  extends BaseMvpView {
    void getSuccess(Banmi banmi);
    void getFailed(String info);

}