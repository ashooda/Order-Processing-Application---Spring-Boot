package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class RevByQuarter {
    private int orderLineId;
    private String occasionType;
    private String orderStatus;
    private Date orderCompletedDate;
    private double orderTotalPrice;
    private Double revenue;

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
    @Column(name = "occasion_type")
    public String getOccasionType() {
        return occasionType;
    }

    public void setOccasionType(String occasionType) {
        this.occasionType = occasionType;
    }

    @Basic
    @Column(name = "order_status")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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
    @Column(name = "order_total_price")
    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    @Basic
    @Column(name = "REVENUE")
    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevByQuarter that = (RevByQuarter) o;
        return orderLineId == that.orderLineId &&
                Double.compare(that.orderTotalPrice, orderTotalPrice) == 0 &&
                Objects.equals(occasionType, that.occasionType) &&
                Objects.equals(orderStatus, that.orderStatus) &&
                Objects.equals(orderCompletedDate, that.orderCompletedDate) &&
                Objects.equals(revenue, that.revenue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineId, occasionType, orderStatus, orderCompletedDate, orderTotalPrice, revenue);
    }
}
