package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Filling {
    private int fillingId;
    private int fillingStatusId;
    private String fillingType;
    private Set<ProductLayer> productLayers;
    FillingStatus fillingStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "filling", cascade = CascadeType.ALL)
    public Set<ProductLayer> getProductLayers() {
        return productLayers;
    }

    public void setProductLayers(Set<ProductLayer> productLayers) {
        //productLayers.forEach(productLayer -> productLayer.setFilling(this));
        this.productLayers = productLayers;
    }




    @ManyToOne
    @JoinColumn(name = "filling_status_id", nullable = false, insertable = false, updatable = false)
    public FillingStatus getFillingStatus() {
        return fillingStatus;
    }

    public void setFillingStatus(FillingStatus fillingStatus) {
        this.fillingStatus = fillingStatus;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filling_id")
    public int getFillingId() {
        return fillingId;
    }

    public void setFillingId(int fillingId) {
        this.fillingId = fillingId;
    }

    @Basic
    @Column(name = "filling_status_id")
    public int getFillingStatusId() {
        return fillingStatusId;
    }

    public void setFillingStatusId(int fillingStatusId) {
        this.fillingStatusId = fillingStatusId;
    }


    @Basic
    @Column(name = "filling_type")
    public String getFillingType() {
        return fillingType;
    }

    public void setFillingType(String fillingType) {
        this.fillingType = fillingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filling filling = (Filling) o;
        return fillingId == filling.fillingId &&
                fillingStatusId == filling.fillingStatusId &&
                Objects.equals(fillingType, filling.fillingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fillingId, fillingStatusId, fillingType);
    }





}
