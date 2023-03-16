package lesson36.spring.jdbc.dao;

import java.util.List;
import java.util.Set;
import lesson36.spring.jdbc.data.Customer;
import lesson36.spring.jdbc.data.Order;
import lesson36.spring.jdbc.mapper.CustomerRowMapper;
import lesson36.spring.jdbc.mapper.OrderRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author spasko
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;
    private final OrderRowMapper orderRowMapper;

    public CustomerDaoImpl(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper,
            OrderRowMapper orderRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
        this.orderRowMapper = orderRowMapper;
    }

    @Override
    public Set<Customer> getAllCustomers() {
        List<Customer> customers = jdbcTemplate.query("SELECT * FROM  customers", customerRowMapper);
        for (Customer customer : customers) {
            List<Order> orders = jdbcTemplate.query("SELECT * FROM  orders WHERE customerNumber = ? ", orderRowMapper,
                    customer.getCustomerNumber());
            customer.setOrders(Set.copyOf(orders));
        }

        return Set.copyOf(customers);
    }

    @Override
    public Customer findCustomerById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM  customers WHERE customerNumber=?", customerRowMapper, id);
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        return jdbcTemplate.update(
                "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country)  VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                customer.getCustomerNumber(), customer.getCustomerName(), customer.getContactLastName(),
                customer.getContactFirstName(), customer.getPhone(), customer.getAddressLine1(), customer.getCity(),
                customer.getCountry()) > 0;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return jdbcTemplate.update("UPDATE customers SET customerName=? WHERE customerNumber=?",
                customer.getCustomerName(), customer.getCustomerNumber()) > 0;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return jdbcTemplate.update("DELETE FROM customers WHERE customerNumber=?", id) > 0;
    }

}
