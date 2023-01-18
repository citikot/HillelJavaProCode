package lesson14.multithreading.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author spasko
 */
public class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String message;
            // consuming messages until exit message is received
            while (!"exit".equals(message = queue.take())) {
                Thread.sleep(10);
                System.out.println("Consumed " + message);
            }
            System.out.println("Consumer get last message");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
