package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.ProductLayer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface ProductLayerRepository extends CrudRepository<ProductLayer, Integer>, Repository<ProductLayer, Integer>
{
    @Query("select o from ProductLayer o")
    Set<ProductLayer> findEverything();




}