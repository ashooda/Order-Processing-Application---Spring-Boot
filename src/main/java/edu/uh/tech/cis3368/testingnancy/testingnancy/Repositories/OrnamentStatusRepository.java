package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrnamentStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface OrnamentStatusRepository extends CrudRepository<OrnamentStatus, Integer>, Repository<OrnamentStatus, Integer>
{
    @Query("select o from OrnamentStatus o")
    Set<OrnamentStatus> findEverything();
}
