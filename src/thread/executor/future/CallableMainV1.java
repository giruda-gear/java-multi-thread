package thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        log("submit()");
        // FutureTask.run() -> MyCallable.call()
        Future<Integer> future = executorService.submit(new MyCallable());
        log("future: " + future);
        future.state();
        log("future state: " + future.state());
        Integer result = future.get();
        log("future state: " + future.state());

        log("result: " + result);
        executorService.close();
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("call");
            sleep(1000);
            int value = new Random().nextInt(50);
            log("value: " + value);
            return value;
        }
    }
}
