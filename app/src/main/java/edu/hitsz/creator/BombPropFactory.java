package edu.hitsz.creator;

import edu.hitsz.prop.AbstractProp;
import edu.hitsz.prop.BombProp;

public class BombPropFactory implements AbstractPropFactory{
    @Override
    public AbstractProp create(int locationX, int locationY, int speedX, int speedY) {
        return new BombProp(locationX,locationY,speedX,speedY);
    }
}
