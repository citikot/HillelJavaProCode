package lesson30.jdbc;

import java.sql.SQLException;
import java.util.Set;

/**
 * @author spasko
 */
public interface CustomerDao {

    Set<Customer> getAllCustomers() throws SQLException;

    Customer findCustomerById(int id) throws SQLException;

    boolean insertCustomer(Customer customer) throws SQLException;

    boolean updateCustomer(Customer customer) throws SQLException;

    boolean deleteCustomer(int id) throws SQLException;
}
