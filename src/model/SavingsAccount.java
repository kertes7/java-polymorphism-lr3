package model;

/** Ощадний: проценти на позитивний залишок (+). */
public class SavingsAccount extends Account {
    private final double annualRatePct;

    public SavingsAccount(String owner, double balance, double annualRatePct) {
        super(owner, balance);                 // ініціалізація базової частини через super
        this.annualRatePct = annualRatePct;
    }

    @Override
    public double monthlyAccrual() {
        return balance * (annualRatePct / 100.0 / 12.0);   // нарахування відсотків
    }
}
