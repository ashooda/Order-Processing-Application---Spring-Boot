package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Filling;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface FillingRepository extends CrudRepository<Filling, Integer>, Repository<Filling, Integer>
{
    @Query("select f from Filling f")
    Set<Filling> findEverything();

    @Query("select f from Filling f where f.fillingId = ?1")
    Filling findByIdentity(int num);

    @Query(value= "select filling.filling_type from filling", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select filling.filling_id from filling where filling.filling_type=?1" , nativeQuery = true)
    int findByFillingType(String fillType);

}
