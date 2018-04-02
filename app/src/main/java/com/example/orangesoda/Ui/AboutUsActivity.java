package com.example.orangesoda.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orangesoda.R;
public class AboutUsActivity extends TitleInit implements View.OnClickListener{
    RelativeLayout rl,is_dog,is_cat;
    ImageView drawer_right ,dog_check,cat_check;
    int isClick = 0 ,isDogClick=0,isCatClick=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_activity);
        initTitleBar("关于我们");
        initView();

    }
       public void initView(){
           TextView tv_edit = (TextView) findViewById(R.id.custom_text);
           findViewById(R.id.custom_rl_tv).setVisibility(View.VISIBLE);
           tv_edit.setText("编辑");
           initData();
       }
       public void initData(){
           rl = (RelativeLayout)findViewById(R.id.about_rl);
           is_dog = (RelativeLayout)findViewById(R.id.is_dog_rl);
           is_cat = (RelativeLayout)findViewById(R.id.is_cat_rl);
           drawer_right = (ImageView)findViewById(R.id.drawer_right);
           dog_check = (ImageView)findViewById(R.id.dog_about_checkbox);
           cat_check = (ImageView)findViewById(R.id.cat_check_about);
           rl.setOnClickListener(this);
           is_dog.setOnClickListener(this);
           is_cat.setOnClickListener(this);
//           rl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//               @Override
//               public void onFocusChange(View v, boolean hasFocus) {
//                   drawer_right.setImageResource(hasFocus ? R.drawable.drawer_right : R.drawable.drawer_down);
//               }
//           });
       }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.about_rl:
                 if (isClick==0){
                     isClick=1;
                   drawer_right.setImageResource(R.drawable.drawer_down);
                   is_dog.setVisibility(View.VISIBLE);
                   is_cat.setVisibility(View.VISIBLE);
                    }
                else {
                     drawer_right.setImageResource(R.drawable.drawer_right);
                     is_dog.setVisibility(View.INVISIBLE);
                     is_cat.setVisibility(View.INVISIBLE);
                     isClick=0;
                 }
                 break;
            case R.id.is_dog_rl:
                if(isDogClick==0){
                    dog_check.setImageResource(R.drawable.checkbox_sure);
                    isDogClick=1;
                }else {
                    dog_check.setImageResource(R.drawable.checkbox_unsure);
                    isDogClick=0;
                }
                break;
            case R.id.is_cat_rl:
                if(isCatClick==0){
                    cat_check.setImageResource(R.drawable.checkbox_sure);
                    isCatClick=1;
                }else {
                    cat_check.setImageResource(R.drawable.checkbox_unsure);
                    isCatClick=0;

                }
                break;

        }
    }
}
