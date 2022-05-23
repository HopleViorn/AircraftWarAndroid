package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bus.MeEvent;
import edu.hitsz.bus.Subscriber;
import edu.hitsz.strategy.FireStrategy;
import edu.hitsz.strategy.Single;

import java.util.LinkedList;
import java.util.List;

import static edu.hitsz.bullet.BulletType.ENEMY;

public class Elite extends AbstractAircraft{

    FireStrategy fireStrategy=new FireStrategy(new Single(ENEMY,1,1,30));

    public Elite(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    @Override
    public void forward(double timeInterval) {
        super.forward(timeInterval);
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    @Override
    public List<BaseBullet> shoot() {
        return fireStrategy.executeStrategy(this.getLocationX(),this.getLocationY(),this.getSpeedX(),this.getSpeedY());
    }
}
