package lesson14.multithreading.semaphore;

/**
 * @author spasko
 */
import java.util.concurrent.Semaphore;

public class MainSemaphore {
    public static void main(String[] args) {
        // one permission
        Semaphore semaphore = new Semaphore(2);
        CommonResource commonResource = new CommonResource(0);
        new Thread(new CountRunnable(commonResource, semaphore, "A")).start();
        new Thread(new CountRunnable(commonResource, semaphore, "B")).start();
        new Thread(new CountRunnable(commonResource, semaphore, "C")).start();
    }
}
