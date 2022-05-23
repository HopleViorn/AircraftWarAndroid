package edu.hitsz.strategy;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.BulletType;

import java.util.List;

public interface Strategy {
    public List<BaseBullet> shoot(int baseX, int baseY, int baseSpeedX, int baseSpeedY);
}
