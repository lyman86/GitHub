package com.ly.luoyan.mylibrary.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import com.ly.luoyan.mylibrary.R;
import com.ly.luoyan.mylibrary.utils.L;

/**
 * Created by luoyan on 2017/3/14.
 */

public abstract class BaseFragmentForApp extends BaseButterKnifFragment{
    private static final String TAG = "BaseFragmentForApp";
    @Override
    public void initBK(View contentView){
        L.e(TAG,"initBK");
        initAppDatas(contentView);
    }

    public abstract void initAppDatas(View contentView);

    public void configRefreshLayout(SwipeRefreshLayout swipeRefreshLayout){
        swipeRefreshLayout.setColorSchemeResources(
                R.color.colorPrimary,
                R.color.colorAccent,
                R.color.green);
        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
    }



}
