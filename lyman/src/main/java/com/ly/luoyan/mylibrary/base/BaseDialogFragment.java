package com.ly.luoyan.mylibrary.base;

import android.content.DialogInterface;
import android.view.View;
import com.ly.luoyan.mylibrary.listener.OnCusDialogListener;
import com.ly.luoyan.mylibrary.utils.L;
import com.ly.luoyan.mylibrary.utils.dialog.CusDialogShow;
import com.ly.luoyan.mylibrary.utils.dialog.CusDialogShowImpl;

/**
 * Created by luoyan on 2017/3/14.
 */

public abstract class BaseDialogFragment extends BaseFragment2 implements DialogInterface.OnClickListener{

    private CusDialogShow cusDialogShow;

    private OnCusDialogListener cusDialogListener;

    private static final String TAG = "BaseDialogActivity";

    public void setOnCusDialogListener(OnCusDialogListener listener){
        this.cusDialogListener = listener;
    }

    @Override
    public void initBase(View view){
        L.e(TAG,"initBase");
        initDA(view);
        cusDialogShow = new CusDialogShowImpl(getActivity());
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
    public void onDestroyView() {
        super.onDestroyView();
        cusDialogShow.remove();
    }

    public abstract void initDA(View view);
}
