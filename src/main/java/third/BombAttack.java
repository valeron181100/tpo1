package third;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class BombAttack implements Attack {

    private final int baseDamage = 10;
    private AtomicInteger bombCount = new AtomicInteger(15);
    private Building building;
    private  LiquidStream liquidStream;
    private boolean isStopped = false;

    public BombAttack(Building building, LiquidStream liquidStream) {
        this.building = building;
        this.liquidStream = liquidStream;
    }


    @Override
    public int getDamage() {
        return this.baseDamage;
    }

    @Override
    public String attack() {
        if (isStopped)
            return "Невозможно начать аттаку так как она была остановлена!";
        if (bombCount.get() != 0) {
            bombCount.decrementAndGet();
            String buildingStr = building.getDamage(getDamage(), liquidStream);
            if (building.getHeatPoints() == 0)
                return buildingStr;

            return "Было нанесено " + getDamage() + " урона бомбой.";
        } else {
            return "Атака не может быть начата из-за нехватки снарядов!";
        }
    }

    @Override
    public String stop() {
        isStopped = true;
        return "Атака была остановлена!";
    }
}
