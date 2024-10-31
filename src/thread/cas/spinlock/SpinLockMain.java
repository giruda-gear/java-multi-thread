package thread.cas.spinlock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockMain {

    public static void main(String[] args) {
//        SpinLockBad spinLockBad = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable task = new Runnable() {

            @Override
            public void run() {
                spinLock.lock();
                try {
                    // critical section
                    log("business logic");
                    sleep(1);
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}
