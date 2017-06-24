package com.ly.luoyan.mylibrary.base;

import android.view.View;

import com.ly.luoyan.mylibrary.utils.DensityUtils;
import com.ly.luoyan.mylibrary.utils.L;
import com.ly.luoyan.mylibrary.utils.StatusBarUtils;
import com.ly.luoyan.mylibrary.widget.CustomSelectItem;

/**
 * Created by luoyan on 2017/3/14.
 */

public abstract class BaseActivityForApp extends BaseButterKnifActivity implements CustomSelectItem.OnBarViewClickListener{
    protected int statusBarHeight = 0;
    protected int titleBarHeight = 0;

    @Override
    public void initBK(){
        L.e("base","initBK");
        initApp();
        StatusBarUtils.setTranslucent(this);
        statusBarHeight = StatusBarUtils.getStatusBarHeight(this);
        titleBarHeight = DensityUtils.dp2px(this,48);
    }

    public abstract void initApp();

    @Override
    public void onBarViewClick(View v, int whitch) {
        switch (whitch){
            case CustomSelectItem.LEFT_VIEW:
                finish();
                break;
        }
    }



}
