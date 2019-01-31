package edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Shape;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Set;

public interface ShapeRepository extends CrudRepository<Shape, Integer>, Repository<Shape, Integer>
{
    @Query("select s from Shape s")
    Set<Shape> findEverything();

    @Query(value= "select shape.shape_type from shape", nativeQuery = true)
    ArrayList<String> findEverythingArray();

    @Query(value= "select shape.shape_id from shape where shape.shape_type=?1" , nativeQuery = true)
    int findByShapeType(String shapeType);
}
