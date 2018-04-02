package com.example.orangesoda;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.orangesoda.Ui.MainDrawerLayout;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {
     private ImageView imageView;
   //  private boolean isAlphaZero = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
           imageView = (ImageView) findViewById(R.id.imageview);
       ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
       imageButton7.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              Intent intent = new Intent(WelcomeActivity.this, MainDrawerLayout.class);
               startActivity(intent);
           }
       });
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);//初始化操作，参数传入1和0，即由透明度1变化到透明度为0
        imageView.startAnimation(alphaAnimation);//选择控件，开始动画
      //  isAlphaZero = true;//标识位
        alphaAnimation.setFillAfter(true);//动画结束后保持状态，不设置的话动画结束后会变为原图
        alphaAnimation.setDuration(4000);//动画持续时间，单位为毫秒
        final Intent intent1=new Intent(this,MainDrawerLayout.class);
        Timer timer=new Timer();
        TimerTask task=new TimerTask()
        {
            @Override
            public void run(){
                startActivity(intent1);
            }
        };
        timer.schedule(task,4000);

    }
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

//    public void changeAlpha(View view) {
//        if (isAlphaZero) {
//            AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);//初始化操作，参数传入0和1，即由透明度0变化到透明度为1
//            imageView.startAnimation(alphaAnimation);//开始动画
//            alphaAnimation.setFillAfter(true);//动画结束后保持状态
//            alphaAnimation.setDuration(2000);//动画持续时间，单位为毫秒
//            isAlphaZero = false;//标识位
//        } else {
//            AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);//初始化操作，参数传入1和0，即由透明度1变化到透明度为0
//            imageView.startAnimation(alphaAnimation);//选择控件，开始动画
//            isAlphaZero = true;//标识位
//            alphaAnimation.setFillAfter(true);//动画结束后保持状态，不设置的话动画结束后会变为原图
//            alphaAnimation.setDuration(3000);//动画持续时间，单位为毫秒
//        }
//    }

}