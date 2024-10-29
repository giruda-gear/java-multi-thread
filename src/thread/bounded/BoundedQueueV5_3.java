package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

public class BoundedQueueV5_3 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV5_3(int maxSize) {
        this.queue = new ArrayBlockingQueue<>(maxSize);
    }

    @Override
    public void put(String data) {
        boolean result = false;
        try {
            result = queue.offer(data, 1, TimeUnit.NANOSECONDS);
            log("put result: " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String take() {
        try {
            return queue.poll(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
