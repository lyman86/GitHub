package com.zjtcb.luoyan.github.popupwindow;

import android.content.Context;

import com.ly.luoyan.mylibrary.base.BasePopUpWindow2;
import com.ly.luoyan.mylibrary.utils.MyWindow;
import com.zjtcb.luoyan.github.MyApplication;
import com.zjtcb.luoyan.github.R;

/**
 * Created by luoyan on 2017/4/10.
 */

public class OpenPopupwindowCustom extends BasePopUpWindow2 {

    private Context context;

    public OpenPopupwindowCustom(Context context) {
        this.context = context;
        MyWindow myWindow = MyApplication.newIncetance().getMyWindow();
        setWidthAndHeight((int) (myWindow.winth*0.8f),(int) (myWindow.height*0.3f));
        setLayout(context, R.layout.popup_window_open_from_right,BasePopUpWindow2.CUSTOM);

    }

    @Override
    public void initId() {

    }

    @Override
    public void initEvent() {

    }
}
