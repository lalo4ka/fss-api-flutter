package fss.service;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import fss.repository.CustomerRepository;
import fss.domain.model.Customer;
import fss.domain.model.Order;
import fss.dto.res.CustomerOrderSummaryView;
import fss.repository.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ehernandez
 */
@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;
    @Inject
    EntityManager em;
    @Inject
    CriteriaBuilderFactory cbf;
    @Inject
    EntityViewManager evm; 



}
