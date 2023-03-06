package lesson30.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author spasko
 */
public class CustomerDaoImpl implements CustomerDao {

    //Only for example!!! It's a bad way to use connections multiple times and others
    @Override
    public Set<Customer> getAllCustomers() throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ResultSet rsOrder = null;

        Set<Customer> orders = new HashSet<>();

        try {
            connection = ConnectToDb.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM  customers");
            rs = stmt.executeQuery();

            showMetadata(rs);

            while (rs.next()) {
                Customer customer = new Customer(rs.getInt("customerNumber"), rs.getString("customerName"),
                        rs.getString("contactLastName"), rs.getString("contactFirstName"), rs.getString("phone"),
                        rs.getString("addressLine1"), rs.getString("addressLine2"), rs.getString("city"),
                        rs.getString("state"), rs.getString("postalCode"), rs.getString("country"),
                        rs.getBigDecimal("creditLimit"));

                stmt = connection.prepareStatement("SELECT * FROM  orders WHERE customerNumber=?");
                stmt.setInt(1, rs.getInt("customerNumber"));

                rsOrder = stmt.executeQuery();
                while (rsOrder.next()) {
                    Order order = new Order(rsOrder.getInt("orderNumber"), rsOrder.getTimestamp("orderDate")
                            .toLocalDateTime());
                    customer.getOrders()
                            .add(order);
                }
                orders.add(customer);
            }
        } finally {
            rsOrder.close();
            rs.close();
            stmt.close();
            connection.close();
        }
        return orders;
    }

    private void showMetadata(ResultSet rs) throws SQLException {
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; ++i) {
            System.out.println("***************");
            System.out.println("Column Name : " + resultSetMetaData.getColumnLabel(i));
            System.out.println("Column Type : " + resultSetMetaData.getColumnType(i));
            System.out.println("Column Class Name : " + resultSetMetaData.getColumnClassName(i));
            System.out.println("Column Type Name :" + resultSetMetaData.getColumnTypeName(i));
        }
    }

    @Override
    public Customer findCustomerById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectToDb.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM  customers WHERE customerNumber=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return new Customer(rs.getInt("customerNumber"), rs.getString("customerName"),
                        rs.getString("contactLastName"), rs.getString("contactFirstName"), rs.getString("phone"),
                        rs.getString("addressLine1"), rs.getString("addressLine2"), rs.getString("city"),
                        rs.getString("state"), rs.getString("postalCode"), rs.getString("country"),
                        rs.getBigDecimal("creditLimit"));
            }
        } finally {
            rs.close();
            stmt.close();
            connection.close();
        }
        return null;
    }

    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDb.getConnection();

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

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {              
                return true;
            }
        } finally {
            statement.close();
            connection.close();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDb.getConnection();
            //For shortest updating only customerName
            String sql = "UPDATE customers SET customerName=? WHERE customerNumber=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getCustomerName());
            statement.setInt(2, customer.getCustomerNumber());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {              
                return true;
            }
        } finally {
            statement.close();
            connection.close();
        }

        return false;

    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDb.getConnection();
            String sql = "DELETE FROM customers WHERE customerNumber=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {               
                return true;
            }
        } finally {
            statement.close();
            connection.close();
        }
        return false;
    }

}
