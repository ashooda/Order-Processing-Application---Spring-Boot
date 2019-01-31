package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Frosting {
    private int frostingId;
    private int frostingStatusId;
    private String frostingType;
    private Set<ProductLayer> productLayers;
    FrostingStatus frostingStatus;

    @ManyToOne
    @JoinColumn(name = "frosting_status_id", nullable = false, insertable = false, updatable = false)
    public FrostingStatus getFrostingStatus() {
        return frostingStatus;
    }

    public void setFrostingStatus(FrostingStatus frostingStatus) {
        this.frostingStatus = frostingStatus;
    }



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "frosting", cascade = CascadeType.ALL)
    public Set<ProductLayer> getProductLayers() {
        return productLayers;
    }

    public void setProductLayers(Set<ProductLayer> productLayers) {
        // productLayers.forEach(productLayer -> productLayer.setFrosting(this));
        this.productLayers = productLayers;
    }

    public Frosting() {
    }

    public Frosting(int frostingStatusId, String frostingType) {
        this.frostingStatusId = frostingStatusId;
        this.frostingType = frostingType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "frosting_id")
    public int getFrostingId() {
        return frostingId;
    }

    public void setFrostingId(int frostingId) {
        this.frostingId = frostingId;
    }

    @Basic
    @Column(name = "frosting_status_id")
    public int getFrostingStatusId() {
        return frostingStatusId;
    }

    public void setFrostingStatusId(int frostingStatusId) {
        this.frostingStatusId = frostingStatusId;
    }


    @Basic
    @Column(name = "frosting_type")
    public String getFrostingType() {
        return frostingType;
    }

    public void setFrostingType(String frostingType) {
        this.frostingType = frostingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frosting frosting = (Frosting) o;
        return frostingId == frosting.frostingId &&
                frostingStatusId == frosting.frostingStatusId &&
                Objects.equals(frostingType, frosting.frostingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frostingId, frostingStatusId, frostingType);
    }




}
