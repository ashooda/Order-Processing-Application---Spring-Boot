package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>, Repository<Employee, Integer>
{
    @Query("select e from Employee e")
    Set<Employee> findEverything();

}
