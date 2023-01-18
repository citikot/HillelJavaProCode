package lesson13.multithreading.executor;

/**
 * @author spasko
 */
public class CountRunnable implements Runnable {

    private CommonResource commonResource;
    private String name;

    CountRunnable(CommonResource commonResource, String name) {
        this.commonResource = commonResource;
        this.name = name;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                commonResource.incrementValue();
                System.out.printf("%s %d \n", name, commonResource.getValue());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}