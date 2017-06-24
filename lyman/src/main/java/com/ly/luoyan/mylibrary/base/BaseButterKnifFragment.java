package com.ly.luoyan.mylibrary.base;

import android.view.View;
import com.ly.luoyan.mylibrary.utils.L;
import butterknife.ButterKnife;

/**
 * Created by luoyan on 2017/3/14.
 */

public abstract class BaseButterKnifFragment extends BaseDialogFragment {
    private static final String TAG = "BaseButterKnifFragment";
    @Override
    public void initDA(View view){
        L.e(TAG,"initDA");
        initBK(view);
        ButterKnife.bind(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public abstract void initBK(View view);
}
