package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.AvgPriceOccasion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AvgPriceOccasionRepository extends CrudRepository<AvgPriceOccasion, Integer> {
    @Query(value = "Select * from   AvgPriceOccasion ", nativeQuery = true)
    Set<AvgPriceOccasion> avgPriceOccasionReport();
}
