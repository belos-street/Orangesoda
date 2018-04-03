package com.example.orangesoda.Ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.orangesoda.R;

public class SettingActivity extends TitleInit {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initTitleBar("笔记设置");
        Button btn_map = (Button)findViewById(R.id.position_intent);
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,BaiduMapActivity.class);
                startActivity(intent);

            }
        });
    }
}
