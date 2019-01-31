package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_line_status", schema = "dbo", catalog = "Complete_DB_V_3")
public class OrderLineStatus {
    private int orderLineStatusId;
    private String orderLineStatus;
    private Set<Orderline> orderlines;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderLineStatus", cascade = CascadeType.ALL)
    public Set<Orderline> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(Set<Orderline> orderlines) {
        //orderlines.forEach(orderline -> orderline.setOrderLineStatus(this));
        this.orderlines = orderlines;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_status_id")
    public int getOrderLineStatusId() {
        return orderLineStatusId;
    }

    public void setOrderLineStatusId(int orderLineStatusId) {
        this.orderLineStatusId = orderLineStatusId;
    }

    @Basic
    @Column(name = "order_line_status")
    public String getOrderLineStatus() {
        return orderLineStatus;
    }

    public void setOrderLineStatus(String orderLineStatus) {
        this.orderLineStatus = orderLineStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineStatus that = (OrderLineStatus) o;
        return orderLineStatusId == that.orderLineStatusId &&
                Objects.equals(orderLineStatus, that.orderLineStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineStatusId, orderLineStatus);
    }


}
