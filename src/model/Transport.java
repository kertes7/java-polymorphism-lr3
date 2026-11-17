package model;

/**
 * Базовий тип ієрархії (варіант 0 — Транспорт).
 * Спільні дані (name) і спільна операція tripCost() оголошені тут;
 * конкретні різновиди перевизначають операцію.
 */
public abstract class Transport {

    protected final String name;        // спільні дані — у базовому класі

    protected Transport(String name) {  // базова частина ініціалізується тут
        this.name = name;
    }

    /** Спільна операція: вартість поїздки на задану відстань (км). */
    public abstract double tripCost(double km);

    public String kind() { return getClass().getSimpleName(); }
    public String name() { return name; }
}
