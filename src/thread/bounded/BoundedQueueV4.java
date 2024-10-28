package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

public class BoundedQueueV4 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition producerCondition = lock.newCondition();
    private final Condition consumerCondition = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();
    private final int maxSize;

    public BoundedQueueV4(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void put(String data) {
        lock.lock();
        try {
            while (queue.size() == maxSize) {
                log("[put] queue is full, get a producer waited");
                try {
//                    wait();
                    producerCondition.await();
                    log("[put] producer is awake");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("[put] producer saves data, consumerCondition.signal()");
//            notify();
            consumerCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    @Override
    public String take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log("[put] queue is empty, get a consumer waited");
                try {
                    consumerCondition.await();
                    log("[take] consumer is awake");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = queue.poll();
            log("[take] consumer takes data, producerCondition.signal()");
            producerCondition.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
