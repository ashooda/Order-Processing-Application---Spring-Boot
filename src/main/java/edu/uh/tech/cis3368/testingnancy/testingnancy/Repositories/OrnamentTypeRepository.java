package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrnamentType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface OrnamentTypeRepository extends CrudRepository<OrnamentType, Integer>, Repository<OrnamentType,Integer>
{
    @Query("select o from OrnamentType o")
    Set<OrnamentType> findEverything();
}
