package com.example.lenovo.play_plane;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.Vector;

/**
   by kuileiguai
 */

class my{//新建一个类 里面的东西都是静态的 当全局变量用
    public static int js=0,sj=0,nd=1;//击杀数
    public static int w,h;//屏幕的宽高
    public static float bili;//比例，用于适应不同屏幕
    public static Vector<hj> list=new Vector<hj>();//所有飞行物的集合,添加进这个集合才能被画出来
    public static Vector<hj> myhjlist=new Vector<hj>();//所有飞行物的集合,添加进这个集合才能被画出来
    public static Vector<hj> drlist=new Vector<hj>();//敌人飞机的集合，添加进这个集合才能被子弹打中
    public static Bitmap xuebao,mujian,myhj,drfj0,drfj10,drfj2,bj,myzd0,myzd1,myzd2,jg0,jg1;//图片：我的灰机 敌人灰机 背景 我的子弹
    public static Bitmap dfzd2,dfzd3,dfzd4;
    public static Bitmap drfj01,drfj02,drfj03,drfj04;
    public static Bitmap drfj11,drfj12,drfj13,drfj14;
    public static Bitmap drfj21,drfj22,drfj23,drfj24;
    public static mujian mj;
    public static Bitmap MK1,MK2,MK3,MK4,MK5,MK6,MK7,MK8,MK9;
    public static myhj my;//我的灰机
    public static bj b;//背景
    public static jg j;
    public static int power = 0;
    public static boolean jgkey = false;
}

public class hua extends View{//画
    private Paint p=new Paint();//画笔
    private  float x,y;//按下屏幕时的坐标
    private  float myx,myy;//按下屏幕时玩家飞机的坐标
    private  static float x1=440,y1=1200;
    public static int HP = 100;//我方生命
    public static int mjhp = 100;//母舰生命
    public static boolean FuncTion = true;

