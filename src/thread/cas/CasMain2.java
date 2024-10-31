package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class CasMain2 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("initial value = " + atomicInteger.get());

//        int result = atomicInteger.incrementAndGet();
//        System.out.println("result = " + result);

        int result = incrementAndGet(atomicInteger);
        System.out.println("result = " + result);
        int result2 = incrementAndGet(atomicInteger);
        System.out.println("result2 = " + result2);
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;

        do {
            getValue = atomicInteger.get();
            log("getValue: " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result: " + result);
        } while (!result);

        return getValue + 1;
    }
}