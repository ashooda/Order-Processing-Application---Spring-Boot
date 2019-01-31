package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Occasion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.awt.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;

public interface OccasionRepository extends CrudRepository<Occasion, Integer>, Repository<Occasion, Integer>
{
    @Query("select o from Occasion o")
    Set<Occasion> findEverything();

    @Query(value= "select occasion.occasion_type from occasion", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select occasion.occasion_id from occasion where occasion.occasion_type=?1" , nativeQuery = true)
    int findByOccaType(String occasionType);




}
