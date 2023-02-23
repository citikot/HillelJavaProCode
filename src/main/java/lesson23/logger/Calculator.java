package lesson23.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author spasko
 */
public class Calculator {

    private static final Logger log = LoggerFactory.getLogger(Calculator.class);
    private static final Logger logMail = LoggerFactory.getLogger("error-logger");

    public int div(int a, int b) {
        int result = -666;
        log.debug("input values a={}, b={}", a, b);
        try {
            result = a / b;
        } catch (Exception e) {
            logMail.error("Exception when div working {}", e.getMessage(), e);
        }
        log.info("Method div return {}", result);
        return result;
    }

}
