package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV0 {

    public static void main(String[] args) {
        log("____ S T A R T ____");

        Thread thread1 = new Thread(new Job(), "thread-1");
        Thread thread2 = new Thread(new Job(), "thread-2");

        thread1.start();
        thread2.start();

        log("____ E N D ____");
    }

    static class Job implements Runnable {

        @Override
        public void run() {
            log("start job");
            sleep(1000);
            log("end job");
        }
    }
}
