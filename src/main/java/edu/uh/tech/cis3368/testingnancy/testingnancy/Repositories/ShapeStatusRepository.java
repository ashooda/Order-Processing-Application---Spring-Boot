package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.ShapeStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface ShapeStatusRepository extends CrudRepository<ShapeStatus, Integer>, Repository<ShapeStatus, Integer>
{
    @Query("select s from ShapeStatus s")
    Set<ShapeStatus> findEverything();
}
