package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.FrostingStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;

public interface FrostingStatusRepository extends CrudRepository<FrostingStatus, Integer>, Repository<FrostingStatus,Integer>
{
    @Query(value= "select frosting_status.frosting_status from frosting_status", nativeQuery = true)
    ArrayList<String> findEverything();

    @Query(value= "select frosting_status.frosting_status_id from frosting_status where frosting_status.frosting_status=?1" , nativeQuery = true)
    int findByStatus(String status);

}
