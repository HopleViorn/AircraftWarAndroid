package edu.hitsz.strategy;
import edu.hitsz.bullet.*;
import java.util.List;

public class FireStrategy {
    private Strategy strategy;
    public FireStrategy(Strategy strategy){
        this.strategy=strategy;
    }
    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }
    public List<BaseBullet> executeStrategy(int baseX, int baseY, int baseSpeedX, int baseSpeedY){
        return strategy.shoot(baseX,baseY,baseSpeedX,baseSpeedY);
    }
}
