package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.AssignmentLine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface AssignmentLineRepository extends CrudRepository<AssignmentLine, Integer>, Repository<AssignmentLine,Integer>
{
    @Query("select a from AssignmentLine a")
    Set<AssignmentLine> findEverything();
}
