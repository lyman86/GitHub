package com.zjtcb.luoyan.github.activity;

import android.view.View;
import android.widget.LinearLayout;
import com.ly.luoyan.mylibrary.widget.CustomSelectItem;
import com.zjtcb.luoyan.github.R;
import com.zjtcb.luoyan.github.base.BaseActivityForApp;
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

public class PopupWindowActivity extends BaseActivityForApp{

    @Bind(R.id.view)
    View view;

    @Bind(R.id.root_view)
    LinearLayout rootView;

    @Bind(R.id.cus_title_bar)
    CustomSelectItem titleBar;

    OpenFromRightPopupwindow openFromRightPopupwindow;
    OpenFromLeftPopupwindow openFromLeftPopupwindow;
    OpenFromBottomPopupwindow openFromBottomPopupwindow;
    OpenFromTopPopupwindow openFromTopPopupwindow;
    OpenPopupwindowCustom openPopupwindowCustom;

    @Override
    public void initApp() {
        setContentView(R.layout.activity_popup_window);
    }

    @Override
    public void initData() {
        titleBar.setCenterText("PopupWindow");
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

}
