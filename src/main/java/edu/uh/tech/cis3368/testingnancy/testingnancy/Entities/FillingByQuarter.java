package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class FillingByQuarter {
    private int orderId;
    private String productType;
    private Date orderCompletedDate;
    private String fillingType;

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
    @Column(name = "order_completed_date")
    public Date getOrderCompletedDate() {
        return orderCompletedDate;
    }

    public void setOrderCompletedDate(Date orderCompletedDate) {
        this.orderCompletedDate = orderCompletedDate;
    }

    @Basic
    @Column(name = "filling_type")
    public String getFillingType() {
        return fillingType;
    }

    public void setFillingType(String fillingType) {
        this.fillingType = fillingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FillingByQuarter that = (FillingByQuarter) o;
        return orderId == that.orderId &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(orderCompletedDate, that.orderCompletedDate) &&
                Objects.equals(fillingType, that.fillingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productType, orderCompletedDate, fillingType);
    }
}
