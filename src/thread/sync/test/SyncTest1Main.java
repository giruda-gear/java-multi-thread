package thread.sync.test;

public class SyncTest1Main {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable task = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        };

        Thread t0 = new Thread(task);
        Thread t1 = new Thread(task);

        t0.start();
        t1.start();
        t0.join();
        t1.join();

        System.out.println("result: " + counter.getCount()); // 20000
    }

    static class Counter {

        private int count = 0;

        public synchronized void increment() {
            count += 1;
        }

        public int getCount() {
            return count;
        }
    }
}
