package com.zjtcb.luoyan.github.activity;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.ly.luoyan.mylibrary.base.BaseActivityForApp;
import com.ly.luoyan.mylibrary.listener.GetPictureListener;
import com.ly.luoyan.mylibrary.utils.FileSizeUtil;
import com.ly.luoyan.mylibrary.widget.CustomSelectItem;
import com.zjtcb.luoyan.github.R;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by luoyan on 2017/8/8.
 */

public class PictureActivity extends BaseActivityForApp implements GetPictureListener{

    @Bind(R.id.iv)
    ImageView iv;

    @Bind(R.id.cus_title_bar)
    CustomSelectItem titleBar;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_picture);
    }

    @Override
    public void initDatas() {
        super.initDatas();
        isClip = true;
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,titleBarHeight+statusBarHeight));
    }

    @Override
    public void initListener() {
        super.initListener();
        setPictureListener(this);
        titleBar.setOnBarViewClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick(R.id.btn_photo) void onBtnPhotoClick() {
        takePhoto();
    }

    @OnClick(R.id.btn_gallery) void onBtnGalleryClick() {
        goGallery();
    }

    @Override
    public void getPicture(Bitmap bitmap, String path) {
        iv.setImageBitmap(bitmap);
        Log.e("gggg", FileSizeUtil.getAutoFileOrFilesSize(path));
    }
}
