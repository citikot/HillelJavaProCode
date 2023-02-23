package lesson23.logger;

import java.util.UUID;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author spasko
 */

public class MainLogger {
    private static final Logger log = LoggerFactory.getLogger(MainLogger.class);

    public static void main(String[] args) {
        new Thread(new CalculatorRunner()).start();
        //new Thread(new CalculatorRunner()).start();
    }

    static class CalculatorRunner implements Runnable {

        @Override
        public void run() {
            ThreadContext.put("uuid", UUID.randomUUID()
                    .toString());

            log.info("Start of method run");
            Calculator calculator = new Calculator();
            calculator.div(5, 2);

            sleepOneSecond();

            calculator.div(3, 0);
            log.info("End of method run");
        }

        private void sleepOneSecond() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
