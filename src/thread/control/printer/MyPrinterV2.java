package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class MyPrinterV2 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("insert (exit=q)");
            String input = scanner.nextLine();
            if (input.equals("q")) {
//                printer.work = false;
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {
//        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
//            while (work) {
            log("=============");
            log(Thread.currentThread().isInterrupted());
            log("=============");
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    Thread.yield();
                    continue;
                }

                try {
                    String job = jobQueue.poll();
                    log("print start: " + job + ", wating list: " + jobQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log("interrupted !!!");
                    break;
                }
                log("print complete");
            }
            log(Thread.currentThread().isInterrupted());
            log("printer end");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
}
