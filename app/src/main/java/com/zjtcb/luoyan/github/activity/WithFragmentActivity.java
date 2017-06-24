package com.zjtcb.luoyan.github.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ly.luoyan.mylibrary.base.BaseActivityForApp;
import com.ly.luoyan.mylibrary.utils.MyFragmentPagerAdapter;
import com.ly.luoyan.mylibrary.widget.CustomSelectItem;
import com.zjtcb.luoyan.github.R;
import com.zjtcb.luoyan.github.activity.fragment.FragmentOneSample;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;

/**
 * Created by luoyan on 2017/4/13.
 */

public class WithFragmentActivity extends BaseActivityForApp {

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    @Bind(com.ly.luoyan.mylibrary.R.id.cus_title_bar)
    CustomSelectItem titleBar;

    private List<Fragment>fragments;

    @Override
    public void initApp() {
        setContentView(R.layout.activity_with_fragment);
    }

    @Override
    public void initData() {
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,titleBarHeight+statusBarHeight));
        titleBar.setCenterText("WithFragmentActivity");
        fragments = new ArrayList<>();
        fragments.add(new FragmentOneSample().newIncetance(R.layout.sample_fragment_01));
        fragments.add(new FragmentOneSample().newIncetance(R.layout.sample_fragment_02));
        fragments.add(new FragmentOneSample().newIncetance(R.layout.sample_fragment_03));
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments));
    }

    @Override
    public void initListener() {
        titleBar.setOnBarViewClickListener(this);
    }
}
