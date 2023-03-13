package lesson34.hibernate;

import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import lesson34.CustomerDao;
import lesson34.entity.Customer;
import lesson34.entity.Employee;
import lesson34.entity.Office;
import lesson34.entity.Order;
import lesson34.entity.Payment;
import lesson34.entity.Product;
import lesson34.entity.Productline;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author spasko
 */
public class CustomerDaoImpl implements CustomerDao {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private Session sessionObj;

    private static final Logger LOG = LogManager.getLogger(CustomerDaoImpl.class);

    // This Method Is Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {            
        Locale.setDefault(Locale.ENGLISH);

        // Creating Configuration Instance & Passing Hibernate Configuration File
        // Distributed configuration it's a way into HELL!!! Only for lesson's purposes
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(Customer.class);
        configObj.addAnnotatedClass(Employee.class);
        configObj.addAnnotatedClass(Office.class);
        configObj.addAnnotatedClass(Order.class);
        configObj.addAnnotatedClass(Payment.class);
        configObj.addAnnotatedClass(Productline.class);
        configObj.addAnnotatedClass(Product.class);

        configObj.configure(new File("src\\main\\resources\\lesson34\\hibernate\\hibernate.cfg.xml"));

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                .applySettings(configObj.getProperties())
                .build();

        // Creating Hibernate SessionFactory Instance
        return configObj.buildSessionFactory(serviceRegistryObj);
    }

    @Override
    public Set<Customer> getAllCustomers() {
        Set<Customer> customer = new HashSet<>();
        try {
            // Getting Session Object From SessionFactory
            sessionObj = sessionFactory.openSession();
            customer = new HashSet<>(sessionObj.createQuery("FROM Customer c join fetch c.employee Employee", Customer.class)
                    .list());
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return customer;
    }

    @Override
    public Customer findCustomerById(int id) {
        Customer customer = null;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = sessionFactory.openSession();

            customer = sessionObj.get(Customer.class, id);
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return customer;
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        boolean result = false;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = sessionFactory.openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            sessionObj.persist(customer);

            // Committing The Transactions To The Database
            sessionObj.getTransaction()
                    .commit();
            result = true;
            LOG.info("\nSuccessfully Created Records In The Database!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction()
                        .rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean result = false;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = sessionFactory.openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
            sessionObj.merge(customer);
            // Committing The Transactions To The Database
            sessionObj.getTransaction()
                    .commit();
            result = true;
            LOG.info("\nOrder With Id={} Is Successfully Updated In The Database!\n", customer.getCustomerNumber());
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction()
                        .rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean result = false;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = sessionFactory.openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            sessionObj.remove(sessionObj.get(Customer.class, id));

            // Committing The Transactions To The Database
            sessionObj.getTransaction()
                    .commit();
            result = true;
            LOG.info("\nOrder With Id={} Is Successfully deleted from The Database!\n", id);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction()
                        .rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

}
