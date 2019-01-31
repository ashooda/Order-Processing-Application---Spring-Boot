package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.StateProvince;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface StateProvinceRepository extends CrudRepository<StateProvince, Integer>, Repository<StateProvince, Integer>
{


    @Query("select s from StateProvince s where s.stateProvinceId = ?1")
    StateProvince findByIdentity(int num);

    @Query("select s from StateProvince s")
    Set<StateProvince> findEverything();

    @Query(value= "select state_province.state_name from state_province", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select state_province.state_province_id from state_province where state_province.state_name=?1" , nativeQuery = true)
    int findByStateProve(String stateName);
}


