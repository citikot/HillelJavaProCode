package lesson30.jdbc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(OrderAnnotation.class)
class CustomerDaoImplIntegrationTest {
    private static final int NOT_EXIST_CUSTOMER = -1;
    private static final int ALREADY_EXIST_CUSTOMER = 103;
    private static final Customer CUSTOMER = new Customer(777, "Pasko Inc", "Pasko", "Serhii", "123456",
            "Address line1", "Address line2", "Kyiv", null, null, "Ukraine", BigDecimal.valueOf(333));
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Test
    void testGetAllCustomers() throws SQLException {
        Set<Customer> customers = customerDao.getAllCustomers();
        customers.forEach(System.out::println);
        assertTrue(customers.size() > 15);
    }

    @Test
    void testFindCustomerByIdNotPresent() throws SQLException {
        Customer customer = customerDao.findCustomerById(NOT_EXIST_CUSTOMER);
        System.out.println(customer);
        assertNull(customer);
    }

    @Test
    void testFindCustomerById() throws SQLException {
        Customer customer = customerDao.findCustomerById(ALREADY_EXIST_CUSTOMER);
        System.out.println(customer);
        assertNotNull(customer);
    }

    @Test
    @Order(1)
    void testInsertCustomer() throws SQLException {
        assertTrue(customerDao.insertCustomer(CUSTOMER));
    }

    @Test
    @Order(2)
    void testUpdateCustomer() throws SQLException {
        CUSTOMER.setCustomerName("Changed name");
        assertTrue(customerDao.updateCustomer(CUSTOMER));
    }

    @Test
    @Order(3)
    void testDeleteCustomer() throws SQLException {
        assertTrue(customerDao.deleteCustomer(CUSTOMER.getCustomerNumber()));
    }

}
