package edu.hitsz.bullet;


import edu.hitsz.application.MainActivity;
import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.bus.MeEvent;
import edu.hitsz.bus.Subscriber;

/**
 * 子弹类。
 * 也可以考虑不同类型的子弹
 *
 * @author hitsz
 */
public class BaseBullet extends AbstractFlyingObject implements Subscriber {

    private int power = 10;

    public BaseBullet(int locationX, int locationY, int speedX, int speedY, int power) {
        super(locationX, locationY, speedX, speedY);
        this.power = power;
    }

    @Override
    public void forward(double timeInterval) {
        super.forward(timeInterval);

        // 判定 x 轴出界
        if (locationX <= 0 || locationX >= MainActivity.screenWidth) {
            vanish();
        }

        // 判定 y 轴出界
        if (speedY > 0 && locationY >= MainActivity.screenHeight) {
            // 向下飞行出界
            vanish();
        }else if (locationY <= 0){
            // 向上飞行出界
            vanish();
        }
    }


    public int getPower() {
        return power;
    }

    @Override
    public void listen(MeEvent meEvent) {
        switch(meEvent){
            case bombEvent:
                this.vanish();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + meEvent);
        }
    }
}
