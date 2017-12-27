package com.zjtcb.luoyan.github.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ly.luoyan.mylibrary.base.BaseFragmentForApp;
import com.zjtcb.luoyan.github.R;

/**
 * Created by luoyan on 2017/8/31.
 */

public class FragmentTwo extends BaseFragmentForApp {

    public static FragmentTwo newInstance() {
        Bundle args = new Bundle();
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_fragment_02);
    }

    @Override
    public void initDatas() {
        titleBar.setCenterText("FragmentTwo");
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,titleBarHeight+statusBarHeight));
    }
}
