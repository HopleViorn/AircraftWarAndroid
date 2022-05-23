package edu.hitsz.creator;

import edu.hitsz.prop.AbstractProp;
import edu.hitsz.prop.BloodProp;

public class BloodPropFactory implements AbstractPropFactory{
    @Override
    public AbstractProp create(int locationX, int locationY, int speedX, int speedY) {
        return new BloodProp(locationX,locationY,speedX,speedY);
    }
}
