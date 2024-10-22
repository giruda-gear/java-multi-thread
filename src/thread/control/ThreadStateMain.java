package thread.control;

import static util.MyLogger.log;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState());
        log("myThread.start");
        thread.start();
        Thread.sleep(500);
        log("myThread.state3 = " + thread.getState());
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log("run()");
            log("myThread.state2 = " + Thread.currentThread().getState());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
