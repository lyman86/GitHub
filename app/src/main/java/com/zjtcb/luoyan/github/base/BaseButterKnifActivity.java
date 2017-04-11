package com.zjtcb.luoyan.github.base;

import com.ly.luoyan.mylibrary.utils.L;
import butterknife.ButterKnife;

/**
 * Created by luoyan on 2017/3/14.
 */

public abstract class BaseButterKnifActivity extends BaseDialogActivity {

    @Override
    public void initDA(){
        L.e("base","initDA");
        initBK();
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public abstract void initBK();
}
