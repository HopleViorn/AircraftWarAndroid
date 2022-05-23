package edu.hitsz.creator;

import edu.hitsz.aircraft.AbstractAircraft;

public interface AbstractAircraftFactory{
    public AbstractAircraft create(int locationX,int locationY,int speedX,int speedY);
}
