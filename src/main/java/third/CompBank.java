package third;

public class CompBank implements Building {

    private String name;
    private int compAmount;
    private int heatPoints = 100;

    public CompBank(String name, int compAmount) {
        this.name = name;
        this.compAmount = compAmount;
    }

    public int getHeatPoints() {
        return heatPoints;
    }

    @Override
    public String getDamage(int damage, LiquidStream liquidStream) {
        if (heatPoints - damage < 0)
            return "Здание уже разрушено!";
        else {
            heatPoints -= damage;
            if (compAmount > 1) {
                liquidStream.addMaterial(2);
                compAmount -= 2;
            }
            if (heatPoints == 0)
                return "Здание уничтожено!";
            return "У здания " + name + " осталось " + heatPoints + " hp";
        }
    }
}
