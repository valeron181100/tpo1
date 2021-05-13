package first;

public class MyMath {

    public static double cos(double x){
        double delta = 1.0;
        double sum = 0.0;
        int i = 1;

        do {
            sum += delta;
            delta *= -1.0 * x * x / ((2 * i - 1) * (2 * i));
            i++;
        } while (Math.abs(delta) > 0.00000001);

        return sum;
    }
}
