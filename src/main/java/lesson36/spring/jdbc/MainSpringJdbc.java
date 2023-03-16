package lesson36.spring.jdbc;

import java.math.BigDecimal;
import lesson36.spring.jdbc.config.AppConfig;
import lesson36.spring.jdbc.dao.CustomerDao;
import lesson36.spring.jdbc.data.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpringJdbc {
    private static final Logger LOG = LogManager.getLogger(MainSpringJdbc.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerDao customerDao = context.getBean(CustomerDao.class);

        LOG.debug("All customers with orders:");
        customerDao.getAllCustomers()
                .forEach(LOG::debug);

        LOG.debug("Customers by id  = 103:");
        LOG.debug(customerDao.findCustomerById(103));

        Customer customer = new Customer(777, "Pasko Inc", "Pasko", "Serhii", "123456", "Address line1",
                "Address line2", "Kyiv", null, null, "Ukraine", BigDecimal.valueOf(333));

        LOG.debug(customer + "was inserted - " + customerDao.insertCustomer(customer));
        customer.setCustomerName("Temporal name");
        LOG.debug(customer + "was updated - " + customerDao.updateCustomer(customer));
        LOG.debug(customer + "was deleted - " + customerDao.deleteCustomer(customer.getCustomerNumber()));

        context.close();
    }
}
