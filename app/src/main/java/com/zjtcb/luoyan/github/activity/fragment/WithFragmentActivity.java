package com.zjtcb.luoyan.github.activity.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import com.ly.luoyan.mylibrary.base.BaseActivityForApp;
import com.ly.luoyan.mylibrary.utils.MyFragmentPagerAdapter;
import com.ly.luoyan.mylibrary.widget.CustomViewPager;
import com.zjtcb.luoyan.github.R;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by luoyan on 2017/4/13.
 */

public class WithFragmentActivity extends BaseActivityForApp {

    @Bind(R.id.view_pager)
    CustomViewPager viewPager;

    private List<Fragment>fragments;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_with_fragment);
    }

    @OnClick({R.id.tv_buy_lottery,R.id.tv_buy_together,R.id.tv_sport_live,R.id.tv_open_award,R.id.tv_my})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_buy_lottery:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.tv_buy_together:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.tv_sport_live:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.tv_open_award:
                viewPager.setCurrentItem(3,false);
                break;
            case R.id.tv_my:
                viewPager.setCurrentItem(4,false);
                break;
        }
    }

    @Override
    public void initDatas() {
        fragments = new ArrayList<>();
        fragments.add(FragmentOne.newInstance());
        fragments.add(FragmentTwo.newInstance());
        fragments.add(FragmentThree.newInstance());
        fragments.add(FragmentFour.newInstance());
        fragments.add(FragmentFive.newInstance());
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments));
    }


}
