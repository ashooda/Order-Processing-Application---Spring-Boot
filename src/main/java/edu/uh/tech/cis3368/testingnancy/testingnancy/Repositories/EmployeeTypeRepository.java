package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.EmployeeType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface EmployeeTypeRepository extends CrudRepository<EmployeeType, Integer>, Repository<EmployeeType,Integer>
{
    @Query("select e from EmployeeType e")
    Set<EmployeeType> findEverything();
}
