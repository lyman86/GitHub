package com.ly.luoyan.mylibrary.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.ly.luoyan.mylibrary.utils.MyWindow;
import com.ly.luoyan.mylibrary.utils.WindowUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {
    private Toast mToast;
    public Activity mActivity;
    public MyWindow window;
    public BaseActivity() {
    }

    /**
     * Android生命周期回调方法-创建
     */
    @Override
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mActivity = this;
        init();
        window = WindowUtil.getWindow(this);
    }


    /**
     * 初始化
     */
    private void init() {
        initLayout();
        ButterKnife.bind(this);
        initView();
        initListener();
        processLogic();

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        ButterKnife.unbind(this);
    }

    /**
     * 点击屏幕收起键盘
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager manager;
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.onTouchEvent(event);
    }

    public void showToast(final String string) {
        if (mToast == null) {
            mToast = Toast.makeText(this, string, Toast.LENGTH_LONG);
            mToast.setGravity(Gravity.CENTER,0,0);
        } else {
            mToast.setText(string);
        }
        mToast.show();
    }

    /**
     * 初始化布局文件
     */
    protected void initLayout(){}

    /**
     * 初始化控件
     */
    protected void initView(){}

    /**
     * 关联监听
     */
    protected void initListener(){}

    /**
     * 逻辑处理
     */
    protected void processLogic(){};


}
