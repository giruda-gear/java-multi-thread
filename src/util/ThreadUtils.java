package util;

import static util.MyLogger.log;

public class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("interrupted while sleep: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
