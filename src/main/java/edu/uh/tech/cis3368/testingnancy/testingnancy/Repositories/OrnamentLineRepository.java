package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrnamentLine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface OrnamentLineRepository extends CrudRepository<OrnamentLine, Integer>, Repository<OrnamentLine, Integer>
{
    @Query("select o from OrnamentLine o")
    Set<OrnamentLine> findEverything();
}
