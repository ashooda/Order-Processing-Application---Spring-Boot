package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.EmployeeStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface EmployeeStatusRepository extends CrudRepository<EmployeeStatus,Integer>, Repository<EmployeeStatus, Integer>
{
    @Query("select e from EmployeeStatus e")
    Set<EmployeeStatus> findEverything();
}
