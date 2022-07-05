package com.example.lenovo.play_plane;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by Lenovo on 2021/11/30.
 */

public class jiazai extends AppCompatActivity{
 private MediaPlayer mediaPlayer = new MediaPlayer();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                     super.onCreate(savedInstanceState);
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            final Intent i = new Intent(jiazai.this,Music.class);//初始化一个服务用于播放音乐
            startService(i);
            setContentView(R.layout.jiazai);

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.hide(); //隐藏标题栏
            }
           Animation aaa = AnimationUtils.loadAnimation(this, R.anim.init_anim);
           this.findViewById(R.id.lla).setAnimation(aaa);

           //设置一个动画监听，里面包含动画开始，结束，播放时三种情况所应执行的内容
          aaa.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }
                @Override
                //在动画播放完时结束服务并完成界面跳转
                public void onAnimationEnd(Animation animation) {
                    stopService(i);
                    jiazai.this.finish();
                    Intent intent=new Intent(jiazai.this,login.class);
                    startActivity(intent);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        }
    }
