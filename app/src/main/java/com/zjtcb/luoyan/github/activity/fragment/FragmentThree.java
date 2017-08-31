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

public class FragmentThree extends BaseFragmentForApp {

    public static FragmentThree newInstance() {
        Bundle args = new Bundle();
        FragmentThree fragment = new FragmentThree();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_fragment_03);
    }

    @Override
    public void initDatas() {
        titleBar.setCenterText("FragmentThree");
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,titleBarHeight+statusBarHeight));
    }
}
