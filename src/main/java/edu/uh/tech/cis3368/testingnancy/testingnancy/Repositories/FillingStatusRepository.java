package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.FillingStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;

public interface FillingStatusRepository extends CrudRepository<FillingStatus, Integer>, Repository<FillingStatus, Integer>
{
    @Query(value= "select filling_status.filling_status from filling_status", nativeQuery = true)
    ArrayList<String> findEverything();

    @Query(value= "select filling_status.filling_status_id from filling_status where filling_status.filling_status=?1" , nativeQuery = true)
    int findByStatus(String status);


}
