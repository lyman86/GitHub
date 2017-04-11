package com.zjtcb.luoyan.github;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.ly.luoyan.mylibrary.widget.CustomSelectItem;
import com.zjtcb.luoyan.github.activity.DialogActivity;
import com.zjtcb.luoyan.github.activity.PopupWindowActivity;
import com.zjtcb.luoyan.github.base.BaseActivityForApp;
import com.zjtcb.luoyan.github.event.EventMessage;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.OnClick;


public class MainActivity extends BaseActivityForApp {

    public static final String REFRESH_ME = "refresh_me";
    @Bind(R.id.cus_title_bar)
    CustomSelectItem titleBar;

    @Override
    public void initApp() {
//        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.btn_go_dialog_activity,R.id.btn_go_popup_window_activity})
    public void go(View view){
        switch (view.getId()){
            case R.id.btn_go_dialog_activity:
                startActivity(new Intent(this, DialogActivity.class));
                break;
            case R.id.btn_go_popup_window_activity:
                startActivity(new Intent(this, PopupWindowActivity.class));
                break;
        }
    }
    @Override
    public void initData() {
        titleBar.setCenterText("MainActivity");
    }

//    @Subscribe
//    public void onEventMainThread(EventMessage eventMessage) {
//        if (eventMessage.getMsg().equals(REFRESH_ME)) {
//            showToast("T__T !");
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
