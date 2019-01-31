package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shape_status", schema = "dbo", catalog = "Complete_DB_V_3")
public class ShapeStatus {
    private int shapeStatusId;
    private String shapeStatus;
    private Set<Shape> shapes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shapeStatus")
    public Set<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(Set<Shape> shapes) {
        this.shapes = shapes;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shape_status_id")
    public int getShapeStatusId() {
        return shapeStatusId;
    }

    public void setShapeStatusId(int shapeStatusId) {
        this.shapeStatusId = shapeStatusId;
    }

    @Basic
    @Column(name = "shape_status")
    public String getShapeStatus() {
        return shapeStatus;
    }

    public void setShapeStatus(String shapeStatus) {
        this.shapeStatus = shapeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeStatus that = (ShapeStatus) o;
        return shapeStatusId == that.shapeStatusId &&
                Objects.equals(shapeStatus, that.shapeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapeStatusId, shapeStatus);
    }


}
