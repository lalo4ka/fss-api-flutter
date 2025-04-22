package fss.service;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import fss.repository.CustomerRepository;
import fss.domain.model.Customer;
import fss.dto.res.CustomerOrderSummaryView;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Optional;

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

    public Optional<CustomerOrderSummaryView> findOrdersByCustomer(Integer id) {

        LocalDate fromDate = LocalDate.of(2025, 04, 01);

        CriteriaBuilder<Customer> cb = cbf.create(em, Customer.class)
                .from(Customer.class)
                .where("orders.date").ge(fromDate) //greaterThan
                .where("id").eq(id); //equal
        CriteriaBuilder<CustomerOrderSummaryView> customerView = evm.applySetting(EntityViewSetting.create(CustomerOrderSummaryView.class), cb);

        return Optional.of(customerView.getSingleResult());

    }

}
