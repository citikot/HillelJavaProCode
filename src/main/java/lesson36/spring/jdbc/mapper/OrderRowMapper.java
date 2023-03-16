package lesson36.spring.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import lesson36.spring.jdbc.data.Order;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderRowMapper implements RowMapper<Order> {

    public Order mapRow(ResultSet rs, int i) throws SQLException {
        return new Order(rs.getInt("orderNumber"), rs.getTimestamp("orderDate")
                .toLocalDateTime());
    }

}
