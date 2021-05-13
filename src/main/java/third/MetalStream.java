package third;

public class MetalStream implements LiquidStream {
    private double filledPercent = 0;
    private static final int MAX_MATERIAL = 123;


    @Override
    public void addMaterial(double number) {
        double delta = number * 100 / MAX_MATERIAL;
        filledPercent += (double) Math.round(delta * 100) / 100;;
        System.out.println("Ручей металла заполнен на " + getFilledPercent() + " %");
    }

    @Override
    public double getFilledPercent() {
        return filledPercent;
    }
}
