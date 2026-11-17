package model;

/** Автомобіль: вартість = відстань * тариф за км. */
public class Car extends Transport {
    private final double costPerKm;

    public Car(String name, double costPerKm) {
        super(name);                       // ініціалізація базової частини через super
        this.costPerKm = costPerKm;
    }

    @Override
    public double tripCost(double km) {
        return km * costPerKm;
    }
}
