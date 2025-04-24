package fss.service;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import fss.repository.CustomerRepository;
import fss.domain.model.Customer;
import fss.dto.res.OrdersByCustomerRes;
import jakarta.data.Sort;
import jakarta.data.repository.Insert;
import jakarta.data.repository.Save;
import jakarta.data.repository.Update;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author ehernandez
 */
@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;
    @Inject
    EntityManager em;
    @Inject
    CriteriaBuilderFactory cbf;
    @Inject
    EntityViewManager evm;

    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.byId(id);
    }

    public Optional<Customer> getCustomerByName(String name) {
        return customerRepository.byName(name);
    }
    
    public List<Customer> getAllCustomers() {
        return customerRepository.all();
    }
    
    public List<Customer> getAllCustomersByRoutes(Set<String> rutas) {
        return customerRepository.allByRoute(rutas);
    }

    public Customer insert(Customer c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Customer update(Customer c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Customer upsert(Customer c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Optional<OrdersByCustomerRes> findOrdersByCustomer(Integer id) {

        LocalDate fromDate = LocalDate.of(2025, 04, 01);

        CriteriaBuilder<Customer> cb = cbf.create(em, Customer.class)
                .from(Customer.class)
                .where("orders.date").ge(fromDate) //greaterThan
                .where("id").eq(id); //equal

        CriteriaBuilder<OrdersByCustomerRes> customerView
                = evm.applySetting(EntityViewSetting.create(OrdersByCustomerRes.class), cb);

        return Optional.of(customerView.getSingleResult());

    }

}
