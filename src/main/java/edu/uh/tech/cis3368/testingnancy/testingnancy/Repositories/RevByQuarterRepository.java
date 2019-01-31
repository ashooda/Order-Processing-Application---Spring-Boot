package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.RevByQuarter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RevByQuarterRepository extends CrudRepository<RevByQuarter, Integer> {
    @Query(value = "Select * from RevByQuarter where DATEPART(QUARTER , order_completed_date)=?1 and DATEPART(YEAR , order_completed_date)=?2 order by occasion_type", nativeQuery = true)
    Set<RevByQuarter> revByQuarterReport(int quarter, int year);
}

