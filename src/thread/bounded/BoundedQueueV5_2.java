package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static util.MyLogger.log;

public class BoundedQueueV5_2 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV5_2(int maxSize) {
        this.queue = new ArrayBlockingQueue<>(maxSize);
    }

    @Override
    public void put(String data) {
        boolean result = queue.offer(data);
        log("put result: " + result);
    }

    @Override
    public String take() {
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
