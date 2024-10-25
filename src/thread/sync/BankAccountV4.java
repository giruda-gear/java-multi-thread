package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV4 implements BackAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("Start transfer: " + getClass().getSimpleName());

        lock.lock();
        try {
            log("[Start validation] amount: " + amount + ", balance: " + balance);
            if (balance < amount) {
                log("[Failed to validate] amount: " + amount + ", balance: " + balance);
                return false;
            }

            log("[Succeed to validate] amount: " + amount + ", balance: " + balance);
            sleep(1000);
            balance -= amount;
            log("Withdraw Succeed amount: " + amount + ", balance: " + balance);
        } finally {
            lock.unlock();
        }
        log("End transfer");

        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
