package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

public class BoundedQueueV5_4 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV5_4(int maxSize) {
        this.queue = new ArrayBlockingQueue<>(maxSize);
    }

    @Override
    public void put(String data) {
        queue.add(data); // java.lang.IllegalStateException
    }

    @Override
    public String take() {
        return queue.remove(); // java.util.NoSuchElementException
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
