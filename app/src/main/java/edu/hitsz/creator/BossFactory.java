package edu.hitsz.creator;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.Boss;

public class BossFactory implements AbstractAircraftFactory {

    @Override
    public AbstractAircraft create(int locationX,int locationY,int speedX,int speedY) {
        return new Boss(locationX,locationY,speedX,speedY,60);
    }
}
