package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.FlavorStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;

public interface FlavorStatusRepository extends CrudRepository<FlavorStatus, Integer>, Repository<FlavorStatus, Integer>
{
    @Query(value= "select flavor_status.flavor_status from flavor_status", nativeQuery = true)
    ArrayList<String> findEverything();

    @Query(value= "select flavor_status.flavor_status_id from flavor_status where flavor_status.flavor_status=?1" , nativeQuery = true)
    int findByStatus(String status);
}
