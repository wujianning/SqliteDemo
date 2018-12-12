package com.wjn.sqlitedemo.login.presenter;

import android.os.Handler;

public class LoginInPresenter implements ILoginInPresenter{

    private boolean result=false;
    private int code=-1;

    private ILoginActivity iLoginActivity;
    public LoginInPresenter(ILoginActivity iLoginActivity){
        this.iLoginActivity=iLoginActivity;
    }

    @Override
    public void clear() {
        iLoginActivity.clearEdittext();
    }

    @Override
    public void submitLogin(String name, String pwd) {
        if(null!=name&&null!=pwd&&name.equals(pwd)){
            result=true;
            code=0;
        }else{
            result=false;
            code=-1;
        }

        /**
         * 提交后直接给开始的回调
         * */

        iLoginActivity.loginStart();

        /**
         * 模拟耗时操作 5秒后给完成的回调
         * */

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginActivity.loginFinish(result,code);
            }
        }, 5000);
    }

}
