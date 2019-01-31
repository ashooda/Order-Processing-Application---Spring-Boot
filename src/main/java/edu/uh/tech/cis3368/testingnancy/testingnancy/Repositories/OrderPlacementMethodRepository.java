package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrderPlacementMethod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface OrderPlacementMethodRepository extends CrudRepository<OrderPlacementMethod, Integer>, Repository<OrderPlacementMethod,Integer>
{
    @Query("select o from OrderPlacementMethod o")
    Set<OrderPlacementMethod> findEverything();

    @Query(value= "select order_placement_method.order_placement_method from order_placement_method", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select order_placement_method.order_placement_method_id from order_placement_method where order_placement_method.order_placement_method=?1" , nativeQuery = true)
    int findByOrderPlaceMthd(String opm);
}
