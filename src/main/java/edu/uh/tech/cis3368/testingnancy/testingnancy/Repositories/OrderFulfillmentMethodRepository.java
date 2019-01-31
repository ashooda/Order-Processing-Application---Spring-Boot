package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrderFulfillmentMethod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface OrderFulfillmentMethodRepository extends CrudRepository<OrderFulfillmentMethod, Integer>, Repository<OrderFulfillmentMethod, Integer>
{
    @Query("select o from OrderFulfillmentMethod o")
    Set<OrderFulfillmentMethod> findEverything();

    @Query(value= "select order_fulfillment_method.order_fulfillement_method from order_fulfillment_method", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select order_fulfillment_method.order_fulfillment_method_id from order_fulfillment_method where order_fulfillment_method.order_fulfillement_method=?1" , nativeQuery = true)
    int findByOrderFulMthd(String ofm);
}
