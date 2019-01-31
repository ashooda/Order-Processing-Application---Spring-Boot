package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.ProductbyMonth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProductTypeFrequencyRepo extends CrudRepository<ProductbyMonth, Integer> {
    @Query(value = "Select * from ProductbyMonth ", nativeQuery = true)
    Set<ProductbyMonth> productByMonthReport();

}
