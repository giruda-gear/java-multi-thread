package thread.start;

public class HelloRunnableMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloRunnable runnable = new HelloRunnable(); // task
        Thread thread = new Thread(runnable); // thread
        thread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
