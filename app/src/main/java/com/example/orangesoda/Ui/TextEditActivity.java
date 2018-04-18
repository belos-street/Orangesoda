package com.example.orangesoda.Ui;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.orangesoda.Adapter.NoteAdapter;
import com.example.orangesoda.Db.NoteBook;
import com.example.orangesoda.R;

import java.util.Date;

public class TextEditActivity extends  TitleInit implements View.OnClickListener{
    public   TextInputEditText tv_input_title,tv_input_content;
    public   TextView tx_save;
    private int activityName;
    private int notebookID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_edit);
        initTitleBar("编辑内容");

        initView();
        Intent intent = getIntent();
        activityName = intent.getIntExtra("ActivityName", 0);//判断是哪个intent跳转的

        //修改便签的事件
        if (activityName == NoteAdapter.NAME){
            NoteBook noteBook = (NoteBook) intent.getSerializableExtra("Content_title");
            tv_input_title.setText(noteBook.getTitle());
            tv_input_content.setText(noteBook.getContent());//填入已有的数据
            notebookID = noteBook.getId();
        }
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

    public  void saveData(){ //保存数据
        NoteBook noteBook = new NoteBook();
        noteBook.setTitle(tv_input_title.getText().toString());
        noteBook.setContent(tv_input_content.getText().toString());
        noteBook.setDate(new Date());
        noteBook.save();

    }
    public void updateDate() {
        NoteBook noteBook = new NoteBook();
        noteBook.setTitle(tv_input_title.getText().toString());
       noteBook.setContent(tv_input_content.getText().toString());
        noteBook.setDate(new Date());
        noteBook.update(notebookID);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.custom_rl_tv:
                if (activityName == NoteAdapter.NAME) {//如果是已有的数据就更新，否则存储
                    updateDate();
                } else if (activityName == MainDrawerLayout.NAME) {
                    saveData();
                }
             finish();
                break;
        }
    }

}
