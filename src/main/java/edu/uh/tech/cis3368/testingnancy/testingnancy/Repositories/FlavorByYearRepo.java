package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.FlavorByYear;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface FlavorByYearRepo extends CrudRepository<FlavorByYear, Integer> {
    @Query(value = "Select * from  FlavorByYear where DATEPART(YEAR, order_completed_date)=?1  ", nativeQuery = true)
    Set<FlavorByYear> flavByYearReport(int year);
}
