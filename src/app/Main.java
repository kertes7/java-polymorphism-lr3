package app;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import model.Account;
import model.CreditAccount;
import model.CurrentAccount;
import model.DepositAccount;
import model.SavingsAccount;

public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        PrintStream out = System.out;

        // Клієнтський код тримає об'єкти в масиві БАЗОВОГО типу.
        Account[] accounts = {
                new SavingsAccount("Іван", 10000, 6),
                new CurrentAccount("Петро", 2500, 50),
                new CreditAccount("Олена", -3000, 24),
        };

        out.println("=== Поліморфна обробка через базовий тип Account ===");
        process(out, accounts);

        // Додаємо НОВИЙ різновид — код обробки process() НЕ змінюється.
        Account[] extended = new Account[accounts.length + 1];
        System.arraycopy(accounts, 0, extended, 0, accounts.length);
        extended[accounts.length] = new DepositAccount("Сергій", 20000, 8);

        out.println();
        out.println("=== Після додавання DepositAccount (код обробки той самий) ===");
        process(out, extended);
    }

    /** Обробка однакова для всіх різновидів — без перевірки конкретного типу (instanceof). */
    private static void process(PrintStream out, Account[] accounts) {
        double totalAccrual = 0;
        for (Account a : accounts) {                 // підстановка будь-якого різновиду замість базового типу
            double accrual = a.monthlyAccrual();
            totalAccrual += accrual;
            out.printf(Locale.US, "%-16s власник %-7s -> нарахування за місяць: %+.2f%n",
                    a.kind(), a.owner(), accrual);
        }
        out.printf(Locale.US, "РАЗОМ нарахувань: %+.2f%n", totalAccrual);
    }
}
