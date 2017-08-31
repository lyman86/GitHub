package com.zjtcb.luoyan.github;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;

import com.ly.luoyan.mylibrary.base.BaseActivity;

/**
 * Created by luoyan on 2017/8/8.
 */

public class InitActivity extends BaseActivity {

    private String[] perms = {"android.permission.CAMERA","android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE"};
    private int permsRequestCode = 200;
    @Override
    public void setContentView() {
        setContentView(R.layout.activity_init);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initDatas() {
        super.initDatas();
        int permissionCheck01 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissionCheck02 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA);
        if ((permissionCheck01==-1||permissionCheck02==-1)&&Integer.parseInt(Build.VERSION.SDK)>=23){
            requestPermissions(perms, permsRequestCode);
        }else{
            startActivity(new Intent(this,MainActivity.class));
            InitActivity.this.finish();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){
        switch(permsRequestCode){
            case 200:{
                boolean cameraAccepted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
                if(cameraAccepted){
                    //授权成功之后，调用系统相机进行拍照操作等
                }else{
                    //用户授权拒绝之后，友情提示一下就可以了
                    showToast("您已经拒绝");
                }
                startActivity(new Intent(this,MainActivity.class));
                InitActivity.this.finish();
                break;
            }
        }

    }
}
