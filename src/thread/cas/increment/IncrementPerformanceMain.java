package thread.cas.increment;

public class IncrementPerformanceMain {

    public static final long COUNT = 100_000_000;

    public static void main(String[] args) {
        test(new BasicInteger()); // CPU Cache
        test(new VolatileInteger());
        test(new SynchronizedInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }

        long end = System.currentTimeMillis();

        System.out.println(incrementInteger.getClass().getSimpleName() + " ms=" + (end - start));
    }
}
