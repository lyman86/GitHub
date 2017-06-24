package com.zjtcb.luoyan.github.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ly.luoyan.mylibrary.base.BaseActivityForApp;
import com.ly.luoyan.mylibrary.widget.CustomSelectItem;
import com.zjtcb.luoyan.github.R;
import com.zjtcb.luoyan.github.popupwindow.OpenFromBottomPopupwindow;
import com.zjtcb.luoyan.github.popupwindow.OpenFromLeftPopupwindow;
import com.zjtcb.luoyan.github.popupwindow.OpenFromRightPopupwindow;
import com.zjtcb.luoyan.github.popupwindow.OpenFromTopPopupwindow;
import com.zjtcb.luoyan.github.popupwindow.OpenPopupwindowCustom;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by luoyan on 2017/4/10.
 */

public class PopupWindowActivity extends BaseActivityForApp {

    @Bind(R.id.view)
    View view;

    @Bind(R.id.root_view)
    LinearLayout rootView;

    @Bind(R.id.cus_title_bar)
    CustomSelectItem titleBar;
    /**
     * 从右边弹出
     */
    OpenFromRightPopupwindow openFromRightPopupwindow;
    /**
     * 从左边弹出
     */
    OpenFromLeftPopupwindow openFromLeftPopupwindow;
    /**
     * 从底下弹出
     */
    OpenFromBottomPopupwindow openFromBottomPopupwindow;
    /**
     * 从上边弹出
     */
    OpenFromTopPopupwindow openFromTopPopupwindow;
    /**
     * 从中间弹出
     */
    OpenPopupwindowCustom openPopupwindowCustom;

    @Override
    public void initApp() {
        setContentView(R.layout.activity_popup_window);
    }

    @Override
    public void initData() {
        titleBar.setCenterText("PopupWindow");
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,titleBarHeight+statusBarHeight));
        openFromRightPopupwindow = new OpenFromRightPopupwindow(this);
        openFromLeftPopupwindow = new OpenFromLeftPopupwindow(this);
        openFromBottomPopupwindow = new OpenFromBottomPopupwindow(this);
        openFromTopPopupwindow = new OpenFromTopPopupwindow(this);
        openPopupwindowCustom = new OpenPopupwindowCustom(this);
    }

    @OnClick({R.id.btn_from_left,R.id.btn_from_right,R.id.btn_from_top,R.id.btn_from_bottom,R.id.btn_show_custom})
    public void click(View view){
        switch (view.getId()){
            case R.id.btn_from_left:
                openFromLeftPopupwindow.showPop(rootView);
                openFromLeftPopupwindow.lightOff(this);
                break;
            case R.id.btn_from_right:
                openFromRightPopupwindow.showPop(rootView);
                openFromRightPopupwindow.lightOff(this);
                break;
            case R.id.btn_from_top:
                openFromTopPopupwindow.showPop(rootView);
                openFromTopPopupwindow.lightOff(this);
                break;
            case R.id.btn_from_bottom:
                openFromBottomPopupwindow.showPop(rootView);
                openFromBottomPopupwindow.lightOff(this);
                break;
            case R.id.btn_show_custom:
                openPopupwindowCustom.showPop(rootView);
                openPopupwindowCustom.lightOff(this);
                break;

        }
    }

    @Override
    public void initListener() {
        titleBar.setOnBarViewClickListener(this);
    }
}
