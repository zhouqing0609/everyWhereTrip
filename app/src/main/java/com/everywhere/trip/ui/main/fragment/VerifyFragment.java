package com.everywhere.trip.ui.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseApp;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.presenter.VerifyPresenter;
import com.everywhere.trip.ui.main.activity.MainActivity;
import com.everywhere.trip.util.Logger;
import com.everywhere.trip.view.main.VerifyView;
import com.everywhere.trip.widget.IdentifyingCodeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *
 */

public class VerifyFragment extends BaseFragment<VerifyView, VerifyPresenter> implements VerifyView {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_send_again)
    TextView tvSendAgain;
    @BindView(R.id.icv)
    IdentifyingCodeView icv;
    @BindView(R.id.tv_wait)
    TextView tvWait;
    Unbinder unbinder;
    private  int time = 10;

    private Handler handler = new Handler(){};


    @Override
    protected VerifyPresenter initPresenter() {
        return new VerifyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_verify;
    }

    @Override
    public void toastShort(String msg) {

    }




    @OnClick({R.id.iv_back, R.id.tv_send_again})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                pop();
                break;
            case R.id.tv_send_again:

                        tvSendAgain.setText(time + "s");
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (time > 0) {
                                    time--;
                                    tvSendAgain.setText(time + "秒");
                                    handler.postDelayed(this, 1000);
                                } else {
                                    initData();
                                    tvSendAgain.setText("重新发送");
                                }
                            }
                        }, 1000);

                break;
        }
    }

    private void pop() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
            //获取回退栈中碎片的数量
        int backStackEntryCount = manager.getBackStackEntryCount();
        Logger.println("回退栈的数量"+backStackEntryCount);
        //弹栈
        manager.popBackStack();
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getVerifyCode();
    }

    @Override
    public void setData(String data) {
        if (!TextUtils.isEmpty(data)){
            tvWait.setText(BaseApp.getRes().getString(R.string.verify_code)+data);
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        icv.setOnEditorActionListener(new IdentifyingCodeView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }

            @Override
            public void onTextChanged(String s) {
                autoLogin(s);
            }
        });
    }

    private void autoLogin(String s) {
        if ( icv.getTextContent().length()>=4){
            toastShort("自动登录");
            icv.setBackgroundEnter(false);
             showLoading();
             startActivity(new Intent(getActivity(),MainActivity.class));
        }
    }
}
