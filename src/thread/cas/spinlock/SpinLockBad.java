package thread.cas.spinlock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockBad {
    private volatile boolean lock = false;

    public void lock() {
        log("try to get a lock ..");

        while (true) {
            if (!lock) {
                sleep(100);
                lock = true;
                break;
            } else {
                log("fail to get a lock, spin-wait");
            }
        }
        log("[complete] get a lock");
    }

    public void unlock() {
        lock = false;
        log("[return] lock");
    }
}
