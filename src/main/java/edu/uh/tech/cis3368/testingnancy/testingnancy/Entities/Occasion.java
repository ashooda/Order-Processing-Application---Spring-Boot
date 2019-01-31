package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Occasion {
    private int occasionId;
    private String occasionType;
    private Set<Orders> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "occasion", cascade = CascadeType.ALL)
    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        //orders.forEach(orders1 -> orders1.setOccasion(this));
        this.orders = orders;
    }





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "occasion_id")
    public int getOccasionId() {
        return occasionId;
    }

    public void setOccasionId(int occasionId) {
        this.occasionId = occasionId;
    }

    @Basic
    @Column(name = "occasion_type")
    public String getOccasionType() {
        return occasionType;
    }

    public void setOccasionType(String occasionType) {
        this.occasionType = occasionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Occasion occasion = (Occasion) o;
        return occasionId == occasion.occasionId &&
                Objects.equals(occasionType, occasion.occasionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(occasionId, occasionType);
    }


}
