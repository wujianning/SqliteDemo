package com.wjn.sqlitedemo.login.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.login.model.Student;
import com.wjn.sqlitedemo.login.presenter.ILoginActivity;
import com.wjn.sqlitedemo.login.presenter.ILoginInPresenter;
import com.wjn.sqlitedemo.login.presenter.LoginInPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginActivity, View.OnClickListener{

    private EditText useredittext;
    private EditText pwdedittext;
    private TextView logintextview;
    private TextView resettextview;
    private ProgressDialog procDialog;
    private ILoginInPresenter iLoginInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化各种View
     * */

    public void initView(){
        useredittext= (EditText) findViewById(R.id.activity_login_usernameedittext);
        pwdedittext= (EditText) findViewById(R.id.activity_login_pwdedittext);
        logintextview= (TextView) findViewById(R.id.activity_login_logintextview);
        resettextview= (TextView) findViewById(R.id.activity_login_resettextview);
        logintextview.setOnClickListener(this);
        resettextview.setOnClickListener(this);

        iLoginInPresenter = new LoginInPresenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_login_logintextview://登录
                logintextview.setEnabled(false);
                iLoginInPresenter.submitLogin(useredittext.getText().toString(), pwdedittext.getText().toString());
                break;
            case R.id.activity_login_resettextview://重置
                iLoginInPresenter.clear();
                break;
        }
    }

    @Override
    public void clearEdittext() {
        useredittext.setText("");
        pwdedittext.setText("");
    }

    @Override
    public void loginStart() {
        procDialog = new ProgressDialog(this);
        procDialog.setMessage("登录中...");
        procDialog.setCancelable(false);
        procDialog.setIndeterminate(false);
        procDialog.show();
    }

    @Override
    public void loginFinish(boolean result, int code) {
        if(null!=procDialog){
            if (procDialog.isShowing()) {
                procDialog.dismiss();
            }
        }
        if (result) {
            Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
            //模拟MVP的model层 所以创建一个Java Bean
            Student student=new Student();
            student.setName("张三");
            student.setPwd("123");
            String name=student.getName();
            String pwd=student.getPwd();
            Log.d("TAG","name----:"+name);
            Log.d("TAG","pwd----:"+pwd);
        } else {
            Toast.makeText(this, "登录失败,错误码：" + code, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null!=procDialog){
            if (procDialog.isShowing()) {
                procDialog.dismiss();
            }
        }
    }
}
