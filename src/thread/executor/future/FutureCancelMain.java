package thread.executor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureCancelMain {

    private static boolean mayInterruptIfRunning = false;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());
        log("Future.state: " + future.state());

        sleep(2000);
        log("Future.cancel(" + mayInterruptIfRunning + ")");
        boolean result = future.cancel(mayInterruptIfRunning);
        log("Future.cancel(" + mayInterruptIfRunning + ") result: " + result);

        try {
            log("Future result: " + future.get());
        } catch (CancellationException e) {
            log("Future is canceled already");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        es.close();
    }

    static class MyTask implements Callable<String> {
        @Override
        public String call() {
            try {
                for (int i = 0; i < 10; i++) {
                    log("working: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                log("interrupt occurs");
                return "Interrupted";
            }
            return "Completed";
        }
    }
}
