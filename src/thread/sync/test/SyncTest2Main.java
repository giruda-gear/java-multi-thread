package thread.sync.test;

import static util.MyLogger.log;

public class SyncTest2Main {

    public static void main(String[] args) throws InterruptedException {

        MyCounter counter = new MyCounter();

        Runnable task = () -> {
            counter.count();
        };

        Thread t0 = new Thread(task);
        Thread t1 = new Thread(task);

        t0.start();
        t1.start();
    }

    static class MyCounter {

        public void count() {
            int localValue = 0;
            for (int i = 0; i < 1000; i++) {
                localValue += 1;
            }
            log("result: " + localValue);
        }
    }
}
