package com.example.orangesoda.Ui;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.orangesoda.Adapter.Notebook;
import com.example.orangesoda.R;

import java.util.zip.InflaterInputStream;

public class TextEditActivity extends  TitleInit implements View.OnClickListener{
    public   TextInputEditText tv_input_title,tv_input_content;
    public   TextView tx_save;
    public   String edit_title,edit_content;
    Notebook notebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_edit);
        initTitleBar("编辑内容");
        notebook = new Notebook();
        initView();

    }
    public void initView(){
         tx_save = (TextView)findViewById(R.id.custom_text);
       RelativeLayout custom_rl_tv_save = (RelativeLayout)findViewById(R.id.custom_rl_tv);
       custom_rl_tv_save.setVisibility(View.VISIBLE);
        tx_save.setText("保存");
        custom_rl_tv_save.setOnClickListener(this);
       tv_input_title = (TextInputEditText)findViewById(R.id.text_edit_title);
       tv_input_content = (TextInputEditText)findViewById(R.id.text_edit_content);

    }
public void initData(){
     edit_title = tv_input_title.getEditableText().toString();

     edit_content = tv_input_content.getEditableText().toString();

    SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
    editor.putString("title",edit_title);
    editor.putString("content",edit_content);
    editor.apply();
}
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.custom_rl_tv:
                initData();
              finish();
                break;
        }
    }
}
