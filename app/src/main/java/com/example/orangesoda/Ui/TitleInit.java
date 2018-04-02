package com.example.orangesoda.Ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orangesoda.R;

/**
 * Created by Administrator on 2018/2/8.
 */

public class TitleInit extends AppCompatActivity { //继承活动 方便初始化调用
    private ImageButton titleBack;
    Context context;
    int CHANGEIMAGEFLAG=1;
    private  int resourceID;
    protected void immersionSystemBar() {   //自定义标题栏和顶部通知栏颜色一样
        Window window = getWindow();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
    protected void noActionBar() {  //没有自带标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
    }
    protected void initTitleBar(String title) {
        if (findViewById(R.id.title_view) != null) {
            immersionSystemBar();
            noActionBar();
            if (title != null) {
                ((TextView) findViewById(R.id.title_view)).setText(title);
            } //设置自定义标题栏的名称
        }
        titleBack = (ImageButton)findViewById(R.id.title_back);
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                finish();
            } //返回逻辑
        });
    }



}
