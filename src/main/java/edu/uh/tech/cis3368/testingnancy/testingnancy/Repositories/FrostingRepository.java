package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Frosting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface FrostingRepository extends CrudRepository<Frosting, Integer>, Repository<Frosting, Integer>
{
    @Query("select f from Frosting f")
    Set<Frosting> findEverything();

    @Query("select f from Frosting f where f.frostingId = ?1")
    Frosting findByIdentity(int num);

    @Query(value= "select frosting.frosting_type from frosting", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select frosting.frosting_id from frosting where frosting.frosting_type=?1" , nativeQuery = true)
    int findByFrostingType(String frostType);

}
