package edu.hitsz.creator;

import edu.hitsz.prop.AbstractProp;
import edu.hitsz.prop.BulletProp;

public class BulletPropFactory implements AbstractPropFactory{
    @Override
    public AbstractProp create(int locationX, int locationY, int speedX, int speedY) {
        return new BulletProp(locationX,locationY,speedX,speedY);
    }
}
