package com.wjn.sqlitedemo.login.presenter;

public interface ILoginActivity {

    void clearEdittext();

    void loginStart();

    void loginFinish(boolean result,int code);

}
