package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Assignment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface AssisgnmentRepository extends CrudRepository<Assignment, Integer>, Repository<Assignment, Integer>
{
    @Query("select a from Assignment a")
    Set<Assignment> findEverything();
}
