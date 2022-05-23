package edu.hitsz.bullet;

import edu.hitsz.bus.MeEvent;

/**
 * @Author hitsz
 */
public class HeroBullet extends BaseBullet {

    public HeroBullet(int locationX, int locationY, int speedX, int speedY, int power) {
        super(locationX, locationY, speedX, speedY, power);
    }
    @Override
    public void listen(MeEvent meEvent){
        return ;
    }
}
