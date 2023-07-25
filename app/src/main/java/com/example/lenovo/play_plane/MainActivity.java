package com.example.lenovo.play_plane;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private long time;//用于检测按两次 "再按一次退出游戏"
    private Button TOSTOP;
    public static int Tnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hua.HP=100;
        hua.mjhp=100;
        my.js=0;
        my.sj=0;
        my.nd=1;
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//隐藏标题栏
        TOSTOP = (Button) findViewById(R.id.zanting);
        mHandler.post(mCounter);
        TOSTOP.setOnClickListener((View.OnClickListener) this);
        SoundPlayUtils.init(this);

          //final Draw drawView = new hua(this);
        //setContentView(R.layout.dialog_layout);
        //setContentView()跟swing的add()差不多吧，不过这里只能添加一个控件，默认铺满屏幕
    }

    Handler mHandler=new Handler();
    Runnable mCounter=new Runnable() {

        @Override
        public void run() {
            //Log.i("xueliang", String.valueOf(hua.HP));
            if(hua.HP<=0||hua.mjhp<=0){
                Intent intent = new Intent(MainActivity.this, TanChuang.class);
                startActivity(intent);
                mHandler.removeCallbacks(mCounter);

            }
            else{
                mHandler.postDelayed(this, 100);
            }

        }
    };

    public boolean onKeyDown(int keyCode,KeyEvent event) { //返回键
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
            long t=System.currentTimeMillis();//获取系统时间
            if(t-time<=500){
                exit(); //如果500毫秒内按下两次返回键则退出游戏
            }else{
                time=t;
                Toast.makeText(getApplicationContext(),"再按一次退出游戏",Toast.LENGTH_SHORT).show();
            }

            return true;
        }
        return false;

    }
    public void exit(){
        MainActivity.this.finish();
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {

                    Thread.sleep(500);

                } catch (InterruptedException e) {e.printStackTrace();}
                System.exit(0);
            }
        }).start();
    }

    public void onClick(View v){
        if(hua.FuncTion==true){
            hua.FuncTion=false;
            TOSTOP.setBackgroundResource(R.drawable.kai);
        }else{
            hua.FuncTion=true;
            TOSTOP.setBackgroundResource(R.drawable.ting);
        }

    }

    public void onClick1(View v){
        if(hua.FuncTion==true){
            if(my.power>=50){
                my.power=0;
                Tnumber=1;
            }
        }
    }
}
