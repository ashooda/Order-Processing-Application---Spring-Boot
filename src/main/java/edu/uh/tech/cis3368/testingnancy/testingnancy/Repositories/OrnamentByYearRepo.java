package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrnamentsByYear;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OrnamentByYearRepo extends CrudRepository<OrnamentsByYear, Integer> {
    @Query(value = "Select * from OrnamentsByYear ", nativeQuery = true)
    Set<OrnamentsByYear> ornamentByYearReport();
}
