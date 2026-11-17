package model;

/**
 * Новий різновид (автобус), доданий, щоб показати: код обробки масиву
 * у Main НЕ змінюється при появі нового типу.
 */
public class Bus extends Transport {
    private final double costPerKm;

    public Bus(String name, double costPerKm) {
        super(name);
        this.costPerKm = costPerKm;
    }

    @Override
    public double tripCost(double km) {
        return km * costPerKm;
    }
}
