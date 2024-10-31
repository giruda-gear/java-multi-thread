package thread.cas.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

import static util.MyLogger.log;

public class SpinLock {
    private final AtomicBoolean locked = new AtomicBoolean(false);

    public void lock() {
        log("try to get a lock ..");

        while (!locked.compareAndSet(false, true)) {
            log("fail to get a lock, spin-wait");
        }

        log("[complete] get a lock");
    }

    public void unlock() {
        locked.set(false);
        log("[return] lock");
    }
}
