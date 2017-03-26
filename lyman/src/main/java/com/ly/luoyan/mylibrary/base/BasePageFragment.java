package com.ly.luoyan.mylibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ly.luoyan.mylibrary.R;
import com.ly.luoyan.mylibrary.utils.MyWindow;
import com.ly.luoyan.mylibrary.utils.WindowUtil;
import com.ly.luoyan.mylibrary.widget.CustomDialog;
import butterknife.ButterKnife;

public abstract class BasePageFragment extends Fragment {
 
    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;
    protected boolean isDataInitiated;

    public int layoutId;
    public View view;
    private CustomDialog.Builder builder;
    private Toast mToast;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setLayout();
        return inflater.inflate(layoutId,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        builder = new CustomDialog.Builder(getActivity());
        ButterKnife.bind(this,view);
        init();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }

    /**
     * 用来判断当前的UI是否可见
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }


//    public void showProgressDialog() {
//        MyWindow window = WindowUtil.getWindow(getActivity());
//        builder.setDialogLoading(window.winth * 2 / 3, window.height * 1 / 8,"");
//    }

    public void dismissDialog() {
        builder.dismissDialog();
    }

    public void showToast(final String string) {
        try {
            if (mToast == null) {
                mToast = Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT);
            } else {
                mToast.setText(string);
            }
            mToast.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void init(){};

    public abstract void setLayout();
 
    public abstract void fetchData();
 
    public boolean prepareFetchData() {
        return prepareFetchData(false);
    }
 
    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }

    public void configRefreshLayout(SwipeRefreshLayout swipeRefreshLayout){
        swipeRefreshLayout.setColorSchemeResources(
                R.color.colorPrimary,
                R.color.colorAccent,
                R.color.green);
        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
    }


 
}