    public hua(Context context,AttributeSet attributeSet) {
        super(context,attributeSet);
        //添加事件控制玩家飞机
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent e) {
                if(e.getAction()==MotionEvent.ACTION_DOWN){
                    x=e.getX();
                    y=e.getY();
                    myx=my.my.r.left;
                    myy=my.my.r.top;
                }
                float xx=myx+e.getX()-x;
                float yy=myy+e.getY()-y;
                //我的飞机不能飞出屏幕
                xx=xx<my.w-my.my.w/2?xx:my.w-my.my.w/2;
                xx=xx>-my.my.w/2?xx:-my.my.w/2;
                yy=yy<my.h-my.my.h/2?yy:my.h-my.my.h/2;
                yy=yy>-my.my.h/2?yy:-my.my.h/2;
                x1=xx;
                y1=yy;
                my.my.setX(xx);
                my.my.setY(yy);
                return true;
            }
        });

        setBackgroundColor(Color.BLACK);//设背景颜色为黑色

        my.myhj= BitmapFactory.decodeResource(getResources(),R.mipmap.myfj);//加载图片

        my.mujian=BitmapFactory.decodeResource(getResources(),R.mipmap.mujian);//母舰

        my.xuebao=BitmapFactory.decodeResource(getResources(),R.mipmap.xuebao);



        my.MK1=BitmapFactory.decodeResource(getResources(),R.mipmap.mk1);
        my.MK2=BitmapFactory.decodeResource(getResources(),R.mipmap.mk2);
        my.MK3=BitmapFactory.decodeResource(getResources(),R.mipmap.mk3);
        my.MK4=BitmapFactory.decodeResource(getResources(),R.mipmap.mk4);
        my.MK5=BitmapFactory.decodeResource(getResources(),R.mipmap.mk5);
        my.MK6=BitmapFactory.decodeResource(getResources(),R.mipmap.mk6);
        my.MK7=BitmapFactory.decodeResource(getResources(),R.mipmap.mk7);
        my.MK8=BitmapFactory.decodeResource(getResources(),R.mipmap.mk8);
        my.MK9=BitmapFactory.decodeResource(getResources(),R.mipmap.mk9);

        my.drfj0=BitmapFactory.decodeResource(getResources(),R.mipmap.drfj01 );//小飞机
        my.drfj01=BitmapFactory.decodeResource(getResources(),R.mipmap.drfj0);//小飞机1
        my.drfj02=BitmapFactory.decodeResource(getResources(),R.mipmap.bao00);//小飞机2
        my.drfj03=BitmapFactory.decodeResource(getResources(),R.mipmap.bao01);//小飞机3
        my.drfj04=BitmapFactory.decodeResource(getResources(),R.mipmap.bao02);//小飞机4

        my.drfj10=BitmapFactory.decodeResource(getResources(),R.mipmap.drfj11);//中飞机小火
        my.drfj11=BitmapFactory.decodeResource(getResources(),R.mipmap.drfj12);//中飞机猛火
        my.drfj12=BitmapFactory.decodeResource(getResources(),R.mipmap.bao10);//中飞机
        my.drfj13=BitmapFactory.decodeResource(getResources(),R.mipmap.bao11);//中飞机
        my.drfj14=BitmapFactory.decodeResource(getResources(),R.mipmap.bao12);//中飞机

        my.drfj2=BitmapFactory.decodeResource(getResources(),R.mipmap.drfj2);//大飞机
        my.drfj21=BitmapFactory.decodeResource(getResources(),R.mipmap.drfj20);//大飞机
        my.drfj22=BitmapFactory.decodeResource(getResources(),R.mipmap.drfj21);//大飞机
        my.drfj23=BitmapFactory.decodeResource(getResources(),R.mipmap.bao21);//大飞机
        my.drfj24=BitmapFactory.decodeResource(getResources(),R.mipmap.bao22);//大飞机

        my.myzd0= my.myzd1=my.myzd2=BitmapFactory.decodeResource(getResources(),R.mipmap.myzd0);
        my.dfzd2 = BitmapFactory.decodeResource(getResources(),R.mipmap.drzd1);
        my.dfzd3 = BitmapFactory.decodeResource(getResources(),R.mipmap.zuo);
        my.dfzd4 = BitmapFactory.decodeResource(getResources(),R.mipmap.you);
        my.bj=BitmapFactory.decodeResource(getResources(), R.mipmap.bj);

        my.jg0=BitmapFactory.decodeResource(getResources(),R.mipmap.jiguang0);
        my.jg1=BitmapFactory.decodeResource(getResources(),R.mipmap.jiguang1);

        my.list.clear();
        my.drlist.clear();
        my.myhjlist.clear();
        new Thread(new loaddr()).start();//新建一个 加载敌人的线程
        new Thread(new re()).start();//新建一个线程 让画布自动重绘


    }
    @Override
    protected void onDraw(Canvas g) {//这个相当于swing的paint方法吧 用于绘制屏幕上的所有物体
        super.onDraw(g);
        Paint paint = new Paint();
        Paint paint1 = new Paint();
        Paint paint2 = new Paint();
        Paint paint3 = new Paint();
        Paint paint4 = new Paint();
        g.drawBitmap(my.b.img,null,my.b.r,p);//画背景 我没有把背景添加到list里
        if(my.jgkey) {
            g.drawBitmap(my.j.img, null, my.j.r, p);//画激光
        }

        for(int i=0;i<my.list.size();i++){//我们把所有的飞行物都添加到了my.list这个集合里
            hj h=my.list.get(i);           //然后在这里用一个for循环画出来
            g.drawBitmap(h.img,null,h.r,p);
        }



        //血条
        paint.setColor(Color.GREEN);//设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//设置为空心
        g.drawRect(x1,y1+200,x1+200,y1+190,paint);//画出长为200宽为10的空心矩形
        paint1.setColor(Color.GREEN);
        int hp = 200 * hua.HP/100;  //计算当前血量百分比求出现血条长度
        g.drawRect(x1,y1+200,x1+hp,y1+190,paint1);//画出长为hp宽为10的实心矩形

       //能量条
        paint2.setColor(Color.rgb(223,121,0));//设置画笔颜色
        paint2.setStrokeWidth(10);//设置画笔粗细
        paint2.setStyle(Paint.Style.STROKE);//设置为空心
        g.drawRect(1015,305,1045,1505,paint2);//画出空心矩形
        paint3.setColor(Color.YELLOW);
        int nl = 1200 * my.power/50; //计算能量百分比，得到能量条高度
        if(my.power>=50){
            g.drawRect(1020,300,1040,1500,paint3);//能量满时不再增加，放止溢出
        }else{
            g.drawRect(1020,1500-nl,1040,1500,paint3);//能量不满时根据n1绘制实心矩形
        }


        switch (my.js/10){
            case 0:my.nd=1;g.drawText("当前难度为 "+my.nd,400,my.h-1400,p);break;
            case 1:my.nd=2;g.drawText("难度提升！",400,my.h-1500,p);g.drawText("当前难度为 "+my.nd,400,my.h-1400,p);break;
            case 2:my.nd=3;g.drawText("难度提升！",400,my.h-1500,p);g.drawText("当前难度为 "+my.nd,400,my.h-1400,p);break;
            case 3:my.nd=4;g.drawText("难度提升！",400,my.h-1500,p);g.drawText("当前难度为 "+my.nd,400,my.h-1400,p);break;
            case 5:my.nd=5;g.drawText("难度提升！",400,my.h-1500,p);g.drawText("当前难度为 "+my.nd,400,my.h-1400,p);break;
            case 7:my.nd=6;g.drawText("难度提升！！",400,my.h-1500,p);g.drawText("当前难度为 "+my.nd,400,my.h-1400,p);break;
            case 10:my.nd=7;g.drawText("难度提升！！",400,my.h-1500,p);g.drawText("当前难度为 "+my.nd,400,my.h-1400,p);break;
            case 13:my.nd=8;g.drawText("难度提升！！",400,my.h-1500,p);g.drawText("当前难度为 "+my.nd,400,my.h-1400,p);break;
            case 16:my.nd=9;g.drawText("难度提升！！！",400,my.h-1500,p);g.drawText("当前难度为 "+my.nd,400,my.h-1400,p);break;
            case 20:my.nd=10;g.drawText("难度提升！！！",400,my.h-1500,p);g.drawText("当前难度为 "+my.nd,400,my.h-1400,p);break;
        }


        g.drawText("击杀敌机数:"+my.js,700,my.h-1750,p);
        g.drawText("难度："+my.nd,700,my.h-1700,p);
        g.drawText("母舰生命："+hua.mjhp,700,my.h-1800,p);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {//这个方法用来获取屏幕宽高的
        super.onSizeChanged(w, h, oldw, oldh);
        my.w=w;//获取宽
        my.h=h;//高

        //获取手机（应该不是手机的吧 是这控件的吧）分辨率和1920*1080的比例
        //然后飞机的宽高乘上这个分辨率就能在不同大小的屏幕正常显示了
        //为什么用1920*1080呢 因为我手机就是这个分辨率。。。
        my.bili= (float) (Math.sqrt(my.w * my.h)/ Math.sqrt(1920 * 1080));
        p.setTextSize(50*my.bili);//设置字体大小，“击杀”的大小
        p.setColor(Color.WHITE);//设为白色
        //好了 到这里游戏开始了
        my.b=new bj();//初始化背景
        my.j=new jg();
        my.mj=new mujian();//初始化 母舰
        my.my=new myhj();//初始化 我的灰机


    }
    private class loaddr implements Runnable{
        private int rd;
        int count=0;
        @Override
        public void run() {
            while(hua.HP>0&&hua.mjhp>0) {
                if(FuncTion&&MainActivity.Tnumber==0) {
                    rd = (int) (Math.random() * 10);
                    count++;
                    if(my.nd>=4&&count%20==0){
                        try {
                            Thread.sleep(600);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            new xuebao();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //每1000ms刷一个敌人
                    switch (rd) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:

                            try {
                                Thread.sleep(600);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            try {
                                new drfj0();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            try {
                                Thread.sleep(900);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            try {
                                new drfj1();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 8:
                        case 9:
                            try {
                                Thread.sleep(1200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            try {
                                new drfj2();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                }
            }
        }
    }
    public class re implements Runnable {
        @Override
        public void run() {
            //每10ms刷新一次界面
            while(hua.HP>0&&hua.mjhp>0){
                if(FuncTion) {
                    try {
                        if(my.js<200){
                            switch (my.js/10){
                                case 0:my.nd=1;break;
                                case 1:my.nd=2;break;
                                case 2:my.nd=3;break;
                                case 3:
                                case 4:my.nd=4;break;
                                case 5:
                                case 6:my.nd=5;break;
                                case 7:
                                case 8:
                                case 9:my.nd=6;break;
                                case 10:
                                case 11:
                                case 12:my.nd=7;break;
                                case 13:
                                case 14:
                                case 15:my.nd=8;break;
                                case 16:
                                case 17:
                                case 18:
                                case 19:my.nd=9;break;
                            }
                        }
                        else my.nd=10;
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(my.nd<10){
                        my.sj+=1;
                        my.nd=1+my.sj/600;
                    }
                    postInvalidate();
                }
                //刷新画布
            }
            my.list.clear();
            my.drlist.clear();
            my.myhjlist.clear();
        }
    }

}


class hj{//游戏内所有物体的父类
    public RectF r=new RectF();//这个是用来确定位置的
    public int hp;//敌机生命

    public float w,h;//宽高
    public Bitmap img;//图片


    //这里的画图方法和swing的不太一样
    //设两个方法来设置x,y的坐标
    public void setX(float x){
        r.left=x;
        r.right=x+w;
    }
    public void setY(float y){
        r.top=y;
        r.bottom=y+h;
    }

    public boolean pengzhuang(hj obj,float px) {//判断碰撞 判断时忽略px个像素
        px*=my.bili;//凡是涉及到像素的 都乘一下分辨率比例my.bili
        if (r.left+px - obj.r.left <= obj.w && obj.r.left - this.r.left <= this.w-px)
            if (r.top+px - obj.r.top <= obj.h && obj.r.top - r.top+px <= h-px-px)  {
                return true;
            }
        return false;

    }
}

class jg extends hj implements Runnable {
    public jg() {
        w = my.w;
        h = my.h;//背景的高是 屏幕高的两倍
        img = my.jg0;
        setX(0);
        setY(0);
       new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            if (my.jgkey == true && hua.FuncTion == true) {
                try {
                    Thread.sleep(200);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (img == my.jg1) {
                    img = my.jg0;
                } else if (img == my.jg0) {
                    img = my.jg1;
                }
            }
        }
    }
}

class bj extends hj implements  Runnable{//背景
    public bj(){
        w=my.w;
        h=my.h*2;//背景的高是 屏幕高的两倍
        img=my.bj;
        setX(0);
        setY(-my.h);
        new Thread(this).start();
    }
    @Override
    public void run() {
        //这里控制背景一直向下移
        while(true){
            if(hua.FuncTion) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (r.top + 2 <= 0) {
                    setY(r.top + 2);
                } else {
                    setY(-my.h);
                }
            }
        }
    }
}

class drfj0 extends hj implements Runnable{//敌人飞机
    private long sd0=(long) (3);
    int count=0;
    /*private float sd0=(float) (Math.random()*1)+1;*///生成一个[10,20)的随机数 用来控制敌人速度 敌人速度是不一样的

    public drfj0(){

        if(my.nd<10){
            sd0-=0.15*my.nd;
        }
        else sd0-=1.5;


//        w=my.w/5.4f;
//        h=my.h/9.6f;
        w=h=150*my.bili;
        //敌人刷出来的位置
        setX((float)( Math.random()*(my.w-w)));//x是随机的
        setY(-h);//在屏幕外 刚好看不到的位置
        img=my.drfj0;
        hp=5;//生命
        my.list.add(this);//添加到集合里 这样才能被画出来
        my.drlist.add(this);//添加到敌人的集合 添加进这个集合子弹才打得到
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(hp>0){//如果生命>0 没有死 就继续向前飞，死了还飞什么？
            if(hua.FuncTion) {
                try {
                    Thread.sleep(sd0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                if(count%30==0){
                    if(img==my.drfj0){
                        img=my.drfj01;
                    }else if(img==my.drfj01){
                        img=my.drfj0;
                    }
                }
                setY(r.top + 2 * my.bili);
            }
        }
        count=0;
        SoundPlayUtils.play(2,1,1);

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        img=my.drfj02;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        img=my.drfj03;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        img=my.drfj04;

        //从集合删除
        my.list.remove(this);
        my.drlist.remove(this);
    }
}

class drfj1 extends hj implements Runnable{//敌人飞机
    private long sd0=(long) (5);//生成一个[10,20)的随机数 用来控制敌人速度 敌人速度是不一样的
    int count=0;
    float count1=0;
    public drfj1(){
        if(my.nd<10){
            sd0-=0.31*my.nd;
        }
        else sd0-=3.1;
//        w=my.w/5.4f;
//        h=my.h/9.6f;
        w=250*my.bili;
        h=430*my.bili;
        //敌人刷出来的位置
        setX((float)( Math.random()*(my.w-w)));//x是随机的
        setY(-h);//在屏幕外 刚好看不到的位置
        img=my.drfj10;
        hp=18;//生命
        my.list.add(this);//添加到集合里 这样才能被画出来
        my.drlist.add(this);//添加到敌人的集合 添加进这个集合子弹才打得到
        new Thread(this).start();

    }

    @Override
    public void run() {
        while(hp>0){
            //如果生命>0 没有死 就继续向前飞，死了还飞什么？
            if(hua.FuncTion) {
                count++;
                count1++;
                try {
                    Thread.sleep(sd0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(count%50==0){
                    if(img==my.drfj11){
                        img=my.drfj10;
                    }else if(img==my.drfj10){
                        img=my.drfj11;
                    }
                }
                setY(r.top + 2 * my.bili);

            }

            if(count1==600+my.nd*25&&MainActivity.Tnumber==0){
                new drzd01(this);
                new drzd02(this);
                count1=101;
            }else if(count1==100&&MainActivity.Tnumber==0){
                new drzd01(this);
                new drzd02(this);
            }

        }
        count=0;
        count1=0;
        SoundPlayUtils.play(2,1,1);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        img=my.drfj12;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        img=my.drfj13;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        img=my.drfj14;


        //从集合删除
        my.list.remove(this);
        my.drlist.remove(this);
    }
}

class drfj2 extends hj implements Runnable{//敌人飞机
    /*private long sd0=(long) (Math.random()*1)+1;*///生成一个[10,20)的随机数 用来控制敌人速度 敌人速度是不一样的
    private long sd0=(long) (10);
    int count=0;
    public drfj2(){
        if(my.nd<10){
            sd0-=0.8*my.nd;
        }
        else sd0-=8;
//        w=my.w/5.4f;
//        h=my.h/9.6f;
        w=500*my.bili;
        h=300*my.bili;
        //敌人刷出来的位置
        setX((float)( Math.random()*(my.w-w)));//x是随机的
        setY(-h);//在屏幕外 刚好看不到的位置
        img=my.drfj2;
        hp=33;//生命
        my.list.add(this);//添加到集合里 这样才能被画出来
        my.drlist.add(this);//添加到敌人的集合 添加进这个集合子弹才打得到

        new Thread(this).start();
    }

    @Override
    public void run() {
        while(hp>0){
            //如果生命>0 没有死 就继续向前飞，死了还飞什么？
            if(hua.FuncTion) {
                if(hp<28){
                    img=my.drfj21;
                }
                if(hp<14){
                    img=my.drfj22;
                }
                try {
                    Thread.sleep(sd0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setY(r.top + 2 * my.bili);
                count++;
                //System.out.println(count);
            }
            if(count==400+my.nd*50&&MainActivity.Tnumber==0){
                new drzd0(this);
                new drzd1(this);
                new drzd2(this);
                count=101;
            }
            else if(count==100&&MainActivity.Tnumber==0){
                new drzd0(this);
                new drzd1(this);
                new drzd2(this);
            }

        }
        SoundPlayUtils.play(2,1,1);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        img=my.drfj23;
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        img=my.drfj24;

        //从集合删除

        my.list.remove(this);
        my.drlist.remove(this);
    }
}

class myhj  extends hj implements Runnable {//我的灰机

    public myhj() {
        w = h = 200 * my.bili;//凡是涉及到像素的 都乘一下分辨率比例my.bili
        //设置初始位置
        setX(my.w / 2 - w / 2);
        setY(my.h * 0.7f - h / 2);
        img = my.myhj;//初始化图片
        my.myhjlist.add(this);//添加到集合里 这样才能被画出来
        my.list.add(this);//添加到集合里 这样才能被画出来
        new Thread(this).start();//发射子弹的线程
    }

    @Override
    public void run() {
        while (hua.HP > 0&&hua.mjhp>0) {
            if (hua.FuncTion) {
                //90毫秒发射一发子弹
                try {
                    Thread.sleep(90);
                    for (int i = 0; i < my.drlist.size(); i++) {
                        hj h = my.drlist.get(i);

                        if (pengzhuang(h, -3)) {
                            //判断碰撞
                            if(h.hp>0) {
                                //System.out.println(h.toString().charAt(34));
                               //敌人生命-5
                                switch (h.toString().charAt(34)){
                                    case 'a':
                                        if(hua.HP+3>100&&hua.mjhp+3<=100){
                                            hua.HP=100;
                                            hua.mjhp+=3;
                                        }
                                        else if (hua.mjhp+3>100&&hua.HP+3<=100){
                                            hua.mjhp=100;
                                            hua.HP+=3;
                                        }
                                        else if(hua.mjhp+3>100&&hua.HP+3>100){
                                            hua.HP=100;
                                            hua.mjhp=100;
                                        }
                                        else{
                                            hua.HP+=3;
                                            hua.mjhp+=3;
                                        }
                                        break;
                                    case '0':
                                        hua.HP = hua.HP - 2;
                                        break;
                                    case '1':
                                        hua.HP = hua.HP - 4;
                                        break;
                                    case '2':
                                        hua.HP = hua.HP - 8;
                                        break;
                                }
                                h.hp=0;

                            }
                            if(h.hp==0){
                                my.js++;//击杀+1
                                my.power++;
                            }
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new myzd0(this);
                new myzd1(this);
                new myzd2(this);
            }
        }

    }
}

class mujian extends  hj implements  Runnable {//母舰

    public mujian() {
        h = 800 * my.bili;
        w = 1200 * my.bili;
        setX(my.w / 2 - w / 2);
        setY(my.h * 0.85f);
        img = my.mujian;//初始化图片
        my.list.add(this);//添加到集合里 这样才能被画出来
        new Thread(this).start();
    }

    @Override
    public void run() {
        int count = 0;
        int tt = 1;
        int uu = 0;
        while (hua.HP > 0 && hua.mjhp > 0) {
            if (hua.FuncTion) {
                try {
                    Thread.sleep(5);
                    for (int i = 0; i < my.drlist.size(); i++) {
                        hj h = my.drlist.get(i);
                        if (pengzhuang(h, 3)) {
                            //判断碰撞
                            if (h.hp > 0) {
                                //System.out.println(h.toString().charAt(34));
                                my.js++;//击杀+1
                                my.power++;
                                h.hp = 0;//敌人生命-5
                                switch (h.toString().charAt(34)) {
                                    case '0':
                                        hua.mjhp = hua.mjhp - 2;
                                        break;
                                    case '1':
                                        hua.mjhp = hua.mjhp - 4;
                                        break;
                                    case '2':
                                        hua.mjhp = hua.mjhp - 8;
                                        break;
                                }
                            }
                        }

                    }

                } catch
                        (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if (MainActivity.Tnumber == 1) {
                count++;
                //tt判断换图用
                if (count % 10 == 0) {
                    if (img == my.mujian && tt == 1) {
                        img = my.MK1;
                    } else if (img == my.MK1 && tt == 1) {
                        img = my.MK2;
                    } else if (img == my.MK2 && tt == 1) {
                        img = my.MK3;
                    } else if (img == my.MK3 && tt == 1) {
                        img = my.MK4;
                    } else if (img == my.MK4 && tt == 1) {
                        img = my.MK5;
                    } else if (img == my.MK5 && tt == 1) {
                        img = my.MK6;
                    } else if (img == my.MK6 && tt == 1) {
                        img = my.MK7;
                    } else if (img == my.MK7 && tt == 1) {
                        img = my.MK8;
                    }
                    else if (img == my.MK8 && tt == 1) {
                        img = my.MK9;

                        while (uu < 5) {
                            for (int i = 0; i < my.list.size(); i++) {
                                hj v = my.list.get(i);
                                //v.toString().charAt(30) == 'd'：
                                // 意思是找出句柄中第三十位是d的元素
                                // 因为只有敌方飞机开头是d字母
                                if (v.toString().charAt(30) == 'd') {
                                    my.list.remove(i);
                                 //从集合删除,当从集合中删除后
                                 // 画笔不会绘制出敌机，既达到消灭敌机效果
                                }
                            }
                            uu++;
                            //检测五次
                        }
                        uu = 0;
                        my.drlist.clear();//清空敌人集合
                        SoundPlayUtils.play(4,1,1);//播放激光炮音效

                        //防止有残留敌机，再进行一轮清屏
                        for(int i=0;i<10;i++){
                            try {
                                Thread.sleep(400);
                                while (uu < 3) {
                                    for (int j = 0; j < my.list.size(); j++) {
                                        hj v = my.list.get(j);
                                        //v.toString().charAt(30) == 'd'：
                                        // 意思是找出句柄中第三十位是d的元素
                                        // 因为只有敌方飞机开头是d字母
                                        if (v.toString().charAt(30) == 'd') {
                                            my.list.remove(j);//从集合删除
                                        }
                                    }
                                    uu++;
                                }
                                uu = 0;
                                my.drlist.clear();//清空敌人集合
                            } catch
                                    (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        tt = 2;//判断换图用
                    }
                }
                if (count % 10 == 0) {
                    if (img == my.MK9&& tt == 2) {
                        img = my.MK7;
                    } else if (img == my.MK7 && tt == 2) {
                        img = my.MK6;
                    } else if (img == my.MK6 && tt == 2) {
                        img = my.MK5;
                    } else if (img == my.MK5 && tt == 2) {
                        img = my.MK4;
                    } else if (img == my.MK4 && tt == 2) {
                        img = my.MK3;
                    } else if (img == my.MK3 && tt == 2) {
                        img = my.MK2;
                    } else if (img == my.MK2 && tt == 2) {
                        img = my.MK1;
                    } else if (img == my.MK1 && tt == 2) {
                        img = my.mujian;
                        count = 0;
                        tt=1;
                        MainActivity.Tnumber = 0;
                        //全局变量归0，等待下次激光炮开启
                    }
                }

            }
        }
    }
}

class myzd0 extends hj implements Runnable {//我的子弹
        private int dps;
        private float sd0;

        public myzd0(hj hj) {
            w = 20 * my.bili;
            h = 60 * my.bili;//凡是涉及到像素的 都乘一下分辨率比例my.bili
            img = my.myzd0;//图片
            sd0 = 6 * my.bili;//速度=6
            dps = 1;//伤害=1
            //设在玩家中心的偏上一点
            setX(hj.r.left + hj.w / 2 - w / 2);
            setY(hj.r.top - h / 2);
            my.list.add(this);//添加到集合里 这样才能被画出来
            new Thread(this).start();//新建一个子弹向上移动的线程
        }

        @Override
        public void run() {
            boolean flag = false;//一个标记 用来跳出嵌套循环
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setY(r.top - sd0);//向上移sd0个像素，sd0=6

                try {//try一下 怕出错
                    //这里判断有没有和集合里的敌人发生碰撞
                    for (int i = 0; i < my.drlist.size(); i++) {
                        hj h = my.drlist.get(i);
                        if (pengzhuang(h, 30)&&(h.toString().charAt(34))!='a') {//判断碰撞
                          if (h.hp>0){
                            SoundPlayUtils.play(1, 0.2f, 0.2f);
                          }
                                h.hp -= dps;//敌人生命-子弹伤害
                           // }
                            flag = true;//一个标记 用来跳出嵌套循环
                            if (h.hp == 0) {
                                my.js++;//击杀+1
                                my.power++;
                            }
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                if (flag || r.top + h <= 0) break;//如果子弹击中过敌人 或者超出屏幕范围 跳出循环
            }
            my.list.remove(this);//从集合删除
        }

    }

class myzd1 extends hj implements Runnable {//我的子弹
        private int dps;
        private float sd0;

        public myzd1(hj hj) {
            w = 20 * my.bili;
            h = 60 * my.bili;//凡是涉及到像素的 都乘一下分辨率比例my.bili
            img = my.myzd1;//图片
            sd0 = 6 * my.bili;//速度=6
            dps = 1;//伤害=1
            //设在玩家中心的偏上一点
            setX(hj.r.left + hj.w / 2 + 2 * w);
            setY(hj.r.top - h / 2);
            my.list.add(this);//添加到集合里 这样才能被画出来
            new Thread(this).start();//新建一个子弹向上移动的线程
        }

        @Override
        public void run() {
            boolean flag = false;//一个标记 用来跳出嵌套循环
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setY(r.top - sd0);//向上移sd0个像素，sd0=6

                try {//try一下 怕出错
                    //这里判断有没有和集合里的敌人发生碰撞
                    for (int i = 0; i < my.drlist.size(); i++) {
                        hj h = my.drlist.get(i);
                        if (pengzhuang(h, 30)&&(h.toString().charAt(34))!='a') {//判断碰撞
                           if (h.hp>0) {
                               SoundPlayUtils.play(1, 0.2f, 0.2f);
                           }
                                h.hp -= dps;//敌人生命-子弹伤害
                           // }
                            flag = true;//一个标记 用来跳出嵌套循环
                            if (h.hp == 0) {
                               // SoundPlayUtils.play(2,1,1);
                                my.js++;//击杀+1
                                my.power++;
                            }
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                if (flag || r.top + h <= 0) break;//如果子弹击中过敌人 或者超出屏幕范围 跳出循环
            }
            my.list.remove(this);//从集合删除
        }

    }

class myzd2 extends hj implements Runnable {//我的子弹
        private int dps;
        private float sd0;

        public myzd2(hj hj) {
            w = 20 * my.bili;
            h = 60 * my.bili;//凡是涉及到像素的 都乘一下分辨率比例my.bili
            img = my.myzd2;//图片
            sd0 = 6 * my.bili;//速度=6
            dps = 1;//伤害=1
            //设在玩家中心的偏上一点
            setX(hj.r.left + hj.w / 2 - 3* w);
            setY(hj.r.top - h / 2);
            my.list.add(this);//添加到集合里 这样才能被画出来
            new Thread(this).start();//新建一个子弹向上移动的线程
        }

        @Override
        public void run() {
            boolean flag = false;//一个标记 用来跳出嵌套循环
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setY(r.top - sd0);//向上移sd0个像素，sd0=6

                try {//try一下 怕出错
                    //这里判断有没有和集合里的敌人发生碰撞
                    for (int i = 0; i < my.drlist.size(); i++) {
                        hj h = my.drlist.get(i);
                        if (pengzhuang(h, 30)&&(h.toString().charAt(34))!='a') {//判断碰撞
                           if (h.hp>0) {
                               SoundPlayUtils.play(1, 0.2f, 0.2f);
                           }
                            h.hp -= dps;//敌人生命-子弹伤害
                            flag = true;//一个标记 用来跳出嵌套循环
                            if (h.hp == 0) {
                                my.js++;//击杀+1
                                my.power++;
                         //       SoundPlayUtils.play(2,1,1);
                            }
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                if (flag || r.top + h <= 0) break;//如果子弹击中过敌人 或者超出屏幕范围 跳出循环
            }
            my.list.remove(this);//从集合删除
        }

    }

class drzd0 extends hj implements Runnable {//我的子弹
    private int dps;
    private float sd0;

    public drzd0(hj hj) {
        w = 60 * my.bili;
        h = 60 * my.bili;//凡是涉及到像素的 都乘一下分辨率比例my.bili
        img = my.dfzd2;//图片
        sd0 = 0.7f * my.bili;//速度=6
        dps = 2;//伤害=1
        //设在玩家中心的偏上一点
        setX(hj.r.left + hj.w / 2 - w / 2);
        setY(hj.r.top + hj.h-h);

        my.list.add(this);//添加到集合里 这样才能被画出来
        new Thread(this).start();//新建一个子弹向上移动的线程
    }

    @Override
    public void run() {

        boolean flag = false;//一个标记 用来跳出嵌套循环
        while (true) {

            if(hua.FuncTion) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setY(r.top + sd0);//向上移sd0个像素，sd0=6
                try {//try一下 怕出错
                    //这里判断有没有和集合里的敌人发生碰撞
                    for (int i = 0; i < my.myhjlist.size(); i++) {

                        hj h = my.myhjlist.get(i);
                        if (pengzhuang(h, 30)) {//判断碰撞
                            hua.HP -= dps;//敌人生命-子弹伤害
                            flag = true;//一个标记 用来跳出嵌套循环
                            break;
                        }

                        //  System.out.println(h);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }

                if (flag || r.top > 1920) break;//如果子弹击中过敌人 或者超出屏幕范围 跳出循环
            }

        }
        my.list.remove(this);//从集合删除
    }

}

class drzd1 extends hj implements Runnable {//我的子弹
    private int dps;
    private float sd0;

    public drzd1(hj hj) {
        w = 60 * my.bili;
        h = 60 * my.bili;//凡是涉及到像素的 都乘一下分辨率比例my.bili
        img = my.dfzd2;//图片
        sd0 = 0.7f * my.bili;//速度=6
        dps = 1;//伤害=1
        //设在玩家中心的偏上一点
        setX(hj.r.left + hj.w / 2 - w / 2);
        setY(hj.r.top + hj.h-h);

        my.list.add(this);//添加到集合里 这样才能被画出来
        new Thread(this).start();//新建一个子弹向上移动的线程
    }

    @Override
    public void run() {
        boolean flag = false;//一个标记 用来跳出嵌套循环
        while (true) {

            if (hua.FuncTion) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setX(r.left + sd0);
                setY(r.top + sd0 * 0.85f);//向上移sd0个像素，sd0=6
                try {//try一下 怕出错
                    //这里判断有没有和集合里的敌人发生碰撞
                    for (int i = 0; i < my.myhjlist.size(); i++) {

                        hj h = my.myhjlist.get(i);
                        if (pengzhuang(h, 30)) {//判断碰撞
                            hua.HP -= dps;//敌人生命-子弹伤害
                            flag = true;//一个标记 用来跳出嵌套循环
                            break;
                        }

                        //  System.out.println(h);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                if (flag || r.top > 1920) break;//如果子弹击中过敌人 或者超出屏幕范围 跳出循环
            }
        }
        my.list.remove(this);//从集合删除
    }

}

class drzd2 extends hj implements Runnable {//我的子弹
    private int dps;
    private float sd0;

    public drzd2(hj hj) {
        w = 60 * my.bili;
        h = 60 * my.bili;//凡是涉及到像素的 都乘一下分辨率比例my.bili
        img = my.dfzd2;//图片
        sd0 = 0.7f * my.bili;//速度=6
        dps = 1;//伤害=1
        //设在玩家中心的偏上一点
        setX(hj.r.left + hj.w / 2 - w / 2);
        setY(hj.r.top + hj.h-h);

        my.list.add(this);//添加到集合里 这样才能被画出来
        new Thread(this).start();//新建一个子弹向上移动的线程
    }

    @Override
    public void run() {
        boolean flag = false;//一个标记 用来跳出嵌套循环

        while (true) {

            if (hua.FuncTion) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setX(r.left - sd0);
                setY(r.top + sd0 * 0.85f);//向上移sd0个像素，sd0=6
                try {//try一下 怕出错
                    //这里判断有没有和集合里的敌人发生碰撞
                    for (int i = 0; i < my.myhjlist.size(); i++) {

                        hj h = my.myhjlist.get(i);
                        if (pengzhuang(h, 30)) {//判断碰撞
                            hua.HP -= dps;//敌人生命-子弹伤害
                            flag = true;//一个标记 用来跳出嵌套循环
                            break;
                        }

                        //  System.out.println(h);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                if (flag || r.top > 1920) break;//如果子弹击中过敌人 或者超出屏幕范围 跳出循环
            }
        }
        my.list.remove(this);//从集合删除
    }

}

class drzd01 extends hj implements Runnable {//我的子弹
    private int dps;
    private float sd0;

    public drzd01(hj hj) {
        w = 80 * my.bili;
        h = 80 * my.bili;//凡是涉及到像素的 都乘一下分辨率比例my.bili
        img = my.dfzd3;//图片
        sd0 = my.bili;//速度=6
        dps = 1;//伤害=1
        //设在玩家中心的偏上一点
        setX(hj.r.left + hj.w / 2 - w-w/8);
        setY(hj.r.top + hj.h-h);

        my.list.add(this);//添加到集合里 这样才能被画出来
        new Thread(this).start();//新建一个子弹向上移动的线程
    }

    @Override
    public void run() {
        boolean flag = false;//一个标记 用来跳出嵌套循环
        while (true) {
            if (hua.FuncTion) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setX(r.left - 0.1f * sd0);
                setY(r.top + sd0);//向上移sd0个像素，sd0=6
                try {//try一下 怕出错
                    //这里判断有没有和集合里的敌人发生碰撞
                    for (int i = 0; i < my.myhjlist.size(); i++) {

                        hj h = my.myhjlist.get(i);
                        if (pengzhuang(h, 30)) {//判断碰撞
                            hua.HP -= dps;//敌人生命-子弹伤害
                            flag = true;//一个标记 用来跳出嵌套循环
                            break;
                        }

                        //  System.out.println(h);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }

                if (flag || r.top > 1920) break;//如果子弹击中过敌人 或者超出屏幕范围 跳出循环
            }
        }
        my.list.remove(this);//从集合删除
    }

}

class drzd02 extends hj implements Runnable {//我的子弹
    private int dps;
    private float sd0;

    public drzd02(hj hj) {
        w = 80 * my.bili;
        h =80 * my.bili;//凡是涉及到像素的 都乘一下分辨率比例my.bili
        img = my.dfzd4;//图片
        sd0 = my.bili;//速度=6
        dps = 1;//伤害=1
        //设在玩家中心的偏上一点
        setX(hj.r.left + hj.w / 2 + w/8);
        setY(hj.r.top + hj.h-h);

        my.list.add(this);//添加到集合里 这样才能被画出来
        new Thread(this).start();//新建一个子弹向上移动的线程
    }

    @Override
    public void run() {
        boolean flag = false;//一个标记 用来跳出嵌套循环
        while (true) {
            if (hua.FuncTion) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setX(r.left + 0.1f * sd0);
                setY(r.top + sd0);//向上移sd0个像素，sd0=6
                try {//try一下 怕出错
                    //这里判断有没有和集合里的敌人发生碰撞
                    for (int i = 0; i < my.myhjlist.size(); i++) {

                        hj h = my.myhjlist.get(i);
                        if (pengzhuang(h, 30)) {//判断碰撞
                            hua.HP -= dps;//敌人生命-子弹伤害
                            flag = true;//一个标记 用来跳出嵌套循环
                            break;
                        }

                        //  System.out.println(h);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }

                if (flag || r.top > 1920) break;//如果子弹击中过敌人 或者超出屏幕范围 跳出循环
            }
        }
        my.list.remove(this);//从集合删除
    }

}

class xuebao extends hj implements Runnable {//血包
    private long sd0 = (long) (3);

    public xuebao() {

//        w=my.w/5.4f;
//        h=my.h/9.6f;
        w = h = 125 * my.bili;
        //敌人刷出来的位置
        setX((float) (Math.random() * (my.w - w)));//x是随机的
        setY(-h);//在屏幕外 刚好看不到的位置
        img = my.xuebao;
        hp = 1;//生命
        my.list.add(this);//添加到集合里 这样才能被画出来
        my.drlist.add(this);//添加到敌人的集合 添加进这个集合子弹才打得到
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (hp > 0) {
            if (hua.FuncTion) {
                try {
                    Thread.sleep(sd0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setY(r.top + 2 * my.bili);
            }
            if (r.top >= my.h) {
                break;//飞出屏幕 跳出循环
            }
        }
        //从集合删除
        my.list.remove(this);
        my.drlist.remove(this);
    }
}