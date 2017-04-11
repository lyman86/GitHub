package com.zjtcb.luoyan.github.popupwindow;

import android.content.Context;

import com.ly.luoyan.mylibrary.base.BasePopUpWindow2;
import com.zjtcb.luoyan.github.R;

/**
 * Created by luoyan on 2017/4/10.
 */

public class OpenFromBottomPopupwindow extends BasePopUpWindow2 {

    private Context context;

    public OpenFromBottomPopupwindow(Context context) {
        this.context = context;
        setproPortion(0.4f);
        setLayout(context, R.layout.popup_window_open_from_right,BasePopUpWindow2.TANS_VER_FROM_BOTTOM);

    }

    @Override
    public void initId() {

    }

    @Override
    public void initEvent() {

    }
}
