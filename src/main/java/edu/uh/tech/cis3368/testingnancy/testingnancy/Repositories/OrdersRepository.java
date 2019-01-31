package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface OrdersRepository extends CrudRepository<Orders,Integer>, Repository<Orders,Integer>
{
    @Query("select o from Orders o")
    Set<Orders> findEverything();


}
