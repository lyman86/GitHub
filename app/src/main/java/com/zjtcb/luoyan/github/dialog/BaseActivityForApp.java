package com.zjtcb.luoyan.github.dialog;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;
import com.ly.luoyan.mylibrary.listener.OnCusDialogListener;
import com.ly.luoyan.mylibrary.utils.dialog.CusDialogShowImpl;
import com.ly.luoyan.mylibrary.utils.StatusBarUtils;

import butterknife.ButterKnife;

/**
 * Created by luoyan on 2017/3/3.
 */

public abstract class BaseActivityForApp extends AppCompatActivity implements DialogInterface.OnClickListener{
    private Toast mToast;
    private CusDialogShowImpl cusDialogShowImpl;


    private OnCusDialogListener cusDialogListener;

    public void setOnCusDialogListener(OnCusDialogListener listener){
        this.cusDialogListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        cusDialogShowImpl = new CusDialogShowImpl(this);
        init();
        StatusBarUtils.setColor(this, getResources().getColor(com.ly.luoyan.mylibrary.R.color.colorAccent));
        ButterKnife.bind(this);
        processLogic();
    }

    public void showAlertDialog(String title, String msg){
        cusDialogShowImpl.showDialogAlert(title,msg);
    }

    public void showAlertDialog(String msg){
        cusDialogShowImpl.showDialogAlert(msg);
    }

    public void showProgressDialog(String content){
        cusDialogShowImpl.showDialogProgress(content);
    }

    public void showProgressDialogCus(){
        cusDialogShowImpl.showDialogProgressCus();
    }

    public void showToast(final String string) {
        if (mToast == null) {
            mToast = Toast.makeText(this, string, Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER,0,0);
        } else {
            mToast.setText(string);
        }
        mToast.show();
    }

    public void dismissDialog(){
        cusDialogShowImpl.dismissDialog();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (cusDialogListener!=null){
            cusDialogListener.onCustomDialog(dialogInterface,i);
        }
        cusDialogShowImpl.dismissDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        cusDialogShowImpl.remove();
    }

    public abstract void init();

    public void processLogic(){};
}
