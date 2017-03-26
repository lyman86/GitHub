package com.zjtcb.luoyan.github.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;
import com.ly.luoyan.mylibrary.utils.L;

/**
 * Created by luoyan on 2017/3/14.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Toast mToast;
    private static final String TAG = "BaseActivity";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        initBase();
        L.e("base","BaseActivity   onCreate");
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

    public abstract void initBase();

    public void processLogic(){};
}
