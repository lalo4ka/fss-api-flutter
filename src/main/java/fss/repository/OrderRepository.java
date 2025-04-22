package fss.repository;

import fss.dto.res.OrderResponse;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;
import java.util.Optional;

/**
 *
 * @author ehernandez
 */
@Repository
public interface OrderRepository {

    @Query("""
           select o.id, c.id, c.name 
           FROM Order o JOIN  o.customer c 
           where o.id=:id 
           """)
    Optional<OrderResponse> findOrderSummaryById(Integer id);



}
