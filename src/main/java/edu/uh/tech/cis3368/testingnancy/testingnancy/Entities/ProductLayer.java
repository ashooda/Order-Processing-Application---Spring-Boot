package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_layer", schema = "dbo", catalog = "Complete_DB_V_3")
public class ProductLayer {
    private int productLayerId;

    private int orderlineId;
    private int flavorId;
    private int fillingId;
    private int frostingId;
    private int sizeId;
    private int shapeId;

    private int layerNumber;
    Orderline orderline;
    Flavor flavor;
    Filling filling;
    Frosting frosting;
    Size size;
    Shape shape;

    @ManyToOne
    @JoinColumn(name = "shape_id", nullable = false, insertable = false, updatable = false)
    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }


    @ManyToOne
    @JoinColumn(name = "size_id",nullable = false, insertable = false, updatable = false)
    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @ManyToOne
    @JoinColumn(name = "frosting_id", insertable = false, updatable = false)
    public Frosting getFrosting() {
        return frosting;
    }

    public void setFrosting(Frosting frosting) {
        this.frosting = frosting;
    }



    @ManyToOne
    @JoinColumn(name = "filling_id", insertable = false, updatable = false)
    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }



    @ManyToOne
    @JoinColumn(name = "flavor_id", nullable = false, insertable = false, updatable = false)
    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }



    @ManyToOne
    @JoinColumn(name = "order_line_id", nullable = false, insertable = false, updatable = false)
    public Orderline getOrderline() {
        return orderline;
    }

    public void setOrderline(Orderline orderline) {
        this.orderline = orderline;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_layer_id")
    public int getProductLayerId() {
        return productLayerId;
    }

    public void setProductLayerId(int productLayerId) {
        this.productLayerId = productLayerId;
    }

    @Basic
    @Column(name = "order_line_id")
    public int getOrderlineId() {
        return orderlineId;
    }

    public void setOrderlineId(int orderlineId) {
        this.orderlineId = orderlineId;
    }

    @Basic
    @Column(name = "flavor_id")
    public int getFlavorId() {
        return flavorId;
    }

    public void setFlavorId(int flavorId) {
        this.flavorId = flavorId;
    }

    @Basic
    @Column(name = "filling_id")
    public int getFillingId() {
        return fillingId;
    }

    public void setFillingId(int fillingId) {
        this.fillingId = fillingId;
    }

    @Basic
    @Column(name = "frosting_id")

    public int getFrostingId() {
        return frostingId;
    }

    public void setFrostingId(int frostingId) {
        this.frostingId = frostingId;
    }

    @Basic
    @Column(name = "size_id")
    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    @Basic
    @Column(name = "shape_id")
    public int getShapeId() {
        return shapeId;
    }

    public void setShapeId(int shapeId) {
        this.shapeId = shapeId;
    }


    @Basic
    @Column(name = "layer_number")
    public int getLayerNumber() {
        return layerNumber;
    }

    public void setLayerNumber(int layerNumber) {
        this.layerNumber = layerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLayer that = (ProductLayer) o;
        return productLayerId == that.productLayerId &&
                orderlineId == that.orderlineId &&
                flavorId == that.flavorId &&
                fillingId == that. fillingId &&
                frostingId == that.frostingId &&
                sizeId == that.sizeId &&
                shapeId == that. shapeId &&
                layerNumber == that.layerNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productLayerId, orderlineId, flavorId, fillingId, frostingId, sizeId, shapeId, layerNumber);
    }


}
