package edu.hitsz.application.game;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.Boss;
import edu.hitsz.aircraft.Elite;
import edu.hitsz.aircraft.MobEnemy;
import edu.hitsz.application.AbstractGame;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class CasualMode extends AbstractGame {
    public CasualMode(){
        super();
        //3,4
        super.cycleDuration=new int[]{1200,600};
        super.cycleTime=new int[]{0,0};
    }

    @Override
    public void bossSpawn() {
        boss=null;
    }

    @Override
    protected void enemySpawn() {
        //2
        int enemyMaxNumber=1;
        if (enemyAircrafts.size() < enemyMaxNumber) {
            MobEnemy mobEnemy = (MobEnemy) mobEnemyFactory.create(
                    (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())) * 1,
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.2) * 1,
                    0,
                    10
            );
            publisher.subscribe(mobEnemy);
            enemyAircrafts.add(mobEnemy);
        }
        //5
        if (Math.random() < 0.1) {//精英敌机
            Elite elite = (Elite)
                    eliteFactory.create(
                            (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())) * 1,
                            (int) (Math.random() * Main.WINDOW_HEIGHT * 0.2) * 1,
                            (int) ((Math.random() - 0.5) * 10),
                            15
                    );
            publisher.subscribe(elite);
            enemyAircrafts.add(elite);
        }
    }
}