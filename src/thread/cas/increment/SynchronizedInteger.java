package thread.cas.increment;

public class SynchronizedInteger implements IncrementInteger {

    private int value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
