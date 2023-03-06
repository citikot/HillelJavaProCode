package lesson30.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

/**
 * @author spasko
 */
public class CustomerDaoTemplateImpl implements CustomerDao {

    @Override
    public Set<Customer> getAllCustomers() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Customer findCustomerById(int id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {
        CrudTemplate<Customer> ct = (ord, connection) -> {
            PreparedStatement statement;
            String sql = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country)  VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, customer.getCustomerNumber());
            statement.setString(2, customer.getCustomerName());
            statement.setString(3, customer.getContactLastName());
            statement.setString(4, customer.getContactFirstName());
            statement.setString(5, customer.getPhone());
            statement.setString(6, customer.getAddressLine1());
            statement.setString(7, customer.getCity());
            statement.setString(8, customer.getCountry());
            return statement;
        };
        return ct.templateOperation(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        CrudTemplate<Customer> ct = (ord, connection) -> {
            PreparedStatement statement;
            //For shortest updating only customerName
            String sql = "UPDATE customers SET customerName=? WHERE customerNumber=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getCustomerName());
            statement.setInt(2, customer.getCustomerNumber());

            return statement;
        };
        return ct.templateOperation(customer);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        CrudTemplate<Integer> ct = (ord, connection) -> {
            PreparedStatement statement;
            String sql = "DELETE FROM customers WHERE customerNumber=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            return statement;
        };
        return ct.templateOperation(id);
    }

    private interface CrudTemplate<T> {
        public default boolean templateOperation(T t) throws SQLException {
            boolean result = false;
            Connection connection = null;
            PreparedStatement statement = null;
            try {
                connection = ConnectToDb.getConnection();

                statement = returnPrepareStatement(t, connection);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    result = true;
                }
            } finally {
                statement.close();
                connection.close();
            }
            return result;
        }

        public PreparedStatement returnPrepareStatement(T order, Connection connection) throws SQLException;

    }
}
