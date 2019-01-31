package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.FillingByQuarter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface FillingByQuarterRepository extends CrudRepository<FillingByQuarter, Integer> {
    @Query(value = "Select * from  FillingByQuarter where DATEPART(QUARTER, order_completed_date)=?1 and DATEPART(YEAR, order_completed_date)=?2 ", nativeQuery = true)
    Set<FillingByQuarter> fillByQuartReport(int quarter, int year);
}

