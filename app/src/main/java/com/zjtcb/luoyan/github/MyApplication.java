package com.zjtcb.luoyan.github;

import android.app.Application;
import com.ly.luoyan.mylibrary.utils.MyWindow;
import com.ly.luoyan.mylibrary.utils.WindowUtil;

/**
 * Created by luoyan on 2017/4/11.
 */

public class MyApplication extends Application{

    private static MyApplication incetance;

    private static MyWindow window;
    @Override
    public void onCreate() {
        super.onCreate();
        window = WindowUtil.getWindow(getApplicationContext());
    }

    public static MyApplication newIncetance(){
        if (incetance==null){
            incetance = new MyApplication();
        }
        return incetance;
    }

    public static MyWindow getMyWindow(){
        return window;
    }
}
