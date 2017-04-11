package com.zjtcb.luoyan.github.activity;

import android.content.DialogInterface;
import android.view.View;

import com.ly.luoyan.mylibrary.listener.OnCusDialogListener;
import com.ly.luoyan.mylibrary.utils.L;
import com.ly.luoyan.mylibrary.widget.CustomDialog;
import com.ly.luoyan.mylibrary.widget.CustomSelectItem;
import com.zjtcb.luoyan.github.MainActivity;
import com.zjtcb.luoyan.github.R;
import com.zjtcb.luoyan.github.base.BaseActivityForApp;
import com.zjtcb.luoyan.github.event.EventMessage;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by luoyan on 2017/3/4.
 */

public class DialogActivity extends BaseActivityForApp implements OnCusDialogListener{
    private static final String TAG = "DialogActivity";

    @Bind(R.id.cus_title_bar)
    CustomSelectItem titleBar;

    public void initApp() {

        L.e("base","initApp");
        setContentView(R.layout.activity_dialog);
        L.e("base","setContentView");
        setOnCusDialogListener(this);

    }

    @OnClick({R.id.btn_show_alert,R.id.btn_show_alert2,R.id.btn_show_progress,R.id.btn_show_custom})
    public void showDialog(View view){
        switch (view.getId()){
            case R.id.btn_show_alert:
                showAlertDialog("提示","确定退出吗？");
                break;
            case R.id.btn_show_alert2:
                showAlertDialog("确定退出吗？");
                break;
            case R.id.btn_show_progress:
                showProgressDialog("玩命加载中...");
                break;
            case R.id.btn_show_custom:
                showProgressDialogCus();
                break;
        }
    }

    @Override
    public void onCustomDialog(DialogInterface dialogInterface, int pos) {
        switch (pos){
            case CustomDialog.BUTTON_NEGATIVE:
                showToast("cancle");
                break;
            case CustomDialog.BUTTON_POSITIVE:
                showToast("sure");
                break;
        }
    }

    @Override
    public void initData() {
        titleBar.setCenterText("DialogActivity");
    }

    @Override
    public void initListener() {
        titleBar.setOnBarViewClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().post(new EventMessage(MainActivity.REFRESH_ME,-1));
    }
}
