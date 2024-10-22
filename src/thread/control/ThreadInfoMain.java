package thread.control;

import static util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log("main Thread = " + mainThread);
        log("main threadId() = " + mainThread.threadId());
        log("main getName() = " + mainThread.getName());
    }
}
