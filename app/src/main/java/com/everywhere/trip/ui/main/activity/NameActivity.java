package com.everywhere.trip.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.everywhere.trip.R;
import com.jaeger.library.StatusBarUtil;

public class NameActivity extends AppCompatActivity {

    private RelativeLayout mMainItem;
    private Toolbar mNameToonar;
    private EditText mNameEtname;
    private TextView mNameLength;
    private ImageView name_back;
    private RelativeLayout main_item;
    private Toolbar name_toonar;
    private EditText name_etname;
    private TextView name_length;
    private String name;
    private String nicheng;
    private String name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        initView();
    }

    private void initView() {
        StatusBarUtil.setLightMode(this);
        mMainItem = (RelativeLayout) findViewById(R.id.main_item);
        mNameToonar = (Toolbar) findViewById(R.id.name_toonar);
        mNameEtname = (EditText) findViewById(R.id.name_etname);
        mNameLength = (TextView) findViewById(R.id.name_length);

        Intent intent = getIntent();
        nicheng = intent.getStringExtra("name");

        mNameEtname.setText(nicheng);
        mNameEtname.setSelection(nicheng.length());
        mNameLength.setText(nicheng.length() + "");


        mNameEtname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = s.length();
                mNameLength.setText(27-length + "");
                name = mNameEtname.getText().toString();
                Log.e("ssssssssss", "afterTextChanged: "+name );
            }
        });

        Log.e("================", "onClick: "+ this.name);
        name_back = (ImageView) findViewById(R.id.name_back);
         name_back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(NameActivity.this, MyActivity.class);
                 intent.putExtra("name", mNameEtname.getText().toString().trim());
                 Log.e("name", "onClick: "+mNameEtname.getText().toString().trim());
                 setResult(200,intent);
                 finish();
             }
         });



    }



}
