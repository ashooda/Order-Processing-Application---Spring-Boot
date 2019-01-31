package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrnamentColor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface OrnamentColorRepository extends CrudRepository<OrnamentColor, Integer>, Repository<OrnamentColor, Integer>
{
    @Query("select o from OrnamentColor o")
    Set<OrnamentColor> findEverything();
}
