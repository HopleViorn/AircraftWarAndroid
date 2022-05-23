package edu.hitsz.aircraft;

//import edu.hitsz.application.MusicThread;
import edu.hitsz.bullet.*;
import edu.hitsz.bus.MeEvent;
import edu.hitsz.strategy.FireStrategy;
import edu.hitsz.strategy.Scattered;
import edu.hitsz.strategy.Single;

import java.util.List;

import static edu.hitsz.bullet.BulletType.*;

/**
 * 英雄飞机，游戏玩家操控
 * @author hitsz
 */
public class HeroAircraft extends AbstractAircraft {

    /** 攻击方式 */
    FireStrategy fireStrategy=new FireStrategy(new Single(HERO,-1,2,30));

    /**
     * @param locationX 英雄机位置x坐标
     * @param locationY 英雄机位置y坐标
     * @param speedX 英雄机射出的子弹的基准速度（英雄机无特定速度）
     * @param speedY 英雄机射出的子弹的基准速度（英雄机无特定速度）
     * @param hp    初始生命值
     */

    private static HeroAircraft instance;
    private HeroAircraft(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }
    public static  HeroAircraft getInstance(int locationX, int locationY, int speedX, int speedY, int hp){
        if(instance == null){
            synchronized(HeroAircraft.class){
                if(instance == null){
                    instance = new HeroAircraft(locationX, locationY, speedX, speedY, hp);
                }
            }
        }
        return instance;
    }

    public void fireSupply() {
        Runnable r=()-> {
            try {
                fireStrategy.setStrategy(new Scattered(HERO,-1,6,30));
                for(int i=5;i>=1;--i) {
                    System.out.println("Fire supply will be end in "+ i +"s.");
                    Thread.sleep(1000);
                }
                fireStrategy.setStrategy(new Single(HERO,-1,2,30));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(r).start();
    }

    @Override
    public void forward(double timeInterval) {
        // 英雄机由鼠标控制，不通过forward函数移动
    }

    @Override
    public void listen(MeEvent meEvent){
        return ;
    }
    @Override
    /**
     * 通过射击产生子弹
     * @return 射击出的子弹List
     */
    public List<BaseBullet> shoot() {
        //new MusicThread("src/videos/bullet.wav",false).start();
        return fireStrategy.executeStrategy(this.getLocationX(),this.getLocationY(),this.getSpeedX(),this.getSpeedY());
    }

}
