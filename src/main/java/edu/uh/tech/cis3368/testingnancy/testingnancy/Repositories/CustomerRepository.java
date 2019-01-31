package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Set;

public interface CustomerRepository extends CrudRepository<Customer, Integer>, Repository<Customer, Integer>
{
    @Query("select c from Customer c")
    Set<Customer> findEverything();

    @Query("select c from Customer c where c.customerId = ?1")
    Customer findByIdentity(int num);

    @Query("select c from Customer c where c.customerPhoneNumber = ?1")
    Customer findByPhone(String phoneNumber);


    @Query(value = "delete  from Customer where customer_id = ?1", nativeQuery = true)
    List<Customer> deleteCustBy(Integer id);
}
