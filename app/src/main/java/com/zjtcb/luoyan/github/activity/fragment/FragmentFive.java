package com.zjtcb.luoyan.github.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ly.luoyan.mylibrary.base.BaseFragmentForApp;
import com.zjtcb.luoyan.github.R;

/**
 * Created by luoyan on 2017/8/31.
 */

public class FragmentFive extends BaseFragmentForApp {

    public static FragmentFive newInstance() {
        Bundle args = new Bundle();
        FragmentFive fragment = new FragmentFive();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_fragment_05);
    }
}
