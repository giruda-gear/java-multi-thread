package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV1 {

    public static void main(String[] args) throws InterruptedException {
        log("____ S T A R T ____");

        SumTask task1 = new SumTask(0, 51);
        SumTask task2 = new SumTask(51, 101);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int result = task1.result + task2.result;
        log("result: " + result);
        log("____ E N D ____");
    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("start job");
            sleep(500);

            int sum = 0;
            for (int i = startValue; i < endValue; i++) {
                sum += i;
            }
            result = sum;

            log("end job: result = " + result);
        }
    }
}
