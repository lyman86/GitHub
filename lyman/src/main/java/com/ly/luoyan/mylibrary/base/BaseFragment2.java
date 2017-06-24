package com.ly.luoyan.mylibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by luoyan on 2017/4/13.
 */

public abstract class BaseFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBase(view);
        initListener();
        processLogic();
    }

    /**
     * 获取布局Id
     * @return
     */
    public abstract int getLayoutId();

    public abstract void initBase(View view);

    public void initListener(){}

    public void processLogic(){}

}
