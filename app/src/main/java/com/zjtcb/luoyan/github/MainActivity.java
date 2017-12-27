package com.zjtcb.luoyan.github;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ly.luoyan.mylibrary.base.BaseActivityForApp;
import com.ly.luoyan.mylibrary.widget.CustomSelectItem;
import com.zjtcb.luoyan.github.activity.DialogActivity;
import com.zjtcb.luoyan.github.activity.PictureActivity;
import com.zjtcb.luoyan.github.activity.PopupWindowActivity;
import com.zjtcb.luoyan.github.activity.fragment.WithFragmentActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivityForApp {

    public static final String REFRESH_ME = "refresh_me";
    @Bind(R.id.cus_title_bar)
    CustomSelectItem titleBar;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.btn_go_dialog_activity,R.id.btn_go_popup_window_activity,R.id.btn_go_fragment_activity,R.id.btn_go_photo})
    public void go(View view){
        switch (view.getId()){
            case R.id.btn_go_dialog_activity:
                startActivity(new Intent(this, DialogActivity.class));
                break;
            case R.id.btn_go_popup_window_activity:
                startActivity(new Intent(this, PopupWindowActivity.class));
                break;
            case R.id.btn_go_fragment_activity:
                startActivity(new Intent(this, WithFragmentActivity.class));
                break;
            case R.id.btn_go_photo:
                startActivity(new Intent(this, PictureActivity.class));
                break;
        }
    }

    @Override
    public void initDatas() {
        titleBar.setCenterText("MainActivity");
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,titleBarHeight+statusBarHeight));
    }

    //    @Subscribe
//    public void onEventMainThread(EventMessage eventMessage) {
//        if (eventMessage.getMsg().equals(REFRESH_ME)) {
//            showToast("T__T !");
//        }
//    }
}
