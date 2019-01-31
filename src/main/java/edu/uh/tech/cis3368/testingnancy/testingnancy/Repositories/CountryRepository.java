package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface CountryRepository extends CrudRepository<Country, Integer>, Repository<Country, Integer>
{
    @Query("select c from Country c where c.countryId = ?1")
    Country findByIdentity(int num);

    @Query("select c from Country c")
    Set<Country> findEverything();

    @Query(value= "select country.country_name from country", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select country.country_id from country where country.country_name=?1" , nativeQuery = true)
    int findByCountryName(String countryName);



}
