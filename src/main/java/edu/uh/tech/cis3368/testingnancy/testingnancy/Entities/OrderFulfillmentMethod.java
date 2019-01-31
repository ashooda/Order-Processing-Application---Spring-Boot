package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_fulfillment_method", schema = "dbo", catalog = "Complete_DB_V_3")
public class OrderFulfillmentMethod {
    private int orderFulfillmentMethodId;
    private String orderFulfillementMethod;
    private Set<Orders> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderFulfillmentMethod", cascade = CascadeType.ALL)
    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        // orders.forEach(orders1 -> orders1.setOrderFulfillmentMethod(this));
        this.orders = orders;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_fulfillment_method_id")
    public int getOrderFulfillmentMethodId() {
        return orderFulfillmentMethodId;
    }

    public void setOrderFulfillmentMethodId(int orderFulfillmentMethodId) {
        this.orderFulfillmentMethodId = orderFulfillmentMethodId;
    }

    @Basic
    @Column(name = "order_fulfillement_method")
    public String getOrderFulfillementMethod() {
        return orderFulfillementMethod;
    }

    public void setOrderFulfillementMethod(String orderFulfillementMethod) {
        this.orderFulfillementMethod = orderFulfillementMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderFulfillmentMethod that = (OrderFulfillmentMethod) o;
        return orderFulfillmentMethodId == that.orderFulfillmentMethodId &&
                Objects.equals(orderFulfillementMethod, that.orderFulfillementMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderFulfillmentMethodId, orderFulfillementMethod);
    }


}
