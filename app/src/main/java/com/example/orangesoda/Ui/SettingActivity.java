package com.example.orangesoda.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.orangesoda.R;

public class SettingActivity extends TitleInit {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initTitleBar("笔记设置");
    }
}
