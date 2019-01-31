package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Flavor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface FlavorRepository extends CrudRepository<Flavor,Integer>, Repository<Flavor, Integer>
{
    @Query("select f from Flavor f")
    Set<Flavor> findEverything();

    @Query(value= "select flavor.flavor_type from flavor", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select flavor.flavor_id from flavor where flavor.flavor_type=?1" , nativeQuery = true)
    int findByFlavType(String flavType);

    @Query("select f from Flavor f where f.flavorId = ?1")
    Flavor findByIdentity(int num);

}
