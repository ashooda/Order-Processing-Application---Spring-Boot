package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class ProductSizeMonth {
    private int orderId;
    private String productType;
    private String sizeDimension;
    private Date orderCompletedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "product_type")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "size_dimension")
    public String getSizeDimension() {
        return sizeDimension;
    }

    public void setSizeDimension(String sizeDimension) {
        this.sizeDimension = sizeDimension;
    }

    @Basic
    @Column(name = "order_completed_date")
    public Date getOrderCompletedDate() {
        return orderCompletedDate;
    }

    public void setOrderCompletedDate(Date orderCompletedDate) {
        this.orderCompletedDate = orderCompletedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSizeMonth that = (ProductSizeMonth) o;
        return orderId == that.orderId &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(sizeDimension, that.sizeDimension) &&
                Objects.equals(orderCompletedDate, that.orderCompletedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productType, sizeDimension, orderCompletedDate);
    }
}
