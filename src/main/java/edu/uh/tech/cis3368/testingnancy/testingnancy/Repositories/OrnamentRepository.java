package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Ornament;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface OrnamentRepository extends CrudRepository<Ornament, Integer>, Repository<Ornament, Integer>
{
    @Query("select o from Ornament o")
    Set<Ornament> findEverything();
}
