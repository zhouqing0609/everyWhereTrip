package com.everywhere.trip.ui.main.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.util.GlideUtil;
import com.everywhere.trip.util.SPutils;
import com.jaeger.library.StatusBarUtil;

public class MyActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout mMainItem;
    private Toolbar mMyToonar;
    private TextView mMyRoad;
    private RelativeLayout mRlvHead;
    private RelativeLayout mRlvName;
    private RelativeLayout mRlvSex;
    private RelativeLayout mRlvSign;
    private RelativeLayout mRlUpdate;
    private RelativeLayout mRlBind;
    private RelativeLayout main_item;
    private Toolbar my_toonar;
    private TextView my_road;
    private RelativeLayout rlv_head;
    private RelativeLayout rlv_name;
    private RelativeLayout rlv_sex;
    private RelativeLayout rlv_sign;
    private RelativeLayout rl_update;
    private RelativeLayout rl_bind;
    private TextView my_name;
    private ImageView mMyHead;
    private TextView mMyName;
    private TextView mMySign;
    private String sign;
    private String name;
    private String nicheng;
    private View mPopbtCamera;
    private View mPopbtPhoto;
    private View mPopbtCancel;
    private PopupWindow popupWindow;
    private Button pop_carmer;
    private Button images;

    private LinearLayout mll;
    private RelativeLayout mMyRl;
    private Button girl;
    private Button man;
    private Button privary;
    private PopupWindow popupWindow2;
    private String sexgirl;
    private String secman;
    private TextView mSex;
    private String sexparivary;
    private ImageView mMyBack;
    private RelativeLayout mMyItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initView();
    }

    private void initView() {
        StatusBarUtil.setLightMode(this);
        mMainItem = (RelativeLayout) findViewById(R.id.my_item);
        mMyToonar = (Toolbar) findViewById(R.id.my_toonar);
        mMyRoad = (TextView) findViewById(R.id.my_road);
        mRlvHead = (RelativeLayout) findViewById(R.id.rlv_head);
        mRlvName = (RelativeLayout) findViewById(R.id.rlv_name);
        mRlvSex = (RelativeLayout) findViewById(R.id.rlv_sex);
        mRlvSign = (RelativeLayout) findViewById(R.id.rlv_sign);
        mRlUpdate = (RelativeLayout) findViewById(R.id.rl_update);
        mRlBind = (RelativeLayout) findViewById(R.id.rl_bind);

        mRlvHead.setOnClickListener(this);
        mRlvSign.setOnClickListener(this);
        mRlvName.setOnClickListener(this);
        mRlvSex.setOnClickListener(this);

        my_name = (TextView) findViewById(R.id.my_name);
        my_name.setOnClickListener(this);
        mMyHead = (ImageView) findViewById(R.id.my_head);
        mMyHead.setOnClickListener(this);
        mMyName = (TextView) findViewById(R.id.my_name);
        mMyName.setOnClickListener(this);
        mMySign = (TextView) findViewById(R.id.my_sign);
        mMySign.setOnClickListener(this);


        mMyRl = (RelativeLayout) findViewById(R.id.my_rl);
        mMyRl.setOnClickListener(this);
        mSex = (TextView) findViewById(R.id.sex);
        mSex.setOnClickListener(this);
        mMyBack = (ImageView) findViewById(R.id.my_back);
        mMyBack.setOnClickListener(this);
        mMyItem = (RelativeLayout) findViewById(R.id.my_item);
        mMyItem.setOnClickListener(this);

        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name1");
        String sign1 = intent.getStringExtra("sign1");

        mMyName.setText(name1);
        mMySign.setText(sign1);
        mSex.setText("保密");
        SPutils.put(this, "myname", mMyName.getText());
        SPutils.put(this, "mysign", mMySign.getText());
        SPutils.put(this, "sex", "保密");


        Log.e("===========", "initView: "+name1+sign1 );
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlv_head:
                pop();
                break;
            case R.id.rlv_name:
                nicheng = my_name.getText().toString();
                Intent intent1 = new Intent(MyActivity.this, NameActivity.class);
                intent1.putExtra("name", nicheng);
                startActivityForResult(intent1, 100);
                break;
            case R.id.rlv_sex:
                popsex();
                break;
            case R.id.rlv_sign:
                String geqian = mMySign.getText().toString();
                Intent intent2 = new Intent(MyActivity.this, SignActivity.class);
                intent2.putExtra("sign", geqian);
                startActivityForResult(intent2, 1);
                break;
            case R.id.rl_update:

                break;
            case R.id.rl_bind:
                break;
            case R.id.my_back:
                Intent intent = new Intent(MyActivity.this, MainActivity.class);
                String sName = my_name.getText().toString();
                String sSign = mMySign.getText().toString();
                intent.putExtra("name", sName);
                intent.putExtra("sign", sSign);
                Log.e("====================", "on"+sName );
                Log.e("====================", "on"+sSign );
                setResult(201,intent);
                finish();
                break;
//            case R.id.images:
//
//                break;
//            case R.id.canle:
//                break;
        }
    }

    private void popsex() {
        View view = View.inflate(this, R.layout.layout_pop_sex, null);
        girl = view.findViewById(R.id.gril);
        man = view.findViewById(R.id.man);
        privary = view.findViewById(R.id.privary);
        popupWindow2 = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 520);

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popupWindow.dismiss();
//            }
//        });

        popupWindow2.setBackgroundDrawable(new ColorDrawable());
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.showAtLocation(mMyRl, Gravity.BOTTOM, 0, 10);
        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexgirl = girl.getText().toString();
                mSex.setText(sexgirl);
                SPutils.put(MyActivity.this, "sex", sexgirl);
            }
        });
        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secman = man.getText().toString();
                mSex.setText(secman);
                SPutils.put(MyActivity.this, "sex", secman);
            }
        });

        privary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexparivary = privary.getText().toString();
                mSex.setText(sexparivary);
                SPutils.put(MyActivity.this, "sex", sexparivary);

            }
        });
    }

    private void pop() {
        View view = View.inflate(this, R.layout.layout_pop, null);
        mPopbtCamera = view.findViewById(R.id.pop_carmer);
        mPopbtPhoto = view.findViewById(R.id.images);
        mPopbtCancel = view.findViewById(R.id.canle);
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 520);

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popupWindow.dismiss();
//            }
//        });

        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(mMyRl, Gravity.BOTTOM, 0, 20);
        onClickPhoto();

    }

    private void onClickPhoto() {
        mPopbtCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建意图
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //启动拍照的Activity
                startActivityForResult(intent, 14);
            }
        });

        mPopbtPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.PICK");
                //设置要打开图片的类型
                intent.setType("image/*");
                //启动相册应用
                startActivityForResult(intent, 101);
            }
        });
        mPopbtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            name = data.getStringExtra("name");
            Log.e("============", "onActivityResult: " + name);
            my_name.setText(name);
            SPutils.put(this, "myname", name);


        }

        if (requestCode == 1 && resultCode == 2) {
            sign = data.getStringExtra("sign");
            Log.e("============", "onActivityResult: " + sign);
            mMySign.setText(sign);
            SPutils.put(this, "mysign", sign);


        }
        if (requestCode == 14 && resultCode == RESULT_OK) {
            //从intent对象中获取数据
            Bitmap bitmap = data.getParcelableExtra("data");
            //把照片在imageView中显示
            mMyHead.setImageBitmap(bitmap);
        }


        if (requestCode == 101 && resultCode == RESULT_OK) {
            //从intent对象中获取数据
            Uri uri = data.getData();
            //把获取到的图片设置给ImageView
            mMyHead.setImageURI(uri);
//            GlideUtil.loadResCircleImage(R.mipmap.ic_launcher_round,uri,mMyHead,this);
        }
    }


    /*
    * 保存  数据
    * */
    @Override
    protected void onStart() {
        super.onStart();
        my_name.setText(SPutils.get(this, "myname", "").toString());
        mMySign.setText(SPutils.get(this, "mysign", "").toString());
        mSex.setText(SPutils.get(this, "sex", "").toString());

    }
}
