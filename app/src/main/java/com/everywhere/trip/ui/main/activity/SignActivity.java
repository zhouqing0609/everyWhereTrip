package com.everywhere.trip.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.everywhere.trip.R;
import com.jaeger.library.StatusBarUtil;

public class SignActivity extends AppCompatActivity {

    private ImageView name_back;
    private Toolbar sign_toonar;
    private EditText sign_etname;
    private TextView sign_length;
    private String sign;
    private String sign2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        initView();
    }

    private void initView() {
        StatusBarUtil.setLightMode(this);
        name_back = (ImageView) findViewById(R.id.sign_back);
        sign_toonar = (Toolbar) findViewById(R.id.sign_toonar);
        sign_etname = (EditText) findViewById(R.id.sign_etname);
        sign_length = (TextView) findViewById(R.id.sign_length);


        Intent intent = getIntent();
        final String sign1 = intent.getStringExtra("sign");

        sign_etname.setText(sign1);
        sign_etname.setSelection(sign1.length());
        sign_length.setText(""+sign1.length());

        sign_etname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = s.length();

                sign_length.setText(27-length+"");
                sign = sign_etname.getText().toString();
            }
        });

        sign2 = sign_etname.getText().toString();


        name_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, MyActivity.class);

                intent.putExtra("sign",sign_etname.getText().toString().trim());
                setResult(2,intent);
                finish();
            }
        });

    }


}
