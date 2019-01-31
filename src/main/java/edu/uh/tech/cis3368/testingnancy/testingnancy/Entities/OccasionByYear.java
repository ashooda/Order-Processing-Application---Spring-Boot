package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class OccasionByYear {
    private int orderLineId;
    private String occasion;
    private String customerFirstName;
    private String customerLastName;
    private String productType;
    private Date orderCompletedDate;
    private double orderTotalPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_id")
    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    @Basic
    @Column(name = "Occasion")
    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    @Basic
    @Column(name = "Customer First Name")
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    @Basic
    @Column(name = "Customer Last Name")
    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    @Basic
    @Column(name = "Product Type")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "Order Completed Date")
    public Date getOrderCompletedDate() {
        return orderCompletedDate;
    }

    public void setOrderCompletedDate(Date orderCompletedDate) {
        this.orderCompletedDate = orderCompletedDate;
    }

    @Basic
    @Column(name = "Order Total Price")
    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OccasionByYear that = (OccasionByYear) o;
        return orderLineId == that.orderLineId &&
                Double.compare(that.orderTotalPrice, orderTotalPrice) == 0 &&
                Objects.equals(occasion, that.occasion) &&
                Objects.equals(customerFirstName, that.customerFirstName) &&
                Objects.equals(customerLastName, that.customerLastName) &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(orderCompletedDate, that.orderCompletedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineId, occasion, customerFirstName, customerLastName, productType, orderCompletedDate, orderTotalPrice);
    }
}
