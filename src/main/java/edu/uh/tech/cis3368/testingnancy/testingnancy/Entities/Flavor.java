package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Flavor {
    private int flavorId;
    private int flavorStatusId;
    private Set<ProductLayer> productLayers;
    private String flavorType;
    FlavorStatus flavorStatus;

    @ManyToOne
    @JoinColumn(name = "flavor_status_id", nullable = false, insertable = false, updatable = false)
    public FlavorStatus getFlavorStatus() {
        return flavorStatus;
    }

    public void setFlavorStatus(FlavorStatus flavorStatus) {
        this.flavorStatus = flavorStatus;
    }



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flavor", cascade = CascadeType.ALL)
    public Set<ProductLayer> getProductLayers() {
        return productLayers;
    }

    public void setProductLayers(Set<ProductLayer> productLayers) {
        // productLayers.forEach(productLayer -> productLayer.setFlavor(this));
        this.productLayers = productLayers;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flavor_id")
    public int getFlavorId() {
        return flavorId;
    }

    public void setFlavorId(int flavorId) {
        this.flavorId = flavorId;
    }

    @Basic
    @Column(name = "flavor_status_id")
    public int getFlavorStatusId() {
        return flavorStatusId;
    }

    public void setFlavorStatusId(int flavorStatusId) {
        this.flavorStatusId = flavorStatusId;
    }

    @Basic
    @Column(name = "flavor_type")
    public String getFlavorType() {
        return flavorType;
    }

    public void setFlavorType(String flavorType) {
        this.flavorType = flavorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flavor flavor = (Flavor) o;
        return flavorId == flavor.flavorId &&
                flavorStatusId == flavor.flavorStatusId &&
                Objects.equals(flavorType, flavor.flavorType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavorId, flavorStatusId, flavorType);
    }




}
