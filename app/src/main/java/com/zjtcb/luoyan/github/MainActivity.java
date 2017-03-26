package com.zjtcb.luoyan.github;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zjtcb.luoyan.github.activity.DialogActivity;
import com.zjtcb.luoyan.github.base.BaseActivityForApp2;
import com.zjtcb.luoyan.github.dialog.BaseActivityForApp;

import butterknife.Bind;
import butterknife.OnClick;


public class MainActivity extends BaseActivityForApp2 {

    @Bind(R.id.btn_go_dialog_activity)
    Button btnGoDialog;

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
