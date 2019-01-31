package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "flavor_status", schema = "dbo", catalog = "Complete_DB_V_3")
public class FlavorStatus {
    private int flavorStatusId;
    private String flavorStatus;

    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "flavorStatus", cascade = CascadeType.ALL)
    public Set<Flavor> getFlavors() {
        return flavors;
    }

    public void setFlavors(Set<Flavor> flavors) {
        //flavors.forEach(flavor -> flavor.setFlavorStatus(this));
        this.flavors = flavors;
    }

    private Set<Flavor> flavors;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flavor_status_id")
    public int getFlavorStatusId() {
        return flavorStatusId;
    }

    public void setFlavorStatusId(int flavorStatusId) {
        this.flavorStatusId = flavorStatusId;
    }

    @Basic
    @Column(name = "flavor_status")
    public String getFlavorStatus() {
        return flavorStatus;
    }

    public void setFlavorStatus(String flavorStatus) {
        this.flavorStatus = flavorStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlavorStatus that = (FlavorStatus) o;
        return flavorStatusId == that.flavorStatusId &&
                Objects.equals(flavorStatus, that.flavorStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavorStatusId, flavorStatus);
    }


}
