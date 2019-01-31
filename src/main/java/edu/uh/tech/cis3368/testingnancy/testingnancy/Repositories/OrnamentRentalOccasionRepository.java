package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrnamentRentalOccasion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OrnamentRentalOccasionRepository extends CrudRepository<OrnamentRentalOccasion, Integer> {
    @Query(value = "Select * from OrnamentRentalOccasion ", nativeQuery = true)
    Set<OrnamentRentalOccasion> ornamentRentalOccasionReport();
}
