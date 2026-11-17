package model;

/**
 * Базовий тип ієрархії (варіант 3 — Рахунок).
 * Спільні дані (owner, balance) і спільна операція monthlyAccrual()
 * оголошені тут; конкретні різновиди перевизначають операцію.
 */
public abstract class Account {

    protected final String owner;   // спільні дані — у базовому класі
    protected double balance;

    protected Account(String owner, double balance) {   // базова частина ініціалізується тут
        this.owner = owner;
        this.balance = balance;
    }

    /** Спільна операція: нарахування за місяць (по-різному в різновидах). */
    public abstract double monthlyAccrual();

    public String kind()    { return getClass().getSimpleName(); }
    public String owner()   { return owner; }
    public double balance() { return balance; }
}
