package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        t.start();

        sleep(1000);
        task.flag = false;
        log("flag = " + task.flag + ", count = " + task.count + " [Main]");
    }

    static class MyTask implements Runnable {

        boolean flag = true;
        long count;

        @Override
        public void run() {
            log("+++ task START");
            while (flag) {
                count++;
                if (count % 100_000_000 == 0) {
                    log("flag = " + flag + ", count = " + count + " [Inside loop]");
                }
            }
            log("flag = " + flag + ", count = " + count + " [END]");
        }
    }
}
