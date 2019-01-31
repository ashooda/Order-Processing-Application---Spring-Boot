package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.ProductType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface ProductTypeRepository extends CrudRepository<ProductType, Integer>, Repository<ProductType, Integer>
{
    @Query("select p from ProductType p")
    Set<ProductType> findEverything();

    @Query(value= "select product_type.product_type from product_type", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select product_type.product_type_id from product_type where product_type.product_type=?1" , nativeQuery = true)
    int findByProdType(String flavType);

}
