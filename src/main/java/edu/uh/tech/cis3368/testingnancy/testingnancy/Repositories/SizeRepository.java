package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Size;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface SizeRepository extends CrudRepository<Size, Integer>, Repository<Size, Integer>
{
    @Query("select s from Size s ")
    Set<Size> findEverything();

    @Query(value= "select size.size_dimension from size", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select size.size_id from size where size.size_dimension=?1" , nativeQuery = true)
    int findBySizeDimensions(String sizeDimen);
}
