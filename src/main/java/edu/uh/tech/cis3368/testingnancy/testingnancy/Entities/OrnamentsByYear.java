package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrnamentsByYear {
    private int orderId;
    private String customerFirstName;
    private String customerLastName;
    private int ornamentId;
    private String ornamentType;
    private String ornamentColor;
    private String ornamentSize;

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
    @Column(name = "ornament_id")
    public int getOrnamentId() {
        return ornamentId;
    }

    public void setOrnamentId(int ornamentId) {
        this.ornamentId = ornamentId;
    }

    @Basic
    @Column(name = "ornament_type")
    public String getOrnamentType() {
        return ornamentType;
    }

    public void setOrnamentType(String ornamentType) {
        this.ornamentType = ornamentType;
    }

    @Basic
    @Column(name = "ornament_color")
    public String getOrnamentColor() {
        return ornamentColor;
    }

    public void setOrnamentColor(String ornamentColor) {
        this.ornamentColor = ornamentColor;
    }

    @Basic
    @Column(name = "ornament_size")
    public String getOrnamentSize() {
        return ornamentSize;
    }

    public void setOrnamentSize(String ornamentSize) {
        this.ornamentSize = ornamentSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrnamentsByYear that = (OrnamentsByYear) o;
        return orderId == that.orderId &&
                ornamentId == that.ornamentId &&
                Objects.equals(customerFirstName, that.customerFirstName) &&
                Objects.equals(customerLastName, that.customerLastName) &&
                Objects.equals(ornamentType, that.ornamentType) &&
                Objects.equals(ornamentColor, that.ornamentColor) &&
                Objects.equals(ornamentSize, that.ornamentSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerFirstName, customerLastName, ornamentId, ornamentType, ornamentColor, ornamentSize);
    }
}
