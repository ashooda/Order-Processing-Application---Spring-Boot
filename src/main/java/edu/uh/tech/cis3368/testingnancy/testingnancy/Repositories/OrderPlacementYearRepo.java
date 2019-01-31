package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrderPlacementByYear;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OrderPlacementYearRepo extends CrudRepository<OrderPlacementByYear, Integer> {
    @Query(value = "Select * from OrderPlacementByYear where DATEPART(YEAR, order_received_date)=?1", nativeQuery = true)
    Set<OrderPlacementByYear> opmByYearReport(int year);
}
