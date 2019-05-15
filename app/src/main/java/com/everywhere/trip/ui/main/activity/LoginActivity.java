package com.everywhere.trip.ui.main.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Button;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.presenter.LoginPresenter;
import com.everywhere.trip.ui.main.fragment.LoginOrBindFragment;
import com.everywhere.trip.view.main.LoginView;
import com.jaeger.library.StatusBarUtil;
import com.umeng.socialize.UMShareAPI;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {
    public static  final  int TYPE_BIND=1;
    public static final int TYPR_LOGIN =0;
    private int mType;



    /*
    * 启动当前Activity
    * type 如果是0，代表登录界面 1 代表绑定手机
    * */
    public static void startAct(Context context,int type){
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(Constants.TYPE,type);
        context.startActivity(intent);
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        mPresenter.getVerifyCode();
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        getIntentData();
        FragmentManager manager = getSupportFragmentManager();
        LoginOrBindFragment fragment =  LoginOrBindFragment.newInstance(mType);

        manager.beginTransaction().add(R.id.fl_container, fragment).commit();

    }

    private void getIntentData() {
        mType = getIntent().getIntExtra(Constants.TYPE, TYPR_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void toastShort(String msg) {

    }
}
