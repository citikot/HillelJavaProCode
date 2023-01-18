package lesson14.multithreading.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author spasko
 */
public class Producer implements Runnable {

    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // produce messages
        for (int i = 0; i < 50; i++) {
            String message = "Message " + i;
            try {
                Thread.sleep(i);
                queue.put(message);
                System.out.println("Produced " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // adding exit message
        String exitMessage = "exit";
        try {
            queue.put(exitMessage);
            System.out.println("Produced send last message");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}