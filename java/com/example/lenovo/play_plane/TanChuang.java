package com.example.lenovo.play_plane;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lenovo on 2021/11/24.
 */

public class TanChuang extends AppCompatActivity {
    Button btn1;
    Button btn2;
    TextView tv;
    public static List<Activity> activityList = new LinkedList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        btn2=findViewById(R.id.bb2);
        btn1=findViewById(R.id.bb1);
        tv=findViewById(R.id.dialog_content);
        tv.setText("您本次的杀敌数为："+my.js);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide(); //隐藏标题栏
        }
        //btn1.setOnClickListener(new View.OnClickListener() {



        //});
    }
    public void onClick(View view) {
        Intent intent=new Intent(TanChuang.this,MainActivity.class);
        startActivity(intent);
    }

    public void onClick1(View view) {
        exit();
    }

    public void exit(){
        TanChuang.this.finish();
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


}
