package lesson14.multithreading.list;

import java.util.Iterator;
import java.util.List;

/**
 * @author spasko
 */
public class ReadThread extends Thread {
    private List<Integer> list;

    public ReadThread(String name, List<Integer> list) {
        this.list = list;
        super.setName(name);
    }

    @Override
    public void run() {

        while (true) {

            StringBuilder output = new StringBuilder();
            output.append("\n" + super.getName() + ":");

            Iterator<Integer> iterator = list.iterator();

            while (iterator.hasNext()) {
                Integer next = iterator.next();
                output.append(" " + next);

                // fake processing time
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println(output);
        }
    }
}
