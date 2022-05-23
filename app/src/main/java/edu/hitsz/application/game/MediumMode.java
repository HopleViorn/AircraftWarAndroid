package edu.hitsz.application.game;

import android.content.Context;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.Boss;
import edu.hitsz.aircraft.Elite;
import edu.hitsz.aircraft.MobEnemy;
import edu.hitsz.application.AbstractGame;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.MainActivity;

public class MediumMode extends AbstractGame {
    public MediumMode(Context context){
        super(context);
        //3,4
        super.cycleDuration=new int[]{600,600};
        super.cycleTime=new int[]{0,0};
    }

    @Override
    public void bossSpawn() {
        boss=null;
        for(AbstractAircraft enemy : enemyAircrafts) {
            if(enemy instanceof Boss){
                boss= (Boss) enemy;
                break;
            }
        }
        if(boss!=null) return ;

        //1
        int bossScoreThreshold = 100;
        if(score-lastscore>= bossScoreThreshold){
            enemyAircrafts.add(
                    (Boss) bossFactory.create(
                            (int) (Math.random() * (MainActivity.screenWidth - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                            (int) (Math.random() * MainActivity.screenHeight * 0.2),5,0)
            );
            lastscore = score;
        }
    }

    @Override
    protected void enemySpawn() {
        System.out.println("Medieum");
        //2
        int enemyMaxNumber=5;
        if (enemyAircrafts.size() < enemyMaxNumber) {
            MobEnemy mobEnemy = (MobEnemy) mobEnemyFactory.create(
                    (int) (Math.random() * (MainActivity.screenWidth - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * MainActivity.screenHeight * 0.2),
                    0,
                    10
            );
            publisher.subscribe(mobEnemy);
            enemyAircrafts.add(mobEnemy);
        }
        //5
        if (Math.random() < 0.6) {//精英敌机
            Elite elite = (Elite)
                    eliteFactory.create(
                            (int) (Math.random() * (MainActivity.screenWidth - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                            (int) (Math.random() * MainActivity.screenHeight * 0.2),
                            (int) ((Math.random() - 0.5) * 10),
                            15
                    );
            publisher.subscribe(elite);
            enemyAircrafts.add(elite);
        }
    }
}