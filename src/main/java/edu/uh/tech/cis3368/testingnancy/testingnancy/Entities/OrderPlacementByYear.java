package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class OrderPlacementByYear {
    private String customerFirstName;
    private String customerLastName;
    private int customerId;
    private int orderId;
    private String customerStatus;
    private String customerType;
    private Date orderReceivedDate;
    private String orderPlacementMethod;

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
    @Column(name = "customer_first_name")
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    @Basic
    @Column(name = "customer_last_name")
    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    @Basic
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    @Basic
    @Column(name = "customer_status")
    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Basic
    @Column(name = "customer_type")
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Basic
    @Column(name = "order_received_date")
    public Date getOrderReceivedDate() {
        return orderReceivedDate;
    }

    public void setOrderReceivedDate(Date orderReceivedDate) {
        this.orderReceivedDate = orderReceivedDate;
    }

    @Basic
    @Column(name = "order_placement_method")
    public String getOrderPlacementMethod() {
        return orderPlacementMethod;
    }

    public void setOrderPlacementMethod(String orderPlacementMethod) {
        this.orderPlacementMethod = orderPlacementMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPlacementByYear that = (OrderPlacementByYear) o;
        return customerId == that.customerId &&
                orderId == that.orderId &&
                Objects.equals(customerFirstName, that.customerFirstName) &&
                Objects.equals(customerLastName, that.customerLastName) &&
                Objects.equals(customerStatus, that.customerStatus) &&
                Objects.equals(customerType, that.customerType) &&
                Objects.equals(orderReceivedDate, that.orderReceivedDate) &&
                Objects.equals(orderPlacementMethod, that.orderPlacementMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerFirstName, customerLastName, customerId, orderId, customerStatus, customerType, orderReceivedDate, orderPlacementMethod);
    }
}
