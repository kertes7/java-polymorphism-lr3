package model;

/**
 * Новий різновид (депозит), доданий, щоб показати: код обробки масиву
 * у Main НЕ змінюється при появі нового типу.
 */
public class DepositAccount extends Account {
    private final double annualRatePct;

    public DepositAccount(String owner, double balance, double annualRatePct) {
        super(owner, balance);
        this.annualRatePct = annualRatePct;
    }

    @Override
    public double monthlyAccrual() {
        return balance * (annualRatePct / 100.0 / 12.0) * 1.2;  // підвищена ставка депозиту
    }
}
