package com.zjtcb.luoyan.github.base;

import android.support.annotation.Nullable;
import android.view.View;

import com.ly.luoyan.mylibrary.utils.L;
import com.ly.luoyan.mylibrary.utils.StatusBarUtils;
import com.ly.luoyan.mylibrary.widget.CustomSelectItem;
import com.zjtcb.luoyan.github.R;

import butterknife.Bind;

/**
 * Created by luoyan on 2017/3/14.
 */

public abstract class BaseActivityForApp extends BaseButterKnifActivity implements CustomSelectItem.OnBarViewClickListener{

    @Override
    public void initBK(){
        L.e("base","initBK");
        initApp();
        StatusBarUtils.setColor(this, getResources().getColor(com.ly.luoyan.mylibrary.R.color.title_bar));
    }

    public abstract void initApp();

    @Override
    public void onBarViewClick(View v, int whitch) {
        switch (whitch){
            case CustomSelectItem.LEFT_VIEW:
                finish();
                break;
        }
    }

}
