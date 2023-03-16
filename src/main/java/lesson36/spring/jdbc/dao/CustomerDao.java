package lesson36.spring.jdbc.dao;

import java.util.Set;
import lesson36.spring.jdbc.data.Customer;

/**
 * @author spasko
 */
public interface CustomerDao {

    Set<Customer> getAllCustomers();

    Customer findCustomerById(int id);

    boolean insertCustomer(Customer customer);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(int id);
}
