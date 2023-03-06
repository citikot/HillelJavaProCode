package lesson30.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

/**
 * @author spasko
 */
public class ConnectToDbPool {

    public static final String URL = "jdbc:mysql://localhost:3307/classicmodels";
    public static final String USER = "root";
    public static final String PASS = "123456";

    private ConnectToDbPool() {
    }

    /**
     * Get a connection to database
     * 
     * @return Connection object
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            ComboPooledDataSource dataSource = getDataSource();
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static ComboPooledDataSource getDataSource() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(URL);
        cpds.setUser(USER);
        cpds.setPassword(PASS);

        // Optional Settings
        cpds.setInitialPoolSize(5);
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(100);
        return cpds;
    }
}
