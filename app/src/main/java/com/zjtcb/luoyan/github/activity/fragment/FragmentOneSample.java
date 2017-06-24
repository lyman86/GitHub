package com.zjtcb.luoyan.github.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.ly.luoyan.mylibrary.base.BaseFragmentForApp;
import com.ly.luoyan.mylibrary.utils.T;
import com.ly.luoyan.mylibrary.widget.CustomSelectItem;
import com.zjtcb.luoyan.github.R;

import butterknife.Bind;

/**
 * Created by luoyan on 2017/4/13.
 */

public class FragmentOneSample extends BaseFragmentForApp {

    public static final String LAYOUT_ID = "layout_id";
    private static final String TAG = "FragmentOneSample";
    private int layoutId;
    private boolean fisrtLoad = true;

    public static FragmentOneSample newIncetance(int layoutId) {
        Bundle bundle = new Bundle();
        bundle.putInt(LAYOUT_ID,layoutId);
        FragmentOneSample fragmentOneSample = new FragmentOneSample();
        fragmentOneSample.setArguments(bundle);
        return fragmentOneSample;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle!=null){
            layoutId = bundle.getInt(LAYOUT_ID);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&fisrtLoad){
            Log.e("fadssd","hee");
            fisrtLoad = false;
        }
    }

    @Override
    public int getLayoutId() {
        return layoutId;
    }

    @Override
    public void initAppDatas(View contentView) {
    }
}
