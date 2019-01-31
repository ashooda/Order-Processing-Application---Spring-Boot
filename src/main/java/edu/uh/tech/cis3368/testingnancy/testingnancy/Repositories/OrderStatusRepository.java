package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrderStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface OrderStatusRepository extends CrudRepository<OrderStatus,Integer>, Repository<OrderStatus,Integer>
{
    @Query("select o from OrderStatus o")
    Set<OrderStatus> findEverything();

    @Query(value= "select order_status.order_status from order_status", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select order_status.order_status_id from order_status where dbo.order_status.order_status=?1" , nativeQuery = true)
    int findByOrderStatMthd(String ordstat);
}
