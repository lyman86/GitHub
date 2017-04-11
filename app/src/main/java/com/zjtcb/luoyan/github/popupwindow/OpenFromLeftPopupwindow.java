package com.zjtcb.luoyan.github.popupwindow;

import android.content.Context;

import com.ly.luoyan.mylibrary.base.BasePopUpWindow;
import com.zjtcb.luoyan.github.R;

/**
 * Created by luoyan on 2017/4/10.
 */

public class OpenFromLeftPopupwindow extends BasePopUpWindow {

    private Context context;

    public OpenFromLeftPopupwindow(Context context) {
        this.context = context;
        setproPortion(0.5f);
        setLayout(context, R.layout.popup_window_open_from_right, BasePopUpWindow.TANS_HOR_FROM_LEFT);
    }

    @Override
    public void initId() {

    }

    @Override
    public void initEvent() {

    }
}
