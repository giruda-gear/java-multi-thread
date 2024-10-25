package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest());
        thread.start();
        sleep(100);
        log("thread state: " + thread.getState());
        LockSupport.unpark(thread);
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("Start park");
            LockSupport.park();
            log("End park, state: " + Thread.currentThread().getState());
            log("Interrupt state: " + Thread.currentThread().isInterrupted());
        }
    }
}
