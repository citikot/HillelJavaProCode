package lesson12.multithreading.createthread;

import java.util.concurrent.TimeUnit;

/**
 * @author spasko
 */
public class MainTheadCreator {
    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread()
                    .getName();
            System.out.println("Hello " + threadName);
        };

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");

        IntCounter count = new IntCounter(0);
        Runnable task2 = () -> {
            for (int i = 0; i < 5000; i++) {
                count.increment();
            }
        };

        (new Thread(task2)).start();
        (new Thread(task2)).start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Result count:" + count.getCount());
    }

    private static class IntCounter {
        private int count;

        public IntCounter(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void increment() {
            count++;
        }

    }
}
