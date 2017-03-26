package com.zjtcb.luoyan.github.base;

import com.ly.luoyan.mylibrary.utils.L;
import com.ly.luoyan.mylibrary.utils.StatusBarUtils;

/**
 * Created by luoyan on 2017/3/14.
 */

public abstract class BaseActivityForApp extends BaseButterKnifActivity {

    @Override
    public void initBK(){
        L.e("base","initBK");
        initApp();
        StatusBarUtils.setColor(this, getResources().getColor(com.ly.luoyan.mylibrary.R.color.colorAccent));
    }

    public abstract void initApp();

}
