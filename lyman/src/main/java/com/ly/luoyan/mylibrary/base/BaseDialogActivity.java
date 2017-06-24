package com.ly.luoyan.mylibrary.base;

import android.content.DialogInterface;

import com.ly.luoyan.mylibrary.listener.OnCusDialogListener;
import com.ly.luoyan.mylibrary.utils.L;
import com.ly.luoyan.mylibrary.utils.dialog.CusDialogShow;
import com.ly.luoyan.mylibrary.utils.dialog.CusDialogShowImpl;

/**
 * Created by luoyan on 2017/3/14.
 */

public abstract class BaseDialogActivity extends BaseActivity implements DialogInterface.OnClickListener{

    private CusDialogShow cusDialogShow;

    private OnCusDialogListener cusDialogListener;

    private static final String TAG = "BaseDialogActivity";

    public void setOnCusDialogListener(OnCusDialogListener listener){
        this.cusDialogListener = listener;
    }

    @Override
    public void initBase(){
        L.e("base","initBase");
        initDA();
        cusDialogShow = new CusDialogShowImpl(this);
    }

    public void showAlertDialog(String title, String msg){
        cusDialogShow.showDialogAlert(title,msg);
    }

    public void showAlertDialog(String msg){
        cusDialogShow.showDialogAlert(msg);
    }

    public void showProgressDialog(String content){
        cusDialogShow.showDialogProgress(content);
    }

    public void showProgressDialogCus(){
        cusDialogShow.showDialogProgressCus();
    }

    public void dismissDialog(){
        cusDialogShow.dismissDialog();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (cusDialogListener!=null){
            cusDialogListener.onCustomDialog(dialogInterface,i);
        }
        cusDialogShow.dismissDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cusDialogShow.remove();
    }

    public abstract void initDA();
}
