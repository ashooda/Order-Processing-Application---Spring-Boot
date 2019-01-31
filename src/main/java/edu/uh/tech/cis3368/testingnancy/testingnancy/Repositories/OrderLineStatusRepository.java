package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrderLineStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface OrderLineStatusRepository extends CrudRepository<OrderLineStatus, Integer>, Repository<OrderLineStatus, Integer>
{
    @Query("select o from OrderLineStatus o")
    Set<OrderLineStatus> findEverything();

    @Query(value= "select order_line_status.order_line_status from order_line_status", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select order_line_status.order_line_status_id from order_line_status where order_line_status.order_line_status=?1" , nativeQuery = true)
    int findByOrdlineStat(String ordlineStat);
}
