package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.ProductSizeMonth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProductSizeMonthRepo extends CrudRepository<ProductSizeMonth, Integer> {
    @Query(value = "Select * from ProductSizeMonth where DATEPART(MONTH , order_completed_date)=?1 and DATEPART(YEAR , order_completed_date)=?2 ", nativeQuery = true)
    Set<ProductSizeMonth> productSizeByMonthReport(int month, int year);
}

