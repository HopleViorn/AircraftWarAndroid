package edu.hitsz.strategy;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.BulletType;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class Single implements Strategy{
    int direction;
    int shootNum;
    int power;
    BulletType bulletType;
    public Single(BulletType bulletType,int direction,int shootNum,int power){
        this.bulletType=bulletType;
        this.direction=direction;
        this.shootNum=shootNum;
        this.power=power;
    }
    @Override
    public List<BaseBullet> shoot(int baseX,int baseY,int baseSpeedX,int baseSpeedY){
        List<BaseBullet> res = new LinkedList<>();
        int x = baseX;
        int y = baseY + direction*2;
        int speedX = baseSpeedX;
        int speedY = baseSpeedY + direction*20;
        BaseBullet baseBullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            if(bulletType==BulletType.HERO) {
                baseBullet = new HeroBullet(x + (i * 2 - shootNum + 1) * 10, y, speedX, speedY, power);
            }
            else if(bulletType==BulletType.ENEMY) {
                baseBullet = new EnemyBullet(x + (i * 2 - shootNum + 1) * 10, y, speedX, speedY, power);
            }else baseBullet=null;

            res.add(baseBullet);
        }
        return res;
    }
}
