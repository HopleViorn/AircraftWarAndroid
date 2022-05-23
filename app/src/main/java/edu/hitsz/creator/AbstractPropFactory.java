package edu.hitsz.creator;

import edu.hitsz.prop.AbstractProp;

public interface AbstractPropFactory {
    public AbstractProp create(int locationX, int locationY, int speedX, int speedY);
}
