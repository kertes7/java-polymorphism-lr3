package model;

/** Поточний: місячна плата за обслуговування (-). */
public class CurrentAccount extends Account {
    private final double monthlyFee;

    public CurrentAccount(String owner, double balance, double monthlyFee) {
        super(owner, balance);
        this.monthlyFee = monthlyFee;
    }

    @Override
    public double monthlyAccrual() {
        return -monthlyFee;                    // списання комісії
    }
}
