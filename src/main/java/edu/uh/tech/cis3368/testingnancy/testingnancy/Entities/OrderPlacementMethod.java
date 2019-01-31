package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_placement_method", schema = "dbo", catalog = "Complete_DB_V_3")
public class OrderPlacementMethod {
    private int orderPlacementMethodId;
    private String orderPlacementMethod;
    private Set<Orders> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderPlacementMethod", cascade = CascadeType.ALL)
    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        //orders.forEach(orders1 -> orders1.setOrderPlacementMethod(this));
        this.orders = orders;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_placement_method_id")
    public int getOrderPlacementMethodId() {
        return orderPlacementMethodId;
    }

    public void setOrderPlacementMethodId(int orderPlacementMethodId) {
        this.orderPlacementMethodId = orderPlacementMethodId;
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
        OrderPlacementMethod that = (OrderPlacementMethod) o;
        return orderPlacementMethodId == that.orderPlacementMethodId &&
                Objects.equals(orderPlacementMethod, that.orderPlacementMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderPlacementMethodId, orderPlacementMethod);
    }


}
