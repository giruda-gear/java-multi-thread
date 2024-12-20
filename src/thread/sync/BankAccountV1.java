package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV1 implements BackAccount {

    private int balance;

    public BankAccountV1(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("Start transfer: " + getClass().getSimpleName());

        log("Start validation");
        if (balance < amount) {
            log("[Failed to validate] amount: " + amount + ", balance: " + balance);
            return false;
        }

        log("[Succeed to validate] amount: " + amount + ", balance: " + balance);
        sleep(1000);
        balance -= amount;
        log("Withdraw Succeed amount: " + amount + ", balance: " + balance);

        log("End transfer");
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
