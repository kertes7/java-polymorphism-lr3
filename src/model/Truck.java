package model;

/** Вантажівка: вищий тариф за км (враховує вантаж/паливо). */
public class Truck extends Transport {
    private final double costPerKm;

    public Truck(String name, double costPerKm) {
        super(name);
        this.costPerKm = costPerKm;
    }

    @Override
    public double tripCost(double km) {
        return km * costPerKm;
    }
}
