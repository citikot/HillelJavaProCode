package lesson34.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import lesson34.CustomerDao;
import lesson34.entity.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author spasko
 */
public class CustomerDaoImpl implements CustomerDao {
    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private static final Logger LOG = LogManager.getLogger(CustomerDaoImpl.class);

    private EntityManager entityManager = factory.createEntityManager();

    @Override
    public Set<Customer> getAllCustomers() {
        Set<Customer> customer = new HashSet<>();
        try {
            entityManager.getTransaction()
                    .begin();
            customer = new HashSet<>(
                    entityManager.createQuery("FROM Customer c join fetch c.employee Employee", Customer.class)
                            .getResultList());
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer findCustomerById(int id) {
        Customer customer = null;
        try {
            entityManager.getTransaction()
                    .begin();
            customer = entityManager.find(Customer.class, id);
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        boolean result = false;
        try {
            entityManager.getTransaction()
                    .begin();
            entityManager.persist(customer);
            entityManager.getTransaction()
                    .commit();
            result = true;
            LOG.info("\nSuccessfully Created Records In The Database!\n");
        } catch (Exception sqlException) {
            LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
            entityManager.getTransaction()
                    .rollback();
            sqlException.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean result = false;
        try {
            entityManager.getTransaction()
                    .begin();
            entityManager.merge(customer);
            entityManager.getTransaction()
                    .commit();
            result = true;
            LOG.info("\nOrder With Id={} Is Successfully Updated In The Database!\n", customer.getCustomerNumber());
        } catch (Exception sqlException) {
            LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
            entityManager.getTransaction()
                    .rollback();
            sqlException.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean result = false;
        try {
            entityManager.getTransaction()
                    .begin();
            entityManager.remove(entityManager.find(Customer.class, id));

            // Committing The Transactions To The Database
            entityManager.getTransaction()
                    .commit();
            result = true;
            LOG.info("\nOrder With Id={} Is Successfully deleted from The Database!\n", id);
        } catch (Exception sqlException) {
            LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
            entityManager.getTransaction()
                    .rollback();

            sqlException.printStackTrace();
        }
        return result;
    }

}
