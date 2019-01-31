package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OccasionByYear;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OccasionByYearRepo extends CrudRepository<OccasionByYear, Integer> {
    @Query(value = "Select * from  OccasionByYear where DATEPART(YEAR, [Order Completed Date])=?1  ", nativeQuery = true)
    Set<OccasionByYear> occasionByYearReport(int year);
}

