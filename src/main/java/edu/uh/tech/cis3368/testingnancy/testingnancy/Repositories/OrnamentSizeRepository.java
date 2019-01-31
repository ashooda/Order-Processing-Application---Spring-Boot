package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrnamentSize;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface OrnamentSizeRepository extends CrudRepository<OrnamentSize, Integer>, Repository<OrnamentSize, Integer>
{
    @Query("select o from OrnamentSize o")
    Set<OrnamentSize> findEverything();
}
