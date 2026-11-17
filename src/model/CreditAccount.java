package model;

/** Кредитний: проценти на борг (від'ємний залишок) (-). */
public class CreditAccount extends Account {
    private final double annualRatePct;

    public CreditAccount(String owner, double balance, double annualRatePct) {
        super(owner, balance);
        this.annualRatePct = annualRatePct;
    }

    @Override
    public double monthlyAccrual() {
        if (balance >= 0) return 0.0;
        return balance * (annualRatePct / 100.0 / 12.0);   // нарахування на борг (balance<0 -> від'ємне)
    }
}
