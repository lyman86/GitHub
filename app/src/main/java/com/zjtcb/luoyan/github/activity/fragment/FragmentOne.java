package com.zjtcb.luoyan.github.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ly.luoyan.mylibrary.base.BaseFragmentForApp;
import com.zjtcb.luoyan.github.R;

import butterknife.Bind;

/**
 * Created by luoyan on 2017/8/31.
 */

public class FragmentOne extends BaseFragmentForApp {

    @Bind(R.id.tv)
    TextView tv;
    public static FragmentOne newInstance() {
        Bundle args = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_fragment_01);
    }

    @Override
    public void initDatas() {
        titleBar.setCenterText("FragmentOne");
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,titleBarHeight+statusBarHeight));
    }

    @Override
    public void onResume() {
        super.onResume();
        if (tv!=null){
            tv.setText("Text");
        }
    }
}
