package lesson14.multithreading.list;

import java.util.List;

/**
 * @author spasko
 */
public class WriteThread extends Thread {

    private List<Integer> list;

    public WriteThread(String name, List<Integer> list) {
        this.list = list;
        super.setName(name);
    }

    @Override
    public void run() {
        int count = 6;

        while (true) {

            try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            list.add(count++);

            System.out.println(super.getName() + " done");
        }
    }
}