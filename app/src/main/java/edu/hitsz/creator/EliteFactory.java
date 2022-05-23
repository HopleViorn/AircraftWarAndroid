package edu.hitsz.creator;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.Elite;

public class EliteFactory implements AbstractAircraftFactory {

    @Override
    public AbstractAircraft create(int locationX,int locationY,int speedX,int speedY) {
        return new Elite(locationX,locationY,speedX,speedY,60);
    }
}
