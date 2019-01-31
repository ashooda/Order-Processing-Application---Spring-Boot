package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Size {
    private int sizeId;
    private int sizeStatusId;
    private String sizeDimension;
    private int sizeServing;
    SizeStatus sizeStatus;
    private Set<ProductLayer> productLayers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "size", cascade = CascadeType.ALL)
    public Set<ProductLayer> getProductLayers() {
        return productLayers;
    }

    public void setProductLayers(Set<ProductLayer> productLayers) {
        //  productLayers.forEach(productLayer -> productLayer.setSize(this));
        this.productLayers = productLayers;
    }

    @ManyToOne
    @JoinColumn(name = "size_status_id", nullable = false, insertable = false, updatable = false)
    public SizeStatus getSizeStatus() {
        return sizeStatus;
    }

    public void setSizeStatus(SizeStatus sizeStatus) {
        this.sizeStatus = sizeStatus;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_id")
    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    @Basic
    @Column(name = "size_status_id")
    public int getSizeStatusId() {
        return sizeStatusId;
    }

    public void setSizeStatusId(int sizeStatusId) {
        this.sizeStatusId = sizeStatusId;
    }


    @Basic
    @Column(name = "size_dimension")
    public String getSizeDimension() {
        return sizeDimension;
    }

    public void setSizeDimension(String sizeDimension) {
        this.sizeDimension = sizeDimension;
    }

    @Basic
    @Column(name = "size_serving")
    public int getSizeServing() {
        return sizeServing;
    }

    public void setSizeServing(int sizeServing) {
        this.sizeServing = sizeServing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return sizeId == size.sizeId &&
                sizeStatusId == size.sizeStatusId &&
                sizeServing == size.sizeServing &&
                Objects.equals(sizeDimension, size.sizeDimension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeId, sizeStatusId, sizeDimension, sizeServing);
    }

}
