package edu.hitsz.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import edu.hitsz.R;
import edu.hitsz.user.UserDao;
import edu.hitsz.user.UserDaoImpl;

public class MainActivity extends AppCompatActivity {
    private MySurfaceView mySurfaceView;
    public static int screenWidth;
    public static int screenHeight;
    public static UserDao userDao = new UserDaoImpl();
    public static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySurfaceView = new MySurfaceView(this);
        getScreenHW();
        mySurfaceView.screenWidth=screenWidth;
        mySurfaceView.screenHeight=screenHeight;
        setContentView(mySurfaceView);
    }

    public void getScreenHW() {
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth=displayMetrics.widthPixels;
        screenHeight=displayMetrics.heightPixels;
    }
    
    

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mySurfaceView.x = event.getX();
            mySurfaceView.y = event.getY();
        }
        return  true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            this.finish();
        }
        return true;
    }
}