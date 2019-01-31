package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Orderline;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface OrderlineRepository extends CrudRepository<Orderline, Integer>, Repository<Orderline, Integer>
{
    @Query("select o from Orderline o")
    Set<Orderline> findEverything();
}
