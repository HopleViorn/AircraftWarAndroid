package edu.hitsz.creator;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.MobEnemy;

public class MobEnemyFactory implements AbstractAircraftFactory{

    @Override
    public AbstractAircraft create(int locationX, int locationY, int speedX, int speedY) {
        return new MobEnemy(locationX,locationY,speedX,speedY,30);
    }
}
