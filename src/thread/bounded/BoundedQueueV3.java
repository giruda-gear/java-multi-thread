package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedQueueV3 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int maxSize;

    public BoundedQueueV3(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() == maxSize) {
            log("[put] queue is full, get a producer waited");
            try {
                wait(); // RUNNABLE -> WAITING, return lock
                log("[put] producer is awake");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(data);
        log("[put] producer save data, call notify()");
        notify(); // WAIT -> BLOCKED
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[put] queue is empty, get a consumer waited");
            try {
                wait();
                log("[take] consumer is awake");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String data = queue.poll();
        log("[take] consumer take data, call notify()");
        notify(); // WAIT -> BLOCKED
        return data;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
