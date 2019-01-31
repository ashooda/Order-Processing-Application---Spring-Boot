package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.SizeStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface SizeStatusRepository extends CrudRepository<SizeStatus, Integer>, Repository<SizeStatus,Integer>
{
    @Query("select s from SizeStatus s")
    Set<SizeStatus> findEverything();
}
