package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.CustomerType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface CustomerTypeRepository extends CrudRepository<CustomerType, Integer>, Repository<CustomerType, Integer>
{
    @Query("select c from CustomerType c where c.customerTypeId = ?1")
    CustomerType findByIdentity(int num);

    @Query("select c from CustomerType c")
    Set<CustomerType> findEverything();

    @Query(value= "select customer_type.customer_type from customer_type", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select customer_type.customer_type_id from customer_type where customer_type.customer_type=?1" , nativeQuery = true)
    int findByCustomerTyp(String customerType);


}
