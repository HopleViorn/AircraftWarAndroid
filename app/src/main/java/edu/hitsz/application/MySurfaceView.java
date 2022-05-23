package edu.hitsz.application;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;

import java.io.FileInputStream;

import edu.hitsz.R;

public class MySurfaceView extends SurfaceView implements
        SurfaceHolder.Callback,Runnable {
    int count = 0;
    public float x = 50, y = 50;
    int screenWidth = 480, screenHeight = 800;
    boolean mbLoop = false; //控制绘画线程的标志位
    private SurfaceHolder mSurfaceHolder;
    private Canvas canvas;  //绘图的画布
    private Paint mPaint;

    public void loadImage() {
        ImageManager.BACKGROUND_IMAGE = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

        ImageManager.BACKGROUND_IMAGE2 = BitmapFactory.decodeResource(getResources(), R.drawable.bg2);
        ImageManager.BACKGROUND_IMAGE3 = BitmapFactory.decodeResource(getResources(), R.drawable.bg3);
        ImageManager.BACKGROUND_IMAGE4 = BitmapFactory.decodeResource(getResources(), R.drawable.bg4);
        ImageManager.BACKGROUND_IMAGE5 = BitmapFactory.decodeResource(getResources(), R.drawable.bg5);;

        ImageManager.HERO_IMAGE = BitmapFactory.decodeResource(getResources(), R.drawable.hero);
        ImageManager.MOB_ENEMY_IMAGE = BitmapFactory.decodeResource(getResources(), R.drawable.mob);
        ImageManager.ELITE_IMAGE=BitmapFactory.decodeResource(getResources(), R.drawable.elite);

        ImageManager.HERO_BULLET_IMAGE = BitmapFactory.decodeResource(getResources(), R.drawable.bullet_hero);
        ImageManager.ENEMY_BULLET_IMAGE = BitmapFactory.decodeResource(getResources(), R.drawable.bullet_enemy);
        ImageManager.BOSS_IMAGE=BitmapFactory.decodeResource(getResources(), R.drawable.boss);

        ImageManager.PROP_BLOOD_IMAGE=BitmapFactory.decodeResource(getResources(), R.drawable.prop_blood);
        ImageManager.PROP_BOMB_IMAGE=BitmapFactory.decodeResource(getResources(), R.drawable.prop_bomb);
        ImageManager.PROP_BULLET_IMAGE=BitmapFactory.decodeResource(getResources(), R.drawable.prop_bullet);
        ImageManager.updateMap();
    }

    public MySurfaceView(Context context) {
        super(context);
        mbLoop = true;
        mPaint = new Paint();  //设置画笔
        mSurfaceHolder = this.getHolder();
        mSurfaceHolder.addCallback(this);
        this.setFocusable(true);
        loadImage();
    }
    public void draw(){
        //通过SurfaceHolder对象的lockCanvans()方法，我们可以获取当前的Canvas绘图对象
        canvas = mSurfaceHolder.lockCanvas();
        if(mSurfaceHolder == null || canvas == null){
            return;
        }
        if(count < 100){
            count ++;
        }else {
            count = 0;
        }
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        //绘制一个全屏大小的矩形
        canvas.drawRect(0,0,screenWidth, screenHeight, mPaint);
        switch (count % 4){
            case 0:
                mPaint.setColor(Color.BLUE);
                break;
            case 1:
                mPaint.setColor(Color.GREEN);
                break;
            case 2:
                mPaint.setColor(Color.RED);
                break;
            case 3:
                mPaint.setColor(Color.YELLOW);
                break;
            default:
                mPaint.setColor(Color.WHITE);
        }
        //绘制一个圆形
        canvas.drawCircle(x,y,50,mPaint);
        //通过unlockCanvasAndPost(mCanvas)方法对画布内容进行提交
        mSurfaceHolder.unlockCanvasAndPost(canvas);
    }
    @Override
    public void run() {
        //设置一个循环来绘制，通过标志位来控制开启绘制还是停止
        while (mbLoop){
            synchronized (mSurfaceHolder){
                draw();
            }
            try {
                Thread.sleep(200);
            }catch (Exception e){}
        }
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        new Thread(this).start();
    }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        screenWidth = width;
        screenHeight = height;
    }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        mbLoop = false;
    }
}
