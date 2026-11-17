package model;

/** Мотоцикл: найнижчий тариф за км. */
public class Motorcycle extends Transport {
    private final double costPerKm;

    public Motorcycle(String name, double costPerKm) {
        super(name);
        this.costPerKm = costPerKm;
    }

    @Override
    public double tripCost(double km) {
        return km * costPerKm;
    }
}
