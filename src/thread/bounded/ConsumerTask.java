package thread.bounded;

import static util.MyLogger.log;

public class ConsumerTask implements Runnable {

    BoundedQueue queue;

    public ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log("[try to consume]   ? <- " + queue);
        String data = queue.take();
        log("[succeeded to consume] <- " + queue);
    }
}
