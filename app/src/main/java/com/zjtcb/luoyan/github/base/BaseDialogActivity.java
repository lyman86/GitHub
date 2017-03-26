package com.zjtcb.luoyan.github.base;

import android.content.DialogInterface;
import com.ly.luoyan.mylibrary.listener.OnCusDialogListener;
import com.ly.luoyan.mylibrary.utils.dialog.CusDialogShowImpl;
import com.ly.luoyan.mylibrary.utils.L;

/**
 * Created by luoyan on 2017/3/14.
 */

public abstract class BaseDialogActivity extends BaseActivity implements DialogInterface.OnClickListener{

    private CusDialogShowImpl cusDialogShowImpl;

    private OnCusDialogListener cusDialogListener;

    private static final String TAG = "BaseDialogActivity";

    public void setOnCusDialogListener(OnCusDialogListener listener){
        this.cusDialogListener = listener;
    }

    @Override
    public void initBase(){
        L.e("base","initBase");
        initDA();
        cusDialogShowImpl = new CusDialogShowImpl(this);
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
        cusDialogShowImpl.remove();
    }

    public abstract void initDA();
}
