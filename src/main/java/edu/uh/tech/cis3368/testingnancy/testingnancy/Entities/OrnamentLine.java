package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ornament_line", schema = "dbo", catalog = "Complete_DB_V_3")
public class OrnamentLine {
    private int ornamentLineId;
    private int ornamentId;
    private int oderId;
    private int ornamentQuantity;
    Ornament ornament;
    Orders orders;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }


    @ManyToOne
    @JoinColumn(name = "ornament_id", nullable = false, insertable = false, updatable = false)
    public Ornament getOrnament() {
        return ornament;
    }

    public void setOrnament(Ornament ornament) {
        this.ornament = ornament;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ornament_line_id")
    public int getOrnamentLineId() {
        return ornamentLineId;
    }

    public void setOrnamentLineId(int ornamentLineId) {
        this.ornamentLineId = ornamentLineId;
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
    @Column(name = "order_id")
    public int getOderId() {
        return oderId;
    }

    public void setOderId(int oderId) {
        this.oderId = oderId;
    }


    @Basic
    @Column(name = "ornament_quantity")
    public int getOrnamentQuantity() {
        return ornamentQuantity;
    }

    public void setOrnamentQuantity(int ornamentQuantity) {
        this.ornamentQuantity = ornamentQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrnamentLine that = (OrnamentLine) o;
        return ornamentLineId == that.ornamentLineId &&
                ornamentId == that.ornamentId &&
                oderId == that.oderId &&
                ornamentQuantity == that.ornamentQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ornamentLineId, ornamentId, oderId, ornamentQuantity);
    }


}
