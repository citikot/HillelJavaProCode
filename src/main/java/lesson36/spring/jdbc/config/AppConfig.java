package lesson36.spring.jdbc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Locale;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("lesson36")
@PropertySource("classpath:lesson36/database.properties")
public class AppConfig {
    private static final Logger LOG = LogManager.getLogger(AppConfig.class);

    @Value("${driver}")
    private String propertyDriver;
    @Value("${url}")
    private String propertyUrl;
    @Value("${user}")
    private String propertyUsername;
    @Value("${password}")
    private String propertyPassword;
    @Value("${maxactive}")
    private String propertyMaxActive;
    @Value("${initialsize}")
    private String propertyInitialSize;

    @Bean
    public DataSource dataSource() {
        Locale.setDefault(Locale.ENGLISH);
        ComboPooledDataSource cpds = new ComboPooledDataSource();

        try {
            cpds.setDriverClass(propertyDriver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        cpds.setJdbcUrl(propertyUrl);
        cpds.setUser(propertyUsername);
        cpds.setPassword(propertyPassword);

        // Optional Settings
        cpds.setInitialPoolSize(Integer.parseInt(propertyInitialSize));
        cpds.setMaxPoolSize(Integer.parseInt(propertyMaxActive));

        LOG.debug("Establish connection to DB={}", propertyUrl);
        return cpds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
