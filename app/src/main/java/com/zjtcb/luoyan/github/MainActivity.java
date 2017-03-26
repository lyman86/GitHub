package com.zjtcb.luoyan.github;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.zjtcb.luoyan.github.activity.DialogActivity;
import com.zjtcb.luoyan.github.base.BaseActivityForApp;

import butterknife.Bind;
import butterknife.OnClick;


public class MainActivity extends BaseActivityForApp {

    @Override
    public void initApp() {
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.btn_go_dialog_activity})
    public void go(View view){
        switch (view.getId()){
            case R.id.btn_go_dialog_activity:
                startActivity(new Intent(this, DialogActivity.class));
                break;
        }
    }


}
