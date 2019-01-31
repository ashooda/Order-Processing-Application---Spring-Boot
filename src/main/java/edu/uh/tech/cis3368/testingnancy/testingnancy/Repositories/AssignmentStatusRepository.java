package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.AssignmentStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface AssignmentStatusRepository extends CrudRepository<AssignmentStatus, Integer>, Repository<AssignmentStatus, Integer>
{
    @Query("select a from AssignmentStatus a")
    Set<AssignmentStatus> findEverything();
}
