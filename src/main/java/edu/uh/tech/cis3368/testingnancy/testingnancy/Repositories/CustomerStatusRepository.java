package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.CustomerStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface CustomerStatusRepository extends CrudRepository<CustomerStatus, Integer>, Repository<CustomerStatus, Integer>
{
    @Query("select c from CustomerStatus c  where c.customerStatusId = ?1")
    CustomerStatus findByIdentity(int num);

    @Query("select c from CustomerStatus c")
    Set<CustomerStatus> findEverything();

    @Query(value= "select customer_status.customer_status from customer_status", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select customer_status.customer_status_id from customer_status where customer_status.customer_status=?1" , nativeQuery = true)
    int findByCustomerStat(String customerStat);

}
