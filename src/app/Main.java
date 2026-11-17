package app;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import model.Bus;
import model.Car;
import model.Motorcycle;
import model.Transport;
import model.Truck;

public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        PrintStream out = System.out;

        // Клієнтський код тримає об'єкти в масиві БАЗОВОГО типу.
        Transport[] fleet = {
                new Car("Toyota", 3.5),
                new Truck("Volvo", 9.0),
                new Motorcycle("Yamaha", 2.0),
        };

        out.println("=== Поліморфна обробка через базовий тип Transport (поїздка 100 км) ===");
        process(out, fleet, 100);

        // Додаємо НОВИЙ різновид — код обробки process() НЕ змінюється.
        Transport[] extended = new Transport[fleet.length + 1];
        System.arraycopy(fleet, 0, extended, 0, fleet.length);
        extended[fleet.length] = new Bus("MAN", 5.0);

        out.println();
        out.println("=== Після додавання Bus (код обробки той самий) ===");
        process(out, extended, 100);
    }

    /** Обробка однакова для всіх різновидів — без перевірки конкретного типу (instanceof). */
    private static void process(PrintStream out, Transport[] fleet, double km) {
        double total = 0;
        for (Transport t : fleet) {                  // підстановка будь-якого різновиду замість базового типу
            double cost = t.tripCost(km);
            total += cost;
            out.printf(Locale.US, "%-12s (%-7s) -> %.2f%n", t.kind(), t.name(), cost);
        }
        out.printf(Locale.US, "РАЗОМ за поїздку: %.2f%n", total);
    }
}
