package lesson34;

import java.util.Set;
import lesson34.entity.Customer;

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
