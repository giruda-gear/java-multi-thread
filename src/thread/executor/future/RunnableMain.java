package thread.executor.future;

import java.util.Random;

import static util.MyLogger.log;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task);
        thread.start();
        thread.join();

        int result = task.value;
        log("result: " + result);
    }

    static class MyRunnable implements Runnable {
        int value;

        @Override
        public void run() {
            log("[Start] Runnable");
            value = new Random().nextInt(50);
            log("value: " + value);
            log("[End] Runnable");
        }
    }
}
