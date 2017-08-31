package com.zjtcb.luoyan.github.activity;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ly.luoyan.mylibrary.base.BaseActivityForApp;
import com.ly.luoyan.mylibrary.listener.OnCusDialogListener;
import com.ly.luoyan.mylibrary.widget.CustomDialog;
import com.ly.luoyan.mylibrary.widget.CustomSelectItem;
import com.zjtcb.luoyan.github.R;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by luoyan on 2017/3/4.
 */

public class DialogActivity extends BaseActivityForApp implements OnCusDialogListener{
    private static final String TAG = "DialogActivity";

    @Bind(R.id.cus_title_bar)
    CustomSelectItem titleBar;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_dialog);
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
                showProgress("玩命加载中...");
                break;
            case R.id.btn_show_custom:
                showProgressCus();
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
    public void initDatas() {
        titleBar.setCenterText("DialogActivity");
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,titleBarHeight+statusBarHeight));
    }

    @Override
    public void initListener() {
        titleBar.setOnBarViewClickListener(this);
        setOnCusDialogListener(this);
    }

}
