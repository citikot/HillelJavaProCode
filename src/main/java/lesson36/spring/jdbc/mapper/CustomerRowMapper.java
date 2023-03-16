package lesson36.spring.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import lesson36.spring.jdbc.data.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerRowMapper implements RowMapper<Customer> {

    public Customer mapRow(ResultSet rs, int i) throws SQLException {

        Customer customer = new Customer(rs.getInt("customerNumber"), rs.getString("customerName"),
                rs.getString("contactLastName"), rs.getString("contactFirstName"), rs.getString("phone"),
                rs.getString("addressLine1"), rs.getString("addressLine2"), rs.getString("city"), rs.getString("state"),
                rs.getString("postalCode"), rs.getString("country"), rs.getBigDecimal("creditLimit"));
        return customer;
    }

}
