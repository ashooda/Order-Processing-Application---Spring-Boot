package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Shape {
    private int shapeId;
    private int shapeStatusId;
    private String shapeType;
    ShapeStatus shapeStatus;
    private Set<ProductLayer> productLayers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shape", cascade = CascadeType.ALL)
    public Set<ProductLayer> getProductLayers() {
        return productLayers;
    }

    public void setProductLayers(Set<ProductLayer> productLayers) {
        //productLayers.forEach(productLayer -> productLayer.setShape(this));
        this.productLayers = productLayers;
    }



    @ManyToOne
    @JoinColumn(name = "shape_status_id", nullable = false, insertable = false, updatable = false)
    public ShapeStatus getShapeStatus() {
        return shapeStatus;
    }

    public void setShapeStatus(ShapeStatus shapeStatus) {
        this.shapeStatus = shapeStatus;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shape_id")
    public int getShapeId() {
        return shapeId;
    }

    public void setShapeId(int shapeId) {
        this.shapeId = shapeId;
    }

    @Basic
    @Column(name = "shape_status_id")
    public int getShapeStatusId() {
        return shapeStatusId;
    }

    public void setShapeStatusId(int shapeStatusId) {
        this.shapeStatusId = shapeStatusId;
    }


    @Basic
    @Column(name = "shape_type")
    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return shapeId == shape.shapeId &&
                shapeStatusId == shape.shapeStatusId &&
                Objects.equals(shapeType, shape.shapeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapeId, shapeStatusId, shapeType);
    }




}